package com.honpe.order.enums;

public enum ItemServiceEnum {

	APPLY(0, "已申请"), REFUSE(1, "卖家已拒绝"), AGREE(2, "卖家已同意"), RETURN(3, "买家已退货"), DELIVER(4, "卖家已发货"), REVOKE(5, "已撤销");

	public int status;
	public String statusInfo;

	private ItemServiceEnum(int status, String statusInfo) {
		this.status = status;
		this.statusInfo = statusInfo;
	}

	public static ItemServiceEnum getInstance(int status) {
		switch (status) {
		case 0:
			return APPLY;
		case 1:
			return REFUSE;
		case 2:
			return AGREE;
		case 3:
			return RETURN;
		case 4:
			return DELIVER;
		default:
			return REVOKE;
		}
	}
}
