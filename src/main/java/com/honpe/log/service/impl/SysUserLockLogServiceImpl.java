package com.honpe.log.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.honpe.log.service.SysUserLockLogService;
import com.honpe.mapper.SysUserLockLogMapper;
import com.honpe.po.SysUserLockLog;
import com.honpe.po.SysUserLockLogExample;

@Service
@Transactional
public class SysUserLockLogServiceImpl implements SysUserLockLogService {
	@Autowired
	private SysUserLockLogMapper sysUserLockLogMapper;
	private final int PAGE_SIZE = 10;

	@Override
	public PageInfo<SysUserLockLog> findAllByLoginAccount(Integer page, String loginAccount) {
		SysUserLockLogExample sysUserLockLogExample = new SysUserLockLogExample();
		sysUserLockLogExample.setOrderByClause("id DESC");
		if (StringUtils.isNoneBlank(loginAccount)) {
			String condition = '%' + loginAccount + '%';
			sysUserLockLogExample.createCriteria().andLoginAccountLike(condition);
		}
		PageHelper.startPage(page, PAGE_SIZE, true);
		List<SysUserLockLog> lockLogs = sysUserLockLogMapper.selectByExample(sysUserLockLogExample);
		return new PageInfo<SysUserLockLog>(lockLogs);
	}

}
