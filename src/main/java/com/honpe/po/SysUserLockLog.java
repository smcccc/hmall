package com.honpe.po;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SysUserLockLog {
	private Long id;

	private String lockType;

	private String loginAccount;
	
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	private Date lockTime;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	private Date releaseTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLockType() {
		return lockType;
	}

	public void setLockType(String lockType) {
		this.lockType = lockType == null ? null : lockType.trim();
	}

	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount == null ? null : loginAccount.trim();
	}

	public Date getLockTime() {
		return lockTime;
	}

	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
}