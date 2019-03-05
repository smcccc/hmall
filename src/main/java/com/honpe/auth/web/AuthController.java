package com.honpe.auth.web;

import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.honpe.account.service.AccountService;
import com.honpe.count.service.CountService;
import com.honpe.inquiry.service.InquiryService;
import com.honpe.menu.service.MenuService;
import com.honpe.order.service.OrderService;
import com.honpe.po.SysMenu;
import com.honpe.po.SysUser;
import com.honpe.pojo.ext.OrderExt;
import com.honpe.pojo.vo.Result;
import com.honpe.utils.JsonUtils;

@Controller
@RequestMapping("admin")
public class AuthController {

	@Autowired
	private MenuService menuService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private CountService countService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private InquiryService inquiryService;

	private void inputEchartsData(Model model) throws ParseException {
		HashMap<String, Object> map = new HashMap<>();
		long[] orderCount = orderService.findOrderNumberOfCurrentWeek();
		long[] inquiryCount = inquiryService.findInquiryNumberOfCurrentWeek();
		model.addAttribute("orderCount", JsonUtils.objectToJson(orderCount));
		model.addAttribute("inquiryCount", JsonUtils.objectToJson(inquiryCount));
		Arrays.sort(orderCount);
		model.addAttribute("orderMax", orderCount[orderCount.length - 1]);
		Arrays.sort(inquiryCount);
		model.addAttribute("inquiryMax", inquiryCount[inquiryCount.length - 1]);
	}

	@PostMapping("/login")
	public @ResponseBody Result login(HttpServletRequest req, Model model) {
		String exceptionClassName = (String) req.getAttribute("shiroLoginFailure");
		String error = null;
		if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
			error = "用户名/密码不正确";
		} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
			error = "用户名/密码不正确";
		} else if (LockedAccountException.class.getName().equals(exceptionClassName)) {
			error = "用户已被锁定";
		} else if (DisabledAccountException.class.getName().equals(exceptionClassName)) {
			error = "用户已注销";
		} else if (ExcessiveAttemptsException.class.getName().equals(exceptionClassName)) {
			error = "重试次数过多，帐号已经锁定，请联系管理员解锁";
		} else if (exceptionClassName != null) {
			error = "错误提示：" + exceptionClassName;
		}
		if (error != null) {
			return new Result(403, error, null);
		}
		return new Result(200, null, null);
	}

	@GetMapping("/index")
	public String index(HttpSession session, Model model) {
		SysUser sysUser = (SysUser) session.getAttribute("SYS_USER");
		Map<SysMenu, List<SysMenu>> menu = menuService.findSysUserMenu(sysUser.getUserId());
		model.addAttribute("menu", menu);
		return "admin/index";
	}

	@GetMapping("/index_v1")
	public String indexV(String search, Model model) throws ParseException {
		Long visit = countService.findIndexVisitCount();
		Long registed = accountService.findCurrentMonthRegistered();
		long orderNum = orderService.findCurentMonthAddedNumber();
		long inquiryNum = inquiryService.findCurrentMonthAddedNumber();
		model.addAttribute("inquiryNum", inquiryNum);
		model.addAttribute("orderNum", orderNum);
		model.addAttribute("registed", registed);
		model.addAttribute("visit", visit);
		inputEchartsData(model);
		return "admin/index_v1";
	}

	@GetMapping("/order/json")
	public @ResponseBody Result findOrders(String orderId) {
		SysUser user = (SysUser) SecurityUtils.getSubject().getSession().getAttribute("SYS_USER");
		List<OrderExt> orders = orderService.findOrdersLikeOrderId(orderId, user.getUserId());
		return new Result(200, null, orders);
	}

	@GetMapping("/logout")
	public String logout() {
		return "admin/login";
	}
}
