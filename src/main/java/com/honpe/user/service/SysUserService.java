package com.honpe.user.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.honpe.po.SysUser;
import com.honpe.pojo.ext.SysUserExt;

public interface SysUserService {

	SysUser findByLoginAccount(String loginAccount);

	Boolean updateSysUserLock(Integer userId, String lockType);

	void discardSysUser(Integer userId);

	PageInfo<SysUserExt> findSysUserList(Integer page, Integer roleId, String loginAccount);

	Boolean addSysUser(SysUser sysUser, Integer roleId);

	SysUserExt findSysUserExtById(Integer userId);

	Boolean editSysUser(SysUser sysUser, Integer roleId);

	void batchDiscard(String[] userIds);

	void changeLoginPass(SysUser sysUser);

	SysUser findByCode(String code);
	
	List<SysUser> findAllSalesman();
}
