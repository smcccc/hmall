package com.honpe.user.service.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.honpe.constant.Constant;
import com.honpe.log.annotation.RecordOperateLog;
import com.honpe.mapper.SysDepartmentMapper;
import com.honpe.mapper.SysUserLockLogMapper;
import com.honpe.mapper.SysUserMapper;
import com.honpe.mapper.SysUserRoleMapper;
import com.honpe.po.SysDepartment;
import com.honpe.po.SysRole;
import com.honpe.po.SysUser;
import com.honpe.po.SysUserExample;
import com.honpe.po.SysUserLockLog;
import com.honpe.po.SysUserLockLogExample;
import com.honpe.po.SysUserRole;
import com.honpe.po.SysUserRoleExample;
import com.honpe.pojo.ext.SysUserExt;
import com.honpe.pojo.vo.PageBean;
import com.honpe.pojo.vo.TableResult;
import com.honpe.role.service.RoleService;
import com.honpe.user.service.SysUserService;

@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private SysUserLockLogMapper sysUserLockLogMapper;
	@Autowired
	private RoleService roleService;
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;

	private final int PAGE_SIZE = 10;

	private static final Logger LOGGER = LoggerFactory.getLogger(SysUserServiceImpl.class);

	@Override
	public SysUser findByLoginAccount(String loginAccount) {
		SysUserExample sysUserExample = new SysUserExample();
		sysUserExample.createCriteria().andLoginAccountEqualTo(loginAccount);
		List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
		SysUser sysUser = null;
		if (sysUsers != null && sysUsers.size() > 0) {
			sysUser = sysUsers.get(0);
		}
		return sysUser;
	}

	@Override
	public Boolean updateSysUserLock(Integer userId, String lockType) {
		SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
		if (sysUser.getIsLock()) {
			SysUserLockLogExample sysUserLockLogExample = new SysUserLockLogExample();
			sysUserLockLogExample.createCriteria().andLoginAccountEqualTo(sysUser.getLoginAccount());
			sysUserLockLogExample.setOrderByClause("id DESC");
			List<SysUserLockLog> sysUserLockLogs = sysUserLockLogMapper.selectByExample(sysUserLockLogExample);
			if (sysUserLockLogs != null && sysUserLockLogs.size() > 0) {
				SysUserLockLog sysUserLockLog = sysUserLockLogs.get(0);
				sysUserLockLog.setReleaseTime(new Date());
				sysUserLockLogMapper.updateByPrimaryKey(sysUserLockLog);
			}
		} else {
			SysUserLockLog sysUserLockLog = initSysUserLockLog(sysUser.getLoginAccount(), lockType);
			sysUserLockLogMapper.insert(sysUserLockLog);
		}
		sysUser.setIsLock(!sysUser.getIsLock());
		sysUserMapper.updateByPrimaryKeySelective(sysUser);
		return sysUser.getIsLock();
	}

	private SysUserLockLog initSysUserLockLog(String loginAccount, String lockType) {
		SysUserLockLog sysUserLockLog = new SysUserLockLog();
		sysUserLockLog.setLoginAccount(loginAccount);
		sysUserLockLog.setLockTime(new Date());
		sysUserLockLog.setLockType(lockType);
		return sysUserLockLog;
	}

	@Override
	public PageInfo<SysUserExt> findSysUserList(Integer page, Integer roleId, String loginAccount) {
		PageHelper.startPage(page, PAGE_SIZE);
		List<SysUserExt> sysUserExts = sysUserMapper.selectSysUserExtsByRoleIdAndLoginAccount(roleId, loginAccount);
		return new PageInfo<>(sysUserExts);
	}

	@Override
	public void discardSysUser(Integer userId) {
		SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
		sysUser.setIsDiscard(true);
		sysUserMapper.updateByPrimaryKeySelective(sysUser);
	}

	@Override
	public Boolean addSysUser(SysUser sysUser, Integer roleId) {
		SysUserExample sysUserExample = new SysUserExample();
		sysUserExample.createCriteria().andLoginAccountEqualTo(sysUser.getLoginAccount());
		List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
		if (sysUsers != null && sysUsers.size() > 0)
			return false;
		sysUserMapper.insertSelective(sysUser);
		List<SysUser> users = sysUserMapper.selectByExample(sysUserExample);
		if (users != null && users.size() > 0) {
			SysUserRole sysUserRole = new SysUserRole();
			sysUserRole.setUserId(users.get(0).getUserId());
			sysUserRole.setRoleId(roleId);
			sysUserRoleMapper.insertSelective(sysUserRole);
			return true;
		}
		return false;
	}

	@Override
	public SysUserExt findSysUserExtById(Integer userId) {
		SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
		SysRole sysRole = roleService.findSysUserRoles(userId);
		SysUserExt sysUserExt = new SysUserExt();
		BeanUtils.copyProperties(sysUser, sysUserExt);
		sysUserExt.setRoleId(sysRole.getRoleId());
		sysUserExt.setRoleName(sysRole.getRoleName());
		return sysUserExt;
	}

	@Override
	public Boolean editSysUser(SysUser sysUser, Integer roleId) {
		sysUserMapper.updateByPrimaryKeySelective(sysUser);
		SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
		sysUserRoleExample.createCriteria().andUserIdEqualTo(sysUser.getUserId());
		List<SysUserRole> sysUserRoles = sysUserRoleMapper.selectByExample(sysUserRoleExample);
		if (sysUserRoles != null && sysUserRoles.size() > 0) {
			SysUserRole sysUserRole = sysUserRoles.get(0);
			sysUserRole.setRoleId(roleId);
			sysUserRoleMapper.updateByPrimaryKey(sysUserRole);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void batchDiscard(String[] userIds) {
		for (String userId : userIds) {
			SysUser sysUser = new SysUser();
			sysUser.setUserId(Integer.parseInt(userId));
			sysUser.setIsDiscard(true);
			sysUserMapper.updateByPrimaryKeySelective(sysUser);
		}
	}

	@Override
	public void changeLoginPass(SysUser sysUser) {
		sysUserMapper.updateByPrimaryKeySelective(sysUser);
	}

	@Override
	public SysUser findByCode(String code) {
		SysUserExample sysUserExample = new SysUserExample();
		sysUserExample.createCriteria().andCodeEqualTo(code);
		List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
		if (sysUsers != null && sysUsers.size() > 0) {
			return sysUsers.get(0);
		}
		return null;
	}

	@Override
	public List<SysUser> findAllSalesman() {
		return sysUserMapper.selectByRoleCode(Constant.RoleConst.SALESMAN_CODE);
	}
}
