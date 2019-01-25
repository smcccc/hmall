package com.honpe.order.enums;

public enum OrderEnum {

	NO_PAYMENT(0, "未付款"), CHECK_PAYMENT(1, "付款确认中"), PAYMENTED(2, "已付款"), NO_EXIT_STORE(3, "未出库"), EXITED_STORE(4,
			"已出库"), NO_DELIVER(5, "未发货"), DELIVERED(6, "已发货"), FINISH(7, "交易完成"), CLOSE(8, "交易关闭");
	
	public int status;
	public String statusInfo;

	private OrderEnum(int status, String statusInfo) {
		this.status = status;
		this.statusInfo = statusInfo;
	}

	public static OrderEnum getInstance(int status) {
		switch (status) {
		case 0:
			return NO_PAYMENT;
		case 1:
			return CHECK_PAYMENT;
		case 2:
			return PAYMENTED;
		case 3:
			return NO_EXIT_STORE;
		case 4:
			return EXITED_STORE;
		case 5:
			return NO_DELIVER;
		case 6:
			return DELIVERED;
		case 7:
			return FINISH;
		default:
			return CLOSE;
		}
	}
}
