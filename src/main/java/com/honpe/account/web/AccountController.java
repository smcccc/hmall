package com.honpe.account.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.honpe.account.annotation.RequiredAuth;
import com.honpe.account.service.AccountService;
import com.honpe.account.service.AreaService;
import com.honpe.account.service.CompanyService;
import com.honpe.po.Account;
import com.honpe.po.Company;
import com.honpe.po.YxAreaTable;
import com.honpe.pojo.model.AccountInfoModel;
import com.honpe.pojo.vo.Result;
import com.honpe.utils.PasswordHelper;

@Controller
@RequestMapping("user")
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private AreaService areaService;
	private final int AREA_TOP_PARENT = 0;

	@GetMapping("/info")
	@RequiredAuth
	public String accountInfo(HttpServletRequest request) {
		Account customer = (Account) request.getSession().getAttribute("CUSTOMER");
		Account account = accountService.findAccountById(customer.getId());
		if (account != null) {
			Company company = companyService.findById(account.getComId());
			account.setLoginEmail(hideStr(account.getLoginEmail()));
			request.setAttribute("account", account);
			request.setAttribute("company", company);
		}
		if (account.getYatId() != null) {
			YxAreaTable area = areaService.findAreaById(account.getYatId());
			request.setAttribute("area", area);
			List<YxAreaTable> country = areaService.findAreaByParentId(area.getYatParentId());
			request.setAttribute("country", country);
		}
		List<YxAreaTable> areas = areaService.findAreaByParentId(AREA_TOP_PARENT);
		request.setAttribute("areas", areas);
		return "user";
	}

	private String hideStr(String str) {
		int indexOf = str.indexOf('@');
		StringBuffer stringBuffer = new StringBuffer(str);
		for (int i = str.length() - indexOf - 1; i < indexOf; i++) {
			stringBuffer.replace(i, i + 1, "*");
		}
		return stringBuffer.toString();
	}

	@PostMapping("/info/save")
	@RequiredAuth
	public @ResponseBody Result userInfoSave(AccountInfoModel accountInfoModel) {
		accountService.saveAccountInfo(accountInfoModel.getAccount(), accountInfoModel.getCompany());
		return new Result(200, null, null);
	}

	@GetMapping("/toreset")
	@RequiredAuth
	public String toResetPassword() {
		return "reset";
	}

	@PostMapping("/reset")
	@RequiredAuth
	public @ResponseBody Result resetPassword(String id, String password, String newPassword) {
		Account account = accountService.findAccountById(id);
		if (!account.getLoginPass().equals(PasswordHelper.getPwd(password, account.getSalt()))) {
			return new Result(403, null, null);
		}
		account.setLoginPass(PasswordHelper.getPwd(newPassword, account.getSalt()));
		accountService.resetPassword(account);
		return new Result(200, null, null);
	}
}
