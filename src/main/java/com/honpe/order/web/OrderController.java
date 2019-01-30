package com.honpe.order.web;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.honpe.account.annotation.RequiredAuth;
import com.honpe.account.service.InvoiceService;
import com.honpe.account.service.OrderShippingService;
import com.honpe.constant.Constant;
import com.honpe.inquiry.service.InquiryMaterielService;
import com.honpe.order.service.OrderDiscountService;
import com.honpe.order.service.OrderOperateService;
import com.honpe.order.service.OrderService;
import com.honpe.po.Account;
import com.honpe.po.DictInfo;
import com.honpe.po.InquiryMateriel;
import com.honpe.po.InvoiceInfo;
import com.honpe.po.OrderDiscount;
import com.honpe.po.OrderOperate;
import com.honpe.po.OrderPayment;
import com.honpe.po.OrderShipping;
import com.honpe.po.TbOrder;
import com.honpe.pojo.dto.CartDto;
import com.honpe.pojo.ext.OrderExt;
import com.honpe.pojo.model.OrderConditionModel;
import com.honpe.pojo.model.OrderModel;
import com.honpe.pojo.vo.Result;

@Controller
@RequestMapping("order")
public class OrderController {

	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private OrderShippingService orderShippingService;
	@Autowired
	private InquiryMaterielService InquiryMaterielService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderOperateService orderOperateService;
	@Autowired
	private OrderDiscountService orderDiscountService;

	private Account getCustomer(HttpServletRequest request) {
		return (Account) request.getSession().getAttribute("CUSTOMER");
	}

	private void inputSelectData(HttpServletRequest request, String customerId) {
		List<OrderShipping> address = orderShippingService.findAllAddressByAccountId(customerId);
		InvoiceInfo invoice = invoiceService.findDefaultByCustomerId(customerId);
		request.setAttribute("address", address);
		request.setAttribute("invoice", invoice);
		Map<String, List<DictInfo>> orderDictInfo = orderService.getOrderDictInfo();
		orderDictInfo.entrySet().forEach(item -> request.setAttribute(item.getKey(), item.getValue()));
	}

	private void recordOrderOperate(Account customer, String orderId, String operation) {
		OrderOperate orderOperate = new OrderOperate();
		orderOperate.setOrderId(orderId);
		orderOperate.setOperation(operation);
		orderOperate.setOperationTime(new Date());
		orderOperate.setOperator(customer.getUserName());
		orderOperate.setOperatorAccount(customer.getLoginEmail());
		orderOperate.setRole("客户");
		orderOperateService.recordOrderOperate(orderOperate);
	}

	@GetMapping("/my/list")
	@RequiredAuth
	public String myOrderList(@RequestParam(defaultValue = "1") Integer page, OrderConditionModel condition,
			HttpServletRequest request) throws ParseException {
		String customerId = getCustomer(request).getId();
		PageInfo<OrderExt> pageInfo = orderService.findCustomerOrderByCondition(page, condition.getSearch(), customerId,
				condition.getBeginDate(), condition.getEndDate(), condition.getStatus());
		Map<String, Long> count = orderService.getStatusCount(customerId);
		count.entrySet().forEach(item -> request.setAttribute(item.getKey(), item.getValue()));
		List<DictInfo> orderStatus = orderService.findAllOrderStatus();
		Boolean isOpen = false;
		if (condition.getBeginDate() != null || condition.getEndDate() != null || condition.getStatus() != null) {
			isOpen = true;
		}
		request.setAttribute("orderStatus", orderStatus);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("search", condition.getSearch());
		request.setAttribute("beginDate", condition.getBeginDate());
		request.setAttribute("endDate", condition.getEndDate());
		request.setAttribute("status", condition.getStatus());
		request.setAttribute("isOpen", isOpen);
		return "order-list";
	}

	@GetMapping("/single/place")
	@RequiredAuth
	public String placeAnOrder(String itemId, HttpServletRequest request) {
		Account customer = getCustomer(request);
		inputSelectData(request, customer.getId());
		InquiryMateriel orderItem = InquiryMaterielService.findOneById(itemId);
		request.setAttribute("orderItem", orderItem);
		return "order";
	}

	@GetMapping("/cart/place")
	@RequiredAuth
	public String fromCartOrder(OrderModel orderModel, HttpServletRequest request) {
		Account customer = getCustomer(request);
		inputSelectData(request, customer.getId());
		List<CartDto> cartItems = orderModel.getCartItems();
		List<CartDto> orderItems = cartItems.stream().filter(item -> StringUtils.isNoneBlank(item.getItemId()))
				.collect(Collectors.toList());
		orderItems.forEach(item -> item.setInquiryMateriel(InquiryMaterielService.findOneById(item.getItemId())));
		request.setAttribute("orderItems", orderItems);
		return "order";
	}

	@GetMapping("/success")
	@RequiredAuth
	public String submitSuccess(String orderId, @RequestParam(defaultValue = "0") Byte type, Model model) {
		model.addAttribute("orderId", orderId);
		model.addAttribute("type", type);
		return "order-success";
	}

	@GetMapping("/detail")
	@RequiredAuth
	public String orderDetail(String orderId, HttpServletRequest request) {
		Account customer = getCustomer(request);
		Map<String, Object> detail = orderService.findOrderDetailByOrderId(orderId);
		detail.entrySet().forEach(item -> request.setAttribute(item.getKey(), item.getValue()));
		List<OrderShipping> address = orderShippingService.findAllAddressByAccountId(customer.getId());
		request.setAttribute("address", address);
		OrderDiscount discount = orderDiscountService.findByOrderId(orderId);
		request.setAttribute("discount", discount);
		return "order-detail";
	}

	@PostMapping("/change/shipping")
	@RequiredAuth
	public @ResponseBody Result changeOrderShipping(String orderId, Long orderShippingId, HttpServletRequest request) {
		Account customer = getCustomer(request);
		byte status = orderService.findBuyerOrderById(orderId, customer.getId()).getStatus();
		orderService.changeOrderShipping(orderId, customer.getId(), status, orderShippingId);
		recordOrderOperate(customer, orderId, "买家更换收货地址");
		return new Result(200, null, null);
	}

	@PostMapping("/submit")
	@RequiredAuth
	public @ResponseBody Result submitOrder(TbOrder order, Byte paymentType, OrderModel orderModel,
			HttpServletRequest request) {
		Account customer = getCustomer(request);
		order.setBuyerId(customer.getId());
		order.setBuyerNick(customer.getUserName());
		orderService.generateOrder(order, paymentType, orderModel.getItems());
		recordOrderOperate(customer, order.getOrderId(), "提交订单");
		if (Constant.OrderConst.ACCOUNT_DEADLINE == paymentType)
			return new Result(201, null, order.getOrderId());
		return new Result(200, null, order.getOrderId());
	}

	@PostMapping("/cancel")
	@RequiredAuth
	public @ResponseBody Result cancleOrder(String orderId, String cancleReason, HttpServletRequest request) {
		Account customer = getCustomer(request);
		orderService.cancelOrder(orderId, customer.getId(), cancleReason);
		recordOrderOperate(customer, orderId, "买家取消订单");
		return new Result(200, null, null);
	}

	@GetMapping("/topayment")
	@RequiredAuth
	public String toPaymentOrder(String orderId, HttpServletRequest request) {
		String customerId = getCustomer(request).getId();
		TbOrder order = orderService.findBuyerOrderById(orderId, customerId);
		request.setAttribute("order", order);
		OrderDiscount discount = orderDiscountService.findByOrderId(order.getOrderId());
		request.setAttribute("discount", discount);
		return "payment";
	}

	@PostMapping("/payment")
	@RequiredAuth
	public @ResponseBody Result orderPayment(OrderPayment orderPayment, HttpServletRequest request) {
		orderService.paymentOrder(orderPayment);
		recordOrderOperate(getCustomer(request), orderPayment.getOrderId(), "提交支付凭证");
		return new Result(200, null, orderPayment.getOrderId());
	}

	@PostMapping("/del")
	@RequiredAuth
	public @ResponseBody Result deleteOrder(String orderId, HttpServletRequest request) {
		String buyerId = getCustomer(request).getId();
		orderService.deleteOrder(orderId, buyerId);
		return new Result(200, null, null);
	}

	@PostMapping("/message")
	@RequiredAuth
	public @ResponseBody Result addMessage(String orderId, String buyerMessage) {
		orderService.addMessage(orderId, buyerMessage);
		return new Result(200, null, null);
	}
}
