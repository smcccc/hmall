package com.honpe.pojo.ext;

import com.honpe.po.Inquiry;

public class InquiryExt extends Inquiry {

	private int endDays;
	private String customerName;
	private String companyName;
	private String statusInfo;
	private String salesmanPhone;

	public final int getEndDays() {
		return endDays;
	}

	public final void setEndDays(int endDays) {
		this.endDays = endDays;
	}

	public final String getCustomerName() {
		return customerName;
	}

	public final void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public final String getCompanyName() {
		return companyName;
	}

	public final void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public final String getStatusInfo() {
		return statusInfo;
	}

	public final void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}

	public final String getSalesmanPhone() {
		return salesmanPhone;
	}

	public final void setSalesmanPhone(String salesmanPhone) {
		this.salesmanPhone = salesmanPhone;
	}
}
