package com.honpe.inquiry.enums;

public enum OperateEnum {
	
	REVOCE_INQUIRY("撤销询价", "revoce inquiry", "引き合いを取り消す");
	
	public String action;
	public String enAction;
	public String jpAction;

	private OperateEnum(String action, String enAction, String jpAction) {
		this.action = action;
		this.enAction = enAction;
		this.jpAction = jpAction;
	}
}
