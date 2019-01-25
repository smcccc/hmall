package com.honpe.log.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.honpe.log.annotation.RecordOperateLog;
import com.honpe.log.service.OperateLogService;
import com.honpe.log.service.SysUserLockLogService;
import com.honpe.log.service.SysUserLoginLogService;
import com.honpe.po.SysUserLockLog;
import com.honpe.po.SysUserLoginLog;
import com.honpe.po.SysUserOperateLog;
import com.honpe.pojo.vo.PageBean;
import com.honpe.pojo.vo.Result;
import com.honpe.pojo.vo.TableResult;

@Controller
@RequestMapping("admin/log")
public class LogController {

	@Autowired
	private SysUserLoginLogService userLoginLogService;

	@Autowired
	private SysUserLockLogService userLockLogService;
	@Autowired
	private OperateLogService operateLogService;

	@GetMapping("/login/list-json")
	@RequiresPermissions("log:view")
	public @ResponseBody TableResult<SysUserLoginLog> loginLogList(@RequestParam(defaultValue = "1") Integer page) {
		PageInfo<SysUserLoginLog> pageInfo = userLoginLogService.findLoginLogByPage(page);
		return new TableResult<>(pageInfo.getTotal(), pageInfo.getList());
	}

	@PostMapping("/login/batch/del")
	@RequiresPermissions("log:delete")
	@RecordOperateLog(operate = "删除用户登录日志")
	public @ResponseBody Result loginLogBatchDelete(String ids) {
		String[] logIds = ids.split("-");
		userLoginLogService.batchDeleteLogs(logIds);
		return new Result(200, null, null);
	}

	@GetMapping("/lock/list-json")
	@RequiresPermissions("log:view")
	public @ResponseBody TableResult<SysUserLockLog> lockLogList(@RequestParam(defaultValue = "1") Integer page,
			String loginAccount) {
		PageInfo<SysUserLockLog> pageInfo = userLockLogService.findAllByLoginAccount(page, loginAccount);
		return new TableResult<>(pageInfo.getTotal(), pageInfo.getList());
	}

	@GetMapping("/operate/list-json")
	@RequiresPermissions("log:view")
	public @ResponseBody TableResult<SysUserOperateLog> operateLogListJson(
			@RequestParam(defaultValue = "1") Integer page, String account, String role, Model model) {
		PageInfo<SysUserOperateLog> pageInfo = operateLogService.findAllByCondition(page, account, role);
		return new TableResult<>(pageInfo.getTotal(), pageInfo.getList());
	}
}
