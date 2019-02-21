package com.honpe.order.web;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.honpe.account.service.InvoiceService;
import com.honpe.log.annotation.RecordOperateLog;
import com.honpe.order.enums.OrderEnum;
import com.honpe.order.service.OrderDiscountService;
import com.honpe.order.service.OrderOperateService;
import com.honpe.order.service.OrderService;
import com.honpe.po.InvoiceInfo;
import com.honpe.po.OrderDiscount;
import com.honpe.po.OrderItem;
import com.honpe.po.OrderOperate;
import com.honpe.po.SysRole;
import com.honpe.po.SysUser;
import com.honpe.po.TbOrder;
import com.honpe.pojo.ext.OrderExt;
import com.honpe.pojo.vo.Result;
import com.honpe.pojo.vo.TableResult;
import com.honpe.role.service.RoleService;
import com.honpe.user.service.SysUserService;

@Controller
@RequestMapping("/admin/order")
public class OrderAdminController {

	@Autowired
	private SysUserService userService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderDiscountService orderDiscountService;
	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private OrderOperateService orderOperateService;
	@Autowired
	private RoleService roleService;

	private void recordOrderOperate(String orderId, String operation) {
		Session session = SecurityUtils.getSubject().getSession();
		SysUser user = (SysUser) session.getAttribute("SYS_USER");
		OrderOperate orderOperate = new OrderOperate();
		orderOperate.setOrderId(orderId);
		orderOperate.setOperation(operation);
		orderOperate.setOperationTime(new Date());
		orderOperate.setOperator(user.getUserName());
		orderOperate.setOperatorAccount(user.getLoginAccount());
		SysRole role = roleService.findSysUserRoles(user.getUserId());
		orderOperate.setRole(role.getRoleName());
		orderOperateService.recordOrderOperate(orderOperate);
	}

	@GetMapping("/list")
	@RequiresPermissions("order:view:all")
	public String allOrderList(Model model) {
		List<SysUser> salesmans = userService.findAllSalesman();
		model.addAttribute("salesmans", salesmans);
		return "admin/order/order-list";
	}

	@GetMapping("/list-json")
	@RequiresPermissions("order:view:all")
	public @ResponseBody TableResult<OrderExt> allOrders(Integer page, Integer pageSize, String search,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate, Integer salesmanId, Byte status) {
		PageInfo<OrderExt> pageInfo = orderService.findAllOrderByCondition(page, pageSize, search, beginDate, endDate,
				salesmanId, status);
		return new TableResult<OrderExt>(pageInfo.getTotal(), pageInfo.getList());
	}

	@GetMapping("/my/list-json")
	@RequiresPermissions("order:view")
	public @ResponseBody TableResult<OrderExt> myAllOrders(Integer page, Integer pageSize, String search,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate, Byte status) {
		SysUser salesman = (SysUser) SecurityUtils.getSubject().getSession().getAttribute("SYS_USER");
		PageInfo<OrderExt> pageInfo = orderService.findAllOrderByCondition(page, pageSize, search, beginDate, endDate,
				salesman.getUserId(), status);
		return new TableResult<OrderExt>(pageInfo.getTotal(), pageInfo.getList());
	}

	@GetMapping("/operate/list-json")
	@RequiresPermissions("order:detail")
	public @ResponseBody List<OrderOperate> orderOperateRecorads(String orderId) {
		return orderOperateService.findAllByOrderId(orderId);
	}

	@GetMapping("/discount/check-input")
	@RequiresPermissions("order:discount:check")
	public String orderDiscountCheckForm(String orderId, Model model) {
		OrderDiscount discount = orderDiscountService.findByOrderId(orderId);
		model.addAttribute("discount", discount);
		return "admin/order/check-discount";
	}

	@PostMapping("/discount/check")
	@RequiresPermissions("order:discount:check")
	@RecordOperateLog(operate = "订单优惠申请审批")
	public @ResponseBody Result OrderDiscountCheck(String orderId, Byte status, String refuseReason) {
		orderDiscountService.checkOrderDiscount(orderId, status, refuseReason);
		return new Result(200, null, null);
	}

	@GetMapping("/detail")
	@RequiresPermissions("order:detail")
	public String orderDetail(String orderId, Model model) {
		Map<String, Object> map = orderService.findOrderDetailByOrderId(orderId);
		TbOrder order = (TbOrder) map.get("order");
		model.addAllAttributes(map);
		model.addAttribute("statusInfo", OrderEnum.getInstance(order.getStatus()).statusInfo);
		OrderDiscount discount = orderDiscountService.findByOrderId(orderId);
		model.addAttribute("discount", discount);
		InvoiceInfo invoice = invoiceService.findOneById(order.getInvoiceId());
		model.addAttribute("invoice", invoice);
		return "admin/order/order-detail";
	}

	@GetMapping("/items/list-json")
	@RequiresPermissions("order:detail")
	public @ResponseBody List<OrderItem> findOrderItems(String orderId) {
		return orderService.findOrderItems(orderId);
	}

	@PostMapping("/payment/sure")
	@RequiresPermissions("order:payment:sure")
	public @ResponseBody Result orderPaymentSure(String orderId) {
		orderService.orderPaymentSure(orderId);
		recordOrderOperate(orderId, "确认付款");
		return new Result(200, null, null);
	}

	@PostMapping("/item/warehousing")
	@RequiresPermissions("order:store")
	public @ResponseBody Result orderItemWarehousing(String orderId, String orderItemId, Integer storeNumber) {
		Boolean isAllEnter = orderService.orderItemsEnterStore(orderId, orderItemId, storeNumber);
		if (isAllEnter) {
			recordOrderOperate(orderId, "订单入库");
		}
		return new Result(200, null, isAllEnter);
	}

	@PostMapping("/exit/store")
	@RequiresPermissions("order:store")
	public @ResponseBody Result orderExitStoreSure(String orderId) {
		orderService.orderExitStoreSure(orderId);
		recordOrderOperate(orderId, "订单出库");
		return new Result(200, null, null);
	}

	@PostMapping("/waiting/deliver")
	@RequiresPermissions("order:deliver")
	public @ResponseBody Result orderWaitingDeliver(String orderId) {
		orderService.orderWaitingDeliver(orderId);
		recordOrderOperate(orderId, "确认订单出库");
		return new Result(200, null, null);
	}

	@PostMapping("/deliver/sure")
	@RequiresPermissions("order:deliver")
	public @ResponseBody Result orderDeliverSure(String orderId, String shippingName, String shippingCode) {
		orderService.orderDeliverSure(orderId, shippingName, shippingCode);
		recordOrderOperate(orderId, "订单发货");
		return new Result(200, null, null);
	}
}
