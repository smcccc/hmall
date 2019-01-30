package com.honpe.order.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.honpe.account.annotation.RequiredAuth;
import com.honpe.order.service.OrderDiscountService;
import com.honpe.po.Account;
import com.honpe.po.OrderDiscount;
import com.honpe.pojo.vo.Result;

@Controller
@RequestMapping("/order/discount")
public class OrderDiscountController {

	@Autowired
	private OrderDiscountService orderDiscountService;

	@PostMapping("/apply")
	@RequiredAuth
	public @ResponseBody Result applyDiscount(OrderDiscount orderDiscount, HttpServletRequest request) {
		Account customer = (Account) request.getSession().getAttribute("CUSTOMER");
		orderDiscount.setBuyerId(customer.getId());
		orderDiscount.setSalesmanId(customer.getSalesmanId());
		Boolean isSuccess = orderDiscountService.applyDiscount(orderDiscount);
		if (!isSuccess)
			return new Result(403, null, null);
		return new Result(200, null, null);
	}
}
