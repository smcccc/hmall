package com.honpe.log.enums;

public enum SysUserLockType {

	RETRY_LOCK("密码重试次数超限"), ADMIN_LOCK("超级管理员锁定");

	public String lockLogType;

	private SysUserLockType(String lockLogType) {
		this.lockLogType = lockLogType;
	}
	
}
