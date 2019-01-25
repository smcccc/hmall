package com.honpe.pojo.ext;

import com.honpe.po.SysPerm;

public class PermExt extends SysPerm {
	private String typeName;

	public final String getTypeName() {
		return typeName;
	}

	public final void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
