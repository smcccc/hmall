package com.honpe.log.service;

import com.github.pagehelper.PageInfo;
import com.honpe.po.SysUserLoginLog;
import com.honpe.pojo.vo.PageBean;

public interface SysUserLoginLogService {

	void saveSysUserLoginLog(SysUserLoginLog sysUserLoginLog, Integer userId);

	PageInfo<SysUserLoginLog> findLoginLogByPage(Integer page);

	void batchDeleteLogs(String[] ids);
}
