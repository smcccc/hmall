package com.honpe.inquiry.enums;

public enum MaterileEnum {

	STATUS_NO_OFFER(0, "未报价"), STATUS_OFFERED(1, "已报价"), STATUS_RETRY_OFFER(2, "重新报价"), STATUS_ACCEPT(3, "已确认");

	private MaterileEnum(int status, String statusInfo) {
		this.status = status;
		this.statusInfo = statusInfo;
	}

	public int status;
	public String statusInfo;

	public static MaterileEnum getInstance(int status) {
		switch (status) {
		case 0:
			return STATUS_NO_OFFER;
		case 1:
			return STATUS_OFFERED;
		case 2:
			return STATUS_RETRY_OFFER;
		default:
			return STATUS_ACCEPT;
		}
	}
}
