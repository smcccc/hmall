package com.honpe.role.service;

import java.util.List;

import com.honpe.po.SysRole;
import com.honpe.pojo.vo.MenuVo;
import com.honpe.pojo.vo.PermVo;

public interface RoleService {

	SysRole findSysUserRoles(Integer userId);

	List<SysRole> findAllRoles();

	Boolean addRole(SysRole sysRole);

	void editRole(SysRole sysRole);

	void deleteRole(Integer roleId);

	void batchDeleteRole(String[] roleIds);

	SysRole findRoleById(Integer roleId);

	String findRoleNameByRoleCode(String roleCode);
}
