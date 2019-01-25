package com.honpe.log.service;

import com.github.pagehelper.PageInfo;
import com.honpe.po.SysUserLockLog;
import com.honpe.pojo.vo.PageBean;

public interface SysUserLockLogService {
	PageInfo<SysUserLockLog> findAllByLoginAccount(Integer page,String loginAccount);
}
