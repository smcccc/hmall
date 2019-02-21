package com.honpe.pojo.ext;

import com.honpe.po.ItemServiceApply;

public class ItemServiceApplyExt extends ItemServiceApply {

	private String company;
	private String customer;
	private String salesman;
	private String statusInfo;
	private String title;

	public final String getCompany() {
		return company;
	}

	public final void setCompany(String company) {
		this.company = company;
	}

	public final String getSalesman() {
		return salesman;
	}

	public final void setSalesman(String salesman) {
		this.salesman = salesman;
	}

	public final String getStatusInfo() {
		return statusInfo;
	}

	public final void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}

	public final String getCustomer() {
		return customer;
	}

	public final void setCustomer(String customer) {
		this.customer = customer;
	}

	public final String getTitle() {
		return title;
	}

	public final void setTitle(String title) {
		this.title = title;
	}
}
