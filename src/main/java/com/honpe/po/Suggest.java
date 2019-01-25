package com.honpe.po;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Suggest {
	private Long id;

	private String customer;

	private String accId;
	
	@JsonFormat(pattern="yyyy-MM-dd hh:dd")
    private Date createTime;

	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer == null ? null : customer.trim();
	}

	public String getAccId() {
		return accId;
	}

	public void setAccId(String accId) {
		this.accId = accId == null ? null : accId.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}
}