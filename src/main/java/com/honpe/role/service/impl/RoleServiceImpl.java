package com.honpe.role.service.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.honpe.constant.Constant;
import com.honpe.mapper.SysMenuMapper;
import com.honpe.mapper.SysPermMapper;
import com.honpe.mapper.SysPermTypeMapper;
import com.honpe.mapper.SysRoleMapper;
import com.honpe.mapper.SysRoleMenuMapper;
import com.honpe.mapper.SysRolePermMapper;
import com.honpe.mapper.SysUserRoleMapper;
import com.honpe.po.SysMenu;
import com.honpe.po.SysMenuExample;
import com.honpe.po.SysPerm;
import com.honpe.po.SysPermExample;
import com.honpe.po.SysPermType;
import com.honpe.po.SysPermTypeExample;
import com.honpe.po.SysRole;
import com.honpe.po.SysRoleExample;
import com.honpe.po.SysRoleMenu;
import com.honpe.po.SysRoleMenuExample;
import com.honpe.po.SysRolePerm;
import com.honpe.po.SysRolePermExample;
import com.honpe.po.SysUserRole;
import com.honpe.po.SysUserRoleExample;
import com.honpe.pojo.dto.MenuDto;
import com.honpe.pojo.dto.PermDto;
import com.honpe.pojo.vo.MenuVo;
import com.honpe.pojo.vo.PermVo;
import com.honpe.role.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;

	private static final Logger Logger = LoggerFactory.getLogger(RoleServiceImpl.class);

	@Override
	public SysRole findSysUserRoles(Integer userId) {
		SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
		sysUserRoleExample.createCriteria().andUserIdEqualTo(userId);
		List<SysUserRole> sysUserRoles = sysUserRoleMapper.selectByExample(sysUserRoleExample);
		SysRole sysRole = null;
		if (sysUserRoles != null && sysUserRoles.size() > 0) {
			SysUserRole sysUserRole = sysUserRoles.get(0);
			Logger.info("user role ID{} :" + sysUserRole.getRoleId());
			SysRoleExample sysRoleExample = new SysRoleExample();
			sysRoleExample.createCriteria().andRoleIdEqualTo(sysUserRole.getRoleId()).andIsDeleteEqualTo(false);
			List<SysRole> sysRoles = sysRoleMapper.selectByExample(sysRoleExample);
			if (sysRoles != null && sysRoles.size() > 0) {
				sysRole = sysRoles.get(0);
			}
		}
		return sysRole;
	}

	@Override
	public List<SysRole> findAllRoles() {
		SysRoleExample sysRoleExample = new SysRoleExample();
		sysRoleExample.createCriteria().andIsDeleteEqualTo(false);
		sysRoleExample.setOrderByClause("role_id ASC");
		List<SysRole> roles = sysRoleMapper.selectByExample(sysRoleExample);
		return roles;
	}

	@Override
	public Boolean addRole(SysRole sysRole) {
		SysRoleExample sysRoleExample = new SysRoleExample();
		sysRoleExample.createCriteria().andRoleCodeEqualTo(sysRole.getRoleCode());
		List<SysRole> sysRoles = sysRoleMapper.selectByExample(sysRoleExample);
		if (sysRoles != null && sysRoles.size() > 0)
			return false;
		sysRole.setCreateTime(new Date());
		sysRoleMapper.insert(sysRole);
		return true;
	}

	@Override
	public void deleteRole(Integer roleId) {
		SysRole sysRole = new SysRole();
		sysRole.setRoleId(roleId);
		sysRole.setIsDelete(true);
		sysRoleMapper.updateByPrimaryKeySelective(sysRole);
	}

	@Override
	public void batchDeleteRole(String[] roleIds) {
		for (String roleId : roleIds) {
			deleteRole(Integer.parseInt(roleId));
		}
	}

	@Override
	public void editRole(SysRole sysRole) {
		sysRole.setEditTime(new Date());
		sysRoleMapper.updateByPrimaryKeySelective(sysRole);
	}

	@Override
	public SysRole findRoleById(Integer roleId) {
		return sysRoleMapper.selectByPrimaryKey(roleId);
	}

	@Override
	public String findRoleNameByRoleCode(String roleCode) {
		SysRoleExample sysRoleExample = new SysRoleExample();
		sysRoleExample.createCriteria().andRoleCodeEqualTo(roleCode);
		List<SysRole> sysRoles = sysRoleMapper.selectByExample(sysRoleExample);
		String roleName = null;
		if (sysRoles != null && sysRoles.size() > 0) {
			roleName = sysRoles.get(0).getRoleName();
		}
		return roleName;
	}
}
