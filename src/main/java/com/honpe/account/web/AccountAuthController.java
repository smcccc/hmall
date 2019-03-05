package com.honpe.account.web;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContext;
import com.honpe.account.service.AccountService;
import com.honpe.po.Account;
import com.honpe.pojo.dto.CartDto;
import com.honpe.pojo.vo.Result;
import com.honpe.utils.CodeHelper;
import com.honpe.utils.EncryptUtils;
import com.honpe.utils.JsonUtils;
import com.honpe.utils.PasswordHelper;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

@Controller
public class AccountAuthController {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private CacheManager cacheManager;
	@Value("${web.domain}")
	private String domain;

	private void inputShippingCartNumber(HttpSession session) {
		Cache cartCache = cacheManager.getCache("shippingCartCache");
		Element element = cartCache.get(((Account) session.getAttribute("CUSTOMER")).getId());
		int cartNum = 0;
		if (element != null) {
			String cartjson = (String) element.getObjectValue();
			if (StringUtils.isNoneBlank(cartjson)) {
				List<CartDto> cart = JsonUtils.jsonToList(cartjson, CartDto.class);
				if (cart != null)
					cartNum = cart.size();
			}
		}
		session.setAttribute("CART_NUM", cartNum);
	}

	@PostMapping("/login")
	public @ResponseBody Result login(String loginEmail, String password, HttpServletRequest request) {
		Account account = accountService.findAccountByLoginEmail(loginEmail);
		RequestContext requestContext = new RequestContext(request);
		if (account == null)
			return new Result(403, requestContext.getMessage("login.error"), null);
		String pwd = PasswordHelper.getPwd(password.trim(), account.getSalt());
		if (!account.getLoginPass().equals(pwd))
			return new Result(403, requestContext.getMessage("login.error"), null);
		HttpSession session = request.getSession();
		session.setAttribute("CUSTOMER", account);
		inputShippingCartNumber(session);
		return new Result(200, null, null);
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("CUSTOMER");
		return "redirect:/index";
	}

	@PostMapping("/regist")
	public @ResponseBody Result regist(Account account, String companyName, String code, HttpServletRequest request)
			throws Exception {
		Result result = null;
		if (checkLoginEmailIsExist(account.getLoginEmail())) {
			RequestContext requestContext = new RequestContext(request);
			result = new Result(403, requestContext.getMessage("email.exist"), null);
			return result;
		}
		String salt = PasswordHelper.getSalt();
		String pwd = PasswordHelper.getPwd(account.getLoginPass(), salt);
		account.setSalt(salt);
		account.setLoginPass(pwd);
		RequestContext requestContext = new RequestContext(request);
		accountService.accountRegister(domain + request.getContextPath(), account, companyName, code,
				requestContext.getMessage("active.email.subject"));
		return new Result(200, null, null);
	}

	@GetMapping("/active")
	public String activeAccount(String email, String company, String certify, Model model) throws Exception {
		email = EncryptUtils.SINGLETON.decryptByAes(email);
		company = EncryptUtils.SINGLETON.decryptByAes(company);
		certify = EncryptUtils.SINGLETON.decryptByAes(certify);
		Account account = accountService.findAccountByEmailAndCertify(email, certify);
		if (account != null) {
			if (System.currentTimeMillis() - account.getRegisterTime().getTime() > 48 * 60 * 60 * 1000) {
				return "active-fail";
			} else {
				Boolean isActive = accountService.activeRegistAccount(account, company);
				if (isActive) {
					return "active-success";
				}
			}
		}
		return "active-fail";
	}

	@GetMapping("/captcha")
	public @ResponseBody Result emailCaptcha(String email, HttpServletRequest request) {
		Account account = accountService.findAccountByLoginEmail(email);
		if (account == null) {
			RequestContext requestContext = new RequestContext(request);
			return new Result(403, requestContext.getMessage("email.no.exist"), null);
		}
		String captcha = CodeHelper.createCode();
		account.setCaptcha(captcha);
		account.setCaptchaTime(new Date());
		RequestContext requestContext = new RequestContext(request);
		accountService.sendCaptchaToEmail(account, requestContext.getMessage("captcha.email.subject"));
		return new Result(200, null, null);
	}

	@PostMapping("/reset")
	public @ResponseBody Result resetPass(String email, String password, String captcha, HttpServletRequest request) {
		Account account = accountService.findAccountByEmailAndCaptcha(email, captcha);
		if (account == null) {
			RequestContext requestContext = new RequestContext(request);
			return new Result(403, requestContext.getMessage("captcha.error"), null);
		}
		if (System.currentTimeMillis() - account.getCaptchaTime().getTime() > 20 * 60 * 1000) {
			RequestContext requestContext = new RequestContext(request);
			return new Result(403, requestContext.getMessage("captcha.expire"), null);
		}
		account.setLoginPass(PasswordHelper.getPwd(password, account.getSalt()));
		account.setCaptchaTime(null);
		account.setCaptcha(null);
		accountService.resetPassword(account);
		return new Result(200, null, null);
	}

	private Boolean checkLoginEmailIsExist(String loginEmail) {
		Account account = accountService.findAccountByLoginEmail(loginEmail);
		return account != null;
	}
}
