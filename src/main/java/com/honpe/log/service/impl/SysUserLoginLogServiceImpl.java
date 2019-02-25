package com.honpe.log.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.honpe.log.service.SysUserLoginLogService;
import com.honpe.mapper.SysUserLoginLogMapper;
import com.honpe.po.SysRole;
import com.honpe.po.SysUserLoginLog;
import com.honpe.po.SysUserLoginLogExample;
import com.honpe.pojo.vo.PageBean;
import com.honpe.role.service.RoleService;
import com.honpe.utils.IpHelper;

@Service
@Transactional
public class SysUserLoginLogServiceImpl implements SysUserLoginLogService {

	@Autowired
	private SysUserLoginLogMapper sysUserLoginLogMapper;
	@Autowired
	private RoleService roleService;
	@Autowired
	private IpHelper ipHelper;

	private final int PAGE_SIZE = 10;

	@Override
	public void saveSysUserLoginLog(SysUserLoginLog sysUserLoginLog, Integer userId) {
		// TODO Auto-generated method stub
		String loginAddress = ipHelper.queryIp(sysUserLoginLog.getIp());
		sysUserLoginLog.setLoginAddress(loginAddress);
		SysRole sysRole = roleService.findSysUserRoles(userId);
		if (sysRole != null) {
			String roleName = sysRole.getRoleName();
			sysUserLoginLog.setRole(roleName);
		}
		sysUserLoginLogMapper.insert(sysUserLoginLog);
	}

	@Override
	public PageInfo<SysUserLoginLog> findLoginLogByPage(Integer page) {
		SysUserLoginLogExample sysUserLoginLogExample = new SysUserLoginLogExample();
		sysUserLoginLogExample.setOrderByClause("id DESC");
		PageHelper.startPage(page, PAGE_SIZE);
		List<SysUserLoginLog> userLoginLogs = sysUserLoginLogMapper.selectByExample(sysUserLoginLogExample);
		return new PageInfo<>(userLoginLogs);
	}

	@Override
	public void batchDeleteLogs(String[] ids) {
		for (String id : ids) {
			sysUserLoginLogMapper.deleteByPrimaryKey(Long.parseLong(id));
		}
	}

}
