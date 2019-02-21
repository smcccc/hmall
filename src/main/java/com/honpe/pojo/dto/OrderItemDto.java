package com.honpe.pojo.dto;

import com.honpe.po.OrderItem;

public class OrderItemDto extends OrderItem {

	private Byte status;

	public final Byte getStatus() {
		return status;
	}

	public final void setStatus(Byte status) {
		this.status = status;
	}

}
