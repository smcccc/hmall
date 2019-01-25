package com.honpe.pojo.vo;

import java.util.List;

import com.honpe.po.SysPermType;
import com.honpe.pojo.dto.PermDto;

public class PermVo {
	private Boolean allCheck;
	private SysPermType sysPermType;
	private List<PermDto> perms;

	public final SysPermType getSysPermType() {
		return sysPermType;
	}

	public final void setSysPermType(SysPermType sysPermType) {
		this.sysPermType = sysPermType;
	}

	public final List<PermDto> getPerms() {
		return perms;
	}

	public final void setPerms(List<PermDto> perms) {
		this.perms = perms;
	}

	public final Boolean getAllCheck() {
		return allCheck;
	}

	public final void setAllCheck(Boolean allCheck) {
		this.allCheck = allCheck;
	}
}
