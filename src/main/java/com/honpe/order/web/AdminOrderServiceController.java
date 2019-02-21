package com.honpe.order.web;

import java.util.Date;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.honpe.account.service.AccountService;
import com.honpe.account.service.CompanyService;
import com.honpe.account.service.OrderShippingService;
import com.honpe.order.service.ItemApplyService;
import com.honpe.order.service.OrderItemService;
import com.honpe.order.service.OrderService;
import com.honpe.po.Account;
import com.honpe.po.Company;
import com.honpe.po.ItemServiceApply;
import com.honpe.po.OrderItem;
import com.honpe.po.OrderShipping;
import com.honpe.po.SysUser;
import com.honpe.po.TbOrder;
import com.honpe.pojo.dto.ItemServiceApplyDto;
import com.honpe.pojo.ext.ItemServiceApplyExt;
import com.honpe.pojo.vo.Result;
import com.honpe.pojo.vo.TableResult;
import com.honpe.user.service.SysUserService;

@Controller
@RequestMapping("/admin/order/service")
public class AdminOrderServiceController {

	@Autowired
	private ItemApplyService itemApplyService;
	@Autowired
	private SysUserService userService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderShippingService orderShippingService;
	@Autowired
	private OrderItemService orderItemService;

	@GetMapping("/list")
	@RequiresPermissions("service:view")
	public String applyList(Model model) {
		List<SysUser> salesmans = userService.findAllSalesman();
		model.addAttribute("salesmans", salesmans);
		return "admin/order/order-service-list";
	}

	@GetMapping("/list-json")
	@RequiresPermissions("service:view")
	public @ResponseBody TableResult<ItemServiceApplyExt> allApply(Integer page, Integer pageSize, String search,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate, Byte status, Integer salesmanId) {
		PageInfo<ItemServiceApplyExt> pageInfo = itemApplyService.findAllByConditions(page, pageSize, search, beginDate,
				endDate, status, salesmanId);
		return new TableResult<ItemServiceApplyExt>(pageInfo.getTotal(), pageInfo.getList());
	}

	@GetMapping("/detail")
	@RequiresPermissions("service:detail")
	public String applyDetail(String orderItemId, Model model) {
		ItemServiceApplyDto detail = itemApplyService.findApplyDetail(orderItemId);
		ItemServiceApply service = detail.getItemServiceApply();
		Account account = accountService.findAccountById(service.getBuyerId());
		Company company = companyService.findById(account.getComId());
		TbOrder order = orderService.findBuyerOrderById(service.getOrderId(), service.getBuyerId());
		OrderShipping shipping = orderShippingService.findById(order.getOrderShippingId());
		OrderItem orderItem = orderItemService.findOrderItem(service.getOrderId(), service.getItemId());
		model.addAttribute("orderItem", orderItem);
		model.addAttribute("service", service);
		model.addAttribute("vouchers", detail.getVouchers());
		model.addAttribute("order", order);
		model.addAttribute("company", company.getCompanyName());
		model.addAttribute("shipping", shipping);
		return "admin/order/order-service-detail";
	}

	@PostMapping("/approval")
	@RequiresPermissions("service:approval")
	public @ResponseBody Result approvalApply(String orderItemId, Byte status) {
		itemApplyService.approvalApply(orderItemId, status);
		return new Result(200, null, null);
	}

	@PostMapping("/deliver")
	@RequiresPermissions("service:handle")
	public @ResponseBody Result deliverApplyItem(String orderItemId, String shippingName, String shippingCode) {
		itemApplyService.deliverApplyItem(orderItemId, shippingName, shippingCode);
		return new Result(200, null, null);
	}
}
