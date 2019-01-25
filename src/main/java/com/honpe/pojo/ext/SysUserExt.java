package com.honpe.pojo.ext;

import com.honpe.po.SysUser;

public class SysUserExt extends SysUser {
	
	private Integer roleId;
	
	private String roleName;
	
	private String department;
	
	public final Integer getRoleId() {
		return roleId;
	}
	public final void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public final String getRoleName() {
		return roleName;
	}
	public final void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public final String getDepartment() {
		return department;
	}
	public final void setDepartment(String department) {
		this.department = department;
	}
}
