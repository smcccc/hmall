package com.honpe.log.service;

import com.github.pagehelper.PageInfo;
import com.honpe.po.SysUserOperateLog;
import com.honpe.pojo.vo.PageBean;

public interface OperateLogService {

	void recordOperateLog(SysUserOperateLog sysUserOperateLog);

	PageInfo<SysUserOperateLog> findAllByCondition(Integer page, String account, String role);
}
