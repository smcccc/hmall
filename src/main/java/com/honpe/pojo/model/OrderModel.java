package com.honpe.pojo.model;

import java.util.List;

import com.honpe.po.OrderItem;
import com.honpe.pojo.dto.CartDto;

public class OrderModel {

	private List<OrderItem> items;

	private List<CartDto> cartItems;

	public final List<OrderItem> getItems() {
		return items;
	}

	public final void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public final List<CartDto> getCartItems() {
		return cartItems;
	}

	public final void setCartItems(List<CartDto> cartItems) {
		this.cartItems = cartItems;
	}
}
