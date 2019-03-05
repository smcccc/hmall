package com.honpe.log.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.honpe.log.service.OperateLogService;
import com.honpe.mapper.SysUserOperateLogMapper;
import com.honpe.po.SysUserOperateLog;
import com.honpe.po.SysUserOperateLogExample;
import com.honpe.po.SysUserOperateLogExample.Criteria;

@Service
@Transactional
public class OperateLogServiceImpl implements OperateLogService {

	@Autowired
	private SysUserOperateLogMapper sysUserOperateLogMapper;
	private final int PAGE_SIZE = 10;

	@Override
	public void recordOperateLog(SysUserOperateLog sysUserOperateLog) {
		sysUserOperateLogMapper.insertSelective(sysUserOperateLog);
	}

	@Override
	public PageInfo<SysUserOperateLog> findAllByCondition(Integer page, String account, String role) {
		SysUserOperateLogExample sysUserOperateLogExample = new SysUserOperateLogExample();
		sysUserOperateLogExample.setOrderByClause("id DESC");
		Criteria createCriteria = sysUserOperateLogExample.createCriteria();
		if (StringUtils.isNoneBlank(account)) {
			createCriteria.andAccountLike('%' + account + '%');
		}
		if (StringUtils.isNoneBlank(role)) {
			createCriteria.andRoleLike('%' + role + '%');
		}
		PageHelper.startPage(page, PAGE_SIZE);
		List<SysUserOperateLog> logs = sysUserOperateLogMapper.selectByExampleWithBLOBs(sysUserOperateLogExample);
		return new PageInfo<>(logs);
	}
}
