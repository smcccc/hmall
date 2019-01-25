package com.honpe.log.aop;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.honpe.log.annotation.RecordOperateLog;
import com.honpe.log.service.OperateLogService;
import com.honpe.po.SysUser;
import com.honpe.po.SysUserOperateLog;
import com.honpe.role.service.RoleService;
import com.honpe.utils.JsonUtils;

@Aspect
@Component
public class OperateLogAspect {
	@Autowired
	private OperateLogService operateLogService;
	@Autowired
	private RoleService roleService;

	private static final Logger Logger = LoggerFactory.getLogger(OperateLogAspect.class);

	@Pointcut("execution(* com.honpe.*.web..*.*(..))")
	private void pointCut() {

	}

	@AfterThrowing(value = "pointCut()", throwing = "e")
	public void afterThrowing(JoinPoint joinPoint, Throwable e) {
		Logger.error("record operate log exception{}:" + e);
	}

	@After(value = "pointCut()")
	@Transactional
	private void recordOperateLog(JoinPoint joinPoint) {
		Logger.info("check method annotation {} :");
		RecordOperateLog recordOperateLog = isHashLogAnnotation(joinPoint);
		if (recordOperateLog != null) {
			Logger.info("start record operate log {} :" + joinPoint);
			SysUserOperateLog operateLog = initOperateLog(joinPoint, recordOperateLog);
			operateLogService.recordOperateLog(operateLog);
		}
	}

	private SysUserOperateLog initOperateLog(JoinPoint joinPoint, RecordOperateLog recordOperateLog) {
		Session session = SecurityUtils.getSubject().getSession();
		SysUserOperateLog sysUserOperateLog = new SysUserOperateLog();
		sysUserOperateLog.setOperateContent(recordOperateLog.operate());
		@SuppressWarnings("unchecked")
		Set<String> roles = (Set<String>) session.getAttribute("ROLES");
		String roleCode = roles.iterator().next();
		String roleName = roleService.findRoleNameByRoleCode(roleCode);
		sysUserOperateLog.setRole(roleName);
		SysUser sysUser = (SysUser) session.getAttribute("SYS_USER");
		String account = sysUser.getLoginAccount();
		sysUserOperateLog.setAccount(account);
		sysUserOperateLog.setOperateTime(new Date());
		List<Map<String, Object>> jsonList = getMethodNamesAndArgs(joinPoint);
		sysUserOperateLog.setOperateData(JsonUtils.objectToJson(jsonList));
		return sysUserOperateLog;
	}

	private RecordOperateLog isHashLogAnnotation(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		return method.getAnnotation(RecordOperateLog.class);
	}

	private List<Map<String, Object>> getMethodNamesAndArgs(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		String[] parameterNames = methodSignature.getParameterNames();
		ArrayList<Map<String, Object>> jsonList = new ArrayList<>();
		Object[] args = joinPoint.getArgs();
		for (int i = 0; i < args.length; i++) {
			HashMap<String, Object> temp = new HashMap<>();
			temp.put(parameterNames[i], args[i]);
			jsonList.add(temp);
		}
		return jsonList;
	}
}
