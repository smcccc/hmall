package com.honpe.pojo.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OrderConditionModel {
	private String search;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date beginDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	private Byte status;

	public final String getSearch() {
		return search;
	}

	public final void setSearch(String search) {
		this.search = search;
	}

	public final Date getBeginDate() {
		return beginDate;
	}

	public final void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public final Date getEndDate() {
		return endDate;
	}

	public final void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public final Byte getStatus() {
		return status;
	}

	public final void setStatus(Byte status) {
		this.status = status;
	}
}
