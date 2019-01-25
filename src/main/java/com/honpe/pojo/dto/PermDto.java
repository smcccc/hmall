package com.honpe.pojo.dto;

import com.honpe.po.SysPerm;

public class PermDto {
	private SysPerm sysPerm;
	private Boolean checkBox;

	public final SysPerm getSysPerm() {
		return sysPerm;
	}

	public final void setSysPerm(SysPerm sysPerm) {
		this.sysPerm = sysPerm;
	}

	public final Boolean getCheckBox() {
		return checkBox;
	}

	public final void setCheckBox(Boolean checkBox) {
		this.checkBox = checkBox;
	}
}
