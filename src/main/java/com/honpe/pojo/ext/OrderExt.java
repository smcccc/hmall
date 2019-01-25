package com.honpe.pojo.ext;

import java.util.List;

import com.honpe.po.OrderItem;
import com.honpe.po.TbOrder;

public class OrderExt extends TbOrder {
	
	private List<OrderItem> orderItems;

	public final List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public final void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
}
