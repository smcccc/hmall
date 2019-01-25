package com.honpe.pojo.vo;

import com.honpe.pojo.ext.InquiryMaterielExt;

public class InquiryMaterielVo extends InquiryMaterielExt {

	private String statusInfo;

	public InquiryMaterielVo(String statusInfo) {
		super();
		this.statusInfo = statusInfo;
	}

	public final String getStatusInfo() {
		return statusInfo;
	}

	public final void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}
}
