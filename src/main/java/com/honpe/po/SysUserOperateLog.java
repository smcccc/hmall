package com.honpe.po;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SysUserOperateLog {
	private Long id;

	private String account;

	private String role;

	private String operateContent;
	
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date operateTime;

	private String operateData;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account == null ? null : account.trim();
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role == null ? null : role.trim();
	}

	public String getOperateContent() {
		return operateContent;
	}

	public void setOperateContent(String operateContent) {
		this.operateContent = operateContent == null ? null : operateContent.trim();
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	public String getOperateData() {
		return operateData;
	}

	public void setOperateData(String operateData) {
		this.operateData = operateData == null ? null : operateData.trim();
	}
}