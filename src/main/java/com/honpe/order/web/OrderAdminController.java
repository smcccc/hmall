package com.honpe.order.web;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.honpe.po.SysUser;
import com.honpe.user.service.SysUserService;

@Controller
@RequestMapping("/admin/order")
public class OrderAdminController {

	@Autowired
	private SysUserService userService;

	@GetMapping("/list")
	@RequiresPermissions("order:view:all")
	public String allOrderList(Model model) {
		List<SysUser> salesmans = userService.findAllSalesman();
		model.addAttribute("salesmans", salesmans);
		return "admin/order/order-list";
	}
}
