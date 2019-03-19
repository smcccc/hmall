package com.honpe.order.web;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.honpe.account.annotation.RequiredAuth;
import com.honpe.inquiry.service.InquiryMaterielService;
import com.honpe.po.Account;
import com.honpe.pojo.dto.CartDto;
import com.honpe.pojo.vo.Result;
import com.honpe.utils.JsonUtils;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

@Controller
@RequestMapping("/shipping/cart")
public class ShippingCartController {

	@Autowired
	private CacheManager cacheManager;

	@Autowired
	private InquiryMaterielService inquiryMaterielService;

	private Account getCustomer(HttpServletRequest request) {
		return (Account) request.getSession().getAttribute("CUSTOMER");
	}

	@GetMapping("/list")
	@RequiredAuth
	public String getCartItems(HttpServletRequest request) {
		Cache shippingCart = cacheManager.getCache("shippingCartCache");
		Account customer = getCustomer(request);
		Element element = shippingCart.get(customer.getId());
		shippingCart.flush();
		if (element != null) {
			String cartJson = (String) element.getObjectValue();
			if (StringUtils.isNoneBlank(cartJson)) {
				List<CartDto> cart = JsonUtils.jsonToList(cartJson, CartDto.class);
				cart.forEach(item -> item.setInquiryMateriel(inquiryMaterielService.findOneById(item.getItemId())));
				request.setAttribute("cart", cart);
			}
		}
		return "cart";
	}

	@PostMapping("/add")
	@RequiredAuth
	public @ResponseBody Result addItemToCart(String itemId, Integer number, HttpServletRequest request) {
		Cache shippingCart = cacheManager.getCache("shippingCartCache");
		Account customer = getCustomer(request);
		Element element = shippingCart.get(customer.getId());
		shippingCart.flush();
		String cartJson = null;
		if (element != null)
			cartJson = (String) element.getObjectValue();
		CartDto addItem = new CartDto(itemId, number);
		List<CartDto> cartItems = null;
		int cartNum = 1;
		Boolean isNew = false;
		if (StringUtils.isNoneBlank(cartJson)) {
			cartItems = JsonUtils.jsonToList(cartJson, CartDto.class);
			if (cartItems.contains(addItem)) {
				for (CartDto cartDto : cartItems) {
					if (cartDto.equals(addItem)) {
						cartDto.setNumber(cartDto.getNumber() + 1);
						break;
					}
				}
				cartNum = cartItems.size();
			} else {
				isNew = true;
				cartNum = cartItems.size() + 1;
				cartItems.add(addItem);
			}
		} else {
			isNew = true;
			cartItems = new LinkedList<>();
			cartItems.add(addItem);
		}
		shippingCart.put(new Element(customer.getId(), JsonUtils.objectToJson(cartItems)));
		HttpSession session = request.getSession();
		session.setAttribute("CART_NUM", cartNum);
		return new Result(200, null, isNew);
	}

	@PostMapping("/clear")
	@RequiredAuth
	public @ResponseBody Result clearShippingCart(HttpServletRequest request) {
		Cache shippingCart = cacheManager.getCache("shippingCartCache");
		String customerId = getCustomer(request).getId();
		shippingCart.remove(customerId);
		request.getSession().removeAttribute("CART_NUM");
		return new Result(200, null, null);
	}

	@PostMapping("/del")
	@RequiredAuth
	public @ResponseBody Result deleteCartItem(String itemId, HttpServletRequest request) {
		Cache shippingCart = cacheManager.getCache("shippingCartCache");
		String customerId = getCustomer(request).getId();
		Element element = shippingCart.get(customerId);
		if (element != null) {
			String cartJson = (String) element.getObjectValue();
			if (StringUtils.isNoneBlank(cartJson)) {
				List<CartDto> cart = JsonUtils.jsonToList(cartJson, CartDto.class);
				List<CartDto> newCart = cart.stream().filter(item -> !itemId.equals(item.getItemId()))
						.collect(Collectors.toList());
				shippingCart.put(new Element(customerId, JsonUtils.objectToJson(newCart)));
				request.getSession().setAttribute("CART_NUM", newCart.size());
			}
		}
		return new Result(200, null, null);
	}

	@PostMapping("/batch/del")
	@RequiredAuth
	public @ResponseBody Result batchDeleteCartItem(String itemIds, HttpServletRequest request) {
		List<String> asList = Arrays.asList(itemIds.split("-"));
		Cache shippingCart = cacheManager.getCache("shippingCartCache");
		String customerId = getCustomer(request).getId();
		Element element = shippingCart.get(customerId);
		if (element != null) {
			String cartJson = (String) element.getObjectValue();
			if (StringUtils.isNoneBlank(cartJson)) {
				List<CartDto> cart = JsonUtils.jsonToList(cartJson, CartDto.class);
				if (cart != null && cart.size() > 0) {
					ListIterator<CartDto> listIterator = cart.listIterator();
					while (listIterator.hasNext()) {
						CartDto cartDto = listIterator.next();
						if (asList.contains(cartDto.getItemId()))
							listIterator.remove();
					}
					request.getSession().setAttribute("CART_NUM", cart.size());
					shippingCart.put(new Element(customerId, JsonUtils.objectToJson(cart)));
				}
			}
		}
		return new Result(200, null, null);
	}
}
