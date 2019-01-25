package com.honpe.pojo.dto;

import com.honpe.po.SysMenu;

public class MenuDto {
	private SysMenu sysMenu;
	private Boolean checkBox;

	public final SysMenu getSysMenu() {
		return sysMenu;
	}

	public final void setSysMenu(SysMenu sysMenu) {
		this.sysMenu = sysMenu;
	}

	public final Boolean getCheckBox() {
		return checkBox;
	}

	public final void setCheckBox(Boolean checkBox) {
		this.checkBox = checkBox;
	}

}
