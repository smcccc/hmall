package com.honpe.inquiry.enums;

public enum InquiryEnum {

	STATUS_ACCEPT(0, "接受报价中"), STATUS_REVOKE(1, "已撤销"), STATUS_OVER(2, "已截止");

	private InquiryEnum(int status, String statusInfo) {
		this.status = status;
		this.statusInfo = statusInfo;
	}

	public int status;
	public String statusInfo;

	public static InquiryEnum getInstance(int status) {
		switch (status) {
		case 0:
			return STATUS_ACCEPT;
		case 1:
			return STATUS_REVOKE;
		default:
			return STATUS_OVER;
		}
	}
}
