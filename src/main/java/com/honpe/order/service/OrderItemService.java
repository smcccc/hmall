package com.honpe.order.service;

import com.honpe.po.OrderItem;

public interface OrderItemService {
	OrderItem findOrderItem(String orderId, String itemId);
}
