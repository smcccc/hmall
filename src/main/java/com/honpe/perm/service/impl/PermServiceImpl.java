package com.honpe.perm.service.impl;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.honpe.mapper.SysPermMapper;
import com.honpe.mapper.SysPermTypeMapper;
import com.honpe.mapper.SysRolePermMapper;
import com.honpe.perm.service.PermService;
import com.honpe.po.SysPerm;
import com.honpe.po.SysPermExample;
import com.honpe.po.SysPermType;
import com.honpe.po.SysPermTypeExample;
import com.honpe.po.SysRole;
import com.honpe.po.SysRolePerm;
import com.honpe.po.SysRolePermExample;
import com.honpe.pojo.dto.PermDto;
import com.honpe.pojo.ext.PermExt;
import com.honpe.pojo.vo.PermVo;
import com.honpe.role.service.RoleService;

@Service
@Transactional
public class PermServiceImpl implements PermService {

	@Autowired
	private RoleService roleService;
	@Autowired
	private SysPermMapper sysPermMapper;
	@Autowired
	private SysPermTypeMapper sysPermTypeMapper;
	@Autowired
	private SysRolePermMapper sysRolePermMapper;

	@Override
	public Set<String> findPermsByUserId(Integer userId) {
		SysRole sysRole = roleService.findSysUserRoles(userId);
		List<String> rolePerms = sysPermMapper.selectByRoleId(sysRole.getRoleId());
		return new HashSet<>(rolePerms);
	}

	@Override
	public List<PermVo> findRolePermission(Integer roleId) {
		SysPermTypeExample sysPermTypeExample = new SysPermTypeExample();
		sysPermTypeExample.setOrderByClause("sequence ASC");
		List<SysPermType> permTypes = sysPermTypeMapper.selectByExample(sysPermTypeExample);
		List<PermVo> perms = new LinkedList<>();
		if (permTypes != null && permTypes.size() > 0) {
			for (SysPermType sysPermType : permTypes) {
				PermVo permVo = null;
				SysPermExample sysPermExample = new SysPermExample();
				sysPermExample.createCriteria().andTypeIdEqualTo(sysPermType.getTypeId());
				sysPermExample.setOrderByClause("id ASC");
				List<SysPerm> typePerms = sysPermMapper.selectByExample(sysPermExample);
				if (typePerms != null && typePerms.size() > 0) {
					permVo = new PermVo();
					int flag = 0;
					permVo.setSysPermType(sysPermType);
					LinkedList<PermDto> permDtos = new LinkedList<>();
					for (SysPerm sysPerm : typePerms) {
						PermDto permDto = new PermDto();
						permDto.setSysPerm(sysPerm);
						SysRolePermExample sysRolePermExample = new SysRolePermExample();
						sysRolePermExample.createCriteria().andRoleIdEqualTo(roleId).andPermIdEqualTo(sysPerm.getId());
						List<SysRolePerm> rolePerms = sysRolePermMapper.selectByExample(sysRolePermExample);
						if (rolePerms != null && rolePerms.size() > 0) {
							permDto.setCheckBox(true);
							flag += 1;
						} else {
							permDto.setCheckBox(false);
						}
						permDtos.add(permDto);
					}
					permVo.setAllCheck(flag == typePerms.size());
					permVo.setPerms(permDtos);
				}
				if (permVo != null) {
					perms.add(permVo);
				}
			}
		}
		return perms;
	}

	@Override
	public void updateRolePermission(Integer roleId, Integer[] ids) {
		SysRolePermExample sysRolePermExample = new SysRolePermExample();
		sysRolePermExample.createCriteria().andRoleIdEqualTo(roleId);
		sysRolePermMapper.deleteByExample(sysRolePermExample);
		for (int permId : ids) {
			SysRolePerm rolePerm = new SysRolePerm();
			rolePerm.setRoleId(roleId);
			rolePerm.setPermId(permId);
			sysRolePermMapper.insert(rolePerm);
		}
	}

	@Override
	public List<PermExt> findAllPermsByCondition(Integer typeId,String permName) {
		List<PermExt> perms = sysPermMapper.selectByTypeIdAndPermissionName(typeId, permName);
		return perms;
	}

	@Override
	public SysPerm findPermissionById(Integer permId) {
		return sysPermMapper.selectByPrimaryKey(permId);
	}

	@Override
	public void updatePermission(SysPerm sysPerm) {
		sysPermMapper.updateByPrimaryKeySelective(sysPerm);
	}
}
