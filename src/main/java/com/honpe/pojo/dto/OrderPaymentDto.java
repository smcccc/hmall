package com.honpe.pojo.dto;

import com.honpe.po.DictInfo;
import com.honpe.po.OrderPayment;

public class OrderPaymentDto extends OrderPayment {
	private DictInfo paymentTypeInfo;
	private DictInfo paymentChannelnfo;

	public OrderPaymentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderPaymentDto(DictInfo paymentTypeInfo, DictInfo paymentChannelnfo) {
		super();
		this.paymentTypeInfo = paymentTypeInfo;
		this.paymentChannelnfo = paymentChannelnfo;
	}

	public final DictInfo getPaymentTypeInfo() {
		return paymentTypeInfo;
	}

	public final void setPaymentTypeInfo(DictInfo paymentTypeInfo) {
		this.paymentTypeInfo = paymentTypeInfo;
	}

	public final DictInfo getPaymentChannelnfo() {
		return paymentChannelnfo;
	}

	public final void setPaymentChannelnfo(DictInfo paymentChannelnfo) {
		this.paymentChannelnfo = paymentChannelnfo;
	}
}
