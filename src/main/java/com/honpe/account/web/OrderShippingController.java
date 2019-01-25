package com.honpe.account.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.honpe.account.annotation.RequiredAuth;
import com.honpe.account.service.OrderShippingService;
import com.honpe.po.Account;
import com.honpe.po.OrderShipping;
import com.honpe.pojo.vo.Result;

@Controller
@RequestMapping("address")
public class OrderShippingController {

	@Autowired
	private OrderShippingService orderShippingService;

	@GetMapping("/info")
	@RequiredAuth
	public String accountAddresses(HttpServletRequest request) {
		Account account = (Account) request.getSession().getAttribute("CUSTOMER");
		List<OrderShipping> addresses = orderShippingService.findAllAddressByAccountId(account.getId());
		request.setAttribute("addresses", addresses);
		return "address";
	}

	@PostMapping("/save")
	@RequiredAuth
	public @ResponseBody Result addAddress(OrderShipping orderShipping) {
		if (orderShipping.getId() == null && !orderShippingService.isCanAdd(orderShipping.getAccId()))
			return new Result(403, null, null);
		orderShippingService.saveAddress(orderShipping);
		return new Result(200, null, null);
	}

	@GetMapping("/toedit")
	@RequiredAuth
	public String editAddressFormView(Long id, Model model) {
		OrderShipping address = orderShippingService.findById(id);
		String temp = address.getReceiverAddress();
		String replace = temp.replace(' ', '/');
		model.addAttribute("initAddress", replace);
		model.addAttribute("address", address);
		return "forward:info";
	}

	@PostMapping("/del")
	@RequiredAuth
	public @ResponseBody Result deleteAddress(Long id) {
		orderShippingService.deleteAddress(id);
		return new Result(200, null, null);
	}

	@PostMapping("/default")
	@RequiredAuth
	public @ResponseBody Result setDefault(Long id) {
		orderShippingService.setDefault(id);
		return new Result(200, null, null);
	}
}
