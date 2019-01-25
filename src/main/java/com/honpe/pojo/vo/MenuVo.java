package com.honpe.pojo.vo;

import java.util.List;

import com.honpe.po.SysMenu;
import com.honpe.pojo.dto.MenuDto;

public class MenuVo {
	private Boolean allCheck;
	private SysMenu parent;
	private List<MenuDto> children;

	public final Boolean getAllCheck() {
		return allCheck;
	}

	public final void setAllCheck(Boolean allCheck) {
		this.allCheck = allCheck;
	}

	public final SysMenu getParent() {
		return parent;
	}

	public final void setParent(SysMenu parent) {
		this.parent = parent;
	}

	public final List<MenuDto> getChildren() {
		return children;
	}

	public final void setChildren(List<MenuDto> children) {
		this.children = children;
	}
}
