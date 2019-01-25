package com.honpe.auth.web;

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
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.honpe.menu.service.MenuService;
import com.honpe.po.SysMenu;
import com.honpe.po.SysUser;
import com.honpe.pojo.vo.Result;

@Controller
@RequestMapping("admin")
public class AuthController {

	@Autowired
	private MenuService menuService;

	@RequestMapping("/login")
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

	@RequestMapping("/index")
	public String index(HttpSession session, Model model) {
		SysUser sysUser = (SysUser) session.getAttribute("SYS_USER");
		Map<SysMenu, List<SysMenu>> menu = menuService.findSysUserMenu(sysUser.getUserId());
		model.addAttribute("menu", menu);
		return "admin/index";
	}

	@RequestMapping("/logout")
	public String logout() {
		return "admin/login";
	}
}
