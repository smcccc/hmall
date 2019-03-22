package com.honpe.auth.shiro.filter;

import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.subject.WebSubject;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import com.honpe.log.service.SysUserLoginLogService;
import com.honpe.po.SysUser;
import com.honpe.po.SysUserLoginLog;
import com.honpe.pojo.vo.Result;
import com.honpe.user.service.SysUserService;
import com.honpe.utils.JsonUtils;
import eu.bitwalker.useragentutils.UserAgent;

public class AdminFormAuthenticationFilter extends FormAuthenticationFilter {

	@Autowired
	private SysUserLoginLogService sysUserLoginLogService;
	@Autowired
	private SysUserService sysUserService;
	
	@Autowired
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;
	
	private String redirectUrl;
	private static final Logger logger = LoggerFactory.getLogger(AdminFormAuthenticationFilter.class);
	private static final byte LOGIN_SUCCESS = 1;
	private static final byte LOGIN_FAIL = 0;

	public AdminFormAuthenticationFilter(String redirectUrl) {
		super();
		this.redirectUrl = redirectUrl;
	}

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		String loginAccount = (String) token.getPrincipal();
		recordSysUserLoginLog(loginAccount, LOGIN_SUCCESS);
		Result result = new Result(200, "登录成功", null);
		String json = JsonUtils.objectToJson(result);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter printWriter = response.getWriter();
		try {
			printWriter.write(json);
			printWriter.flush();
		} catch (Exception e) {
			logger.error("login success response send fail {}:", e);
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
		return false;
	}

	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		if (!(e instanceof UnknownAccountException)) {
			String loginAccount = (String) token.getPrincipal();
			recordSysUserLoginLog(loginAccount, LOGIN_FAIL);
		}
		return super.onLoginFailure(token, e, request, response);
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		if (isLoginRequest(request, response)) {
			if (isLoginSubmission(request, response)) {
				return executeLogin(request, response);
			} else {
				return true;
			}
		} else {
			saveRequest(request);
			WebUtils.issueRedirect(request, response, redirectUrl);
			return false;
		}
	}

	private void recordSysUserLoginLog(String loginAccount, byte loginResult) {
		SysUser sysUser = sysUserService.findByLoginAccount(loginAccount);
		WebSubject webSubject = (WebSubject) SecurityUtils.getSubject();
		HttpServletRequest request = (HttpServletRequest) webSubject.getServletRequest();
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
		SysUserLoginLog sysUserLoginLog = new SysUserLoginLog();
		sysUserLoginLog.setIp(request.getRemoteAddr());
		sysUserLoginLog.setBrowser(userAgent.getBrowser().toString());
		sysUserLoginLog.setLoginTime(new Date());
		sysUserLoginLog.setSystem(userAgent.getOperatingSystem().toString());
		sysUserLoginLog.setLoginAccount(sysUser.getLoginAccount());
		sysUserLoginLog.setLoginResult(loginResult);
		threadPoolTaskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				sysUserLoginLogService.saveSysUserLoginLog(sysUserLoginLog, sysUser.getUserId());
			}
		});
	}
}
