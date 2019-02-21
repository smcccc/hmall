package com.honpe.order.enums;

public enum OrderDiscountEnum {

	APPLYED(0, "已申请"), REFUSE(1, "已拒绝"), ALLOWED(2, "已通过");

	public int status;
	public String statusInfo;

	private OrderDiscountEnum(int status, String statusInfo) {
		this.status = status;
		this.statusInfo = statusInfo;
	}

	public static OrderDiscountEnum getInstance(int status) {
		switch (status) {
		case 0:
			return APPLYED;
		case 1:
			return REFUSE;
		default:
			return ALLOWED;
		}
	}
}
