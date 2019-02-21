package com.honpe.order.service;

import com.honpe.po.OrderDiscount;

public interface OrderDiscountService {

	OrderDiscount findByOrderId(String orderId);

	Boolean applyDiscount(OrderDiscount orderDiscount);

	void checkOrderDiscount(String orderId, Byte status, String refuseReason);
}
