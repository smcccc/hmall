package com.honpe.pojo.model;

import java.util.List;
import com.honpe.po.OrderItem;

public class OrderItemModel {
	
	private List<OrderItem> items;

	public final List<OrderItem> getItems() {
		return items;
	}

	public final void setItems(List<OrderItem> items) {
		this.items = items;
	}
}
