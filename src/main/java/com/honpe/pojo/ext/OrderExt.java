package com.honpe.pojo.ext;

import com.honpe.po.OrderDiscount;
import com.honpe.po.TbOrder;

public class OrderExt extends TbOrder {

	private String company;
	private String salesman;
	private String statusInfo;
	private OrderDiscount orderDiscount;

	public final String getStatusInfo() {
		return statusInfo;
	}

	public final void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}

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

	public final OrderDiscount getOrderDiscount() {
		return orderDiscount;
	}

	public final void setOrderDiscount(OrderDiscount orderDiscount) {
		this.orderDiscount = orderDiscount;
	}
}
