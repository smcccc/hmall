package com.honpe.pojo.dto;

import com.honpe.po.DictInfo;
import com.honpe.po.TbOrder;

public class OrderDto extends TbOrder {
	
	private DictInfo shippingTypeInfo;
	private String statusInfo;

	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDto(String statusInfo) {
		super();
		this.statusInfo = statusInfo;
	}

	public OrderDto(DictInfo shippingTypeInfo, String statusInfo) {
		super();
		this.shippingTypeInfo = shippingTypeInfo;
		this.statusInfo = statusInfo;
	}

	public final DictInfo getShippingTypeInfo() {
		return shippingTypeInfo;
	}

	public final void setShippingTypeInfo(DictInfo shippingTypeInfo) {
		this.shippingTypeInfo = shippingTypeInfo;
	}

	public final String getStatusInfo() {
		return statusInfo;
	}

	public final void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}
}
