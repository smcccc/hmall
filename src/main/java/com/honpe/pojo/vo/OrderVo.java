package com.honpe.pojo.vo;

import java.util.List;

import com.honpe.po.OrderDiscount;
import com.honpe.po.TbOrder;
import com.honpe.pojo.dto.OrderItemDto;

public class OrderVo extends TbOrder {

	private OrderDiscount orderDiscount;

	private List<OrderItemDto> orderItems;

	public final OrderDiscount getOrderDiscount() {
		return orderDiscount;
	}

	public final void setOrderDiscount(OrderDiscount orderDiscount) {
		this.orderDiscount = orderDiscount;
	}

	public final List<OrderItemDto> getOrderItems() {
		return orderItems;
	}

	public final void setOrderItems(List<OrderItemDto> orderItems) {
		this.orderItems = orderItems;
	}
}
