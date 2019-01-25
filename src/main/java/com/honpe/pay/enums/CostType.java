package com.honpe.pay.enums;

public enum CostType {

	CHEQE(0, "cheqe", "支票支付"), MONTHLY_PAYMENT(1, "monthly", "月结支付");

	private int costType;
	private String desc;
	private String costCode;

	private CostType(int costType, String desc, String costCode) {
		this.costType = costType;
		this.desc = desc;
		this.costCode = costCode;
	}

	public final int getCostType() {
		return costType;
	}

	public final void setCostType(int costType) {
		this.costType = costType;
	}

	public final String getDesc() {
		return desc;
	}

	public final void setDesc(String desc) {
		this.desc = desc;
	}

	public final String getCostCode() {
		return costCode;
	}

	public final void setCostCode(String costCode) {
		this.costCode = costCode;
	}

}
