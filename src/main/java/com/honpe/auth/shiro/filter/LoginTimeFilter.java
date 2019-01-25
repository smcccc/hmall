package com.honpe.auth.shiro.filter;

import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.honpe.po.SysUser;
import com.honpe.pojo.vo.Result;
import com.honpe.user.service.SysUserService;
import com.honpe.utils.JsonUtils;

/**
 * 用户登录次数过滤器
 * @author Administrator
 *
 */
public class LoginTimeFilter extends AccessControlFilter {

	@Autowired
	private SysUserService sysUserService;
	private Cache<String, AtomicInteger> loginTimesCache;
	private String redirectUrl;
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginTimeFilter.class);

	public LoginTimeFilter(String redirectUrl, CacheManager cacheManager) {
		super();
		this.redirectUrl = redirectUrl;
		this.loginTimesCache = cacheManager.getCache("loginTimesCache");

	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		HttpSession session = WebUtils.toHttp(request).getSession();
		SysUser sysUser = (SysUser) session.getAttribute("SYS_USER");
		if (sysUser != null) {
			String loginAccount = sysUser.getLoginAccount();
			int loginTimes = (int) session.getAttribute("LOGIN_TIMES");
			if (loginTimes == loginTimesCache.get(loginAccount).get()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		if (isAjaxRequest(request)) {
			Result result = new Result(406, "您的账号已经在别的地方登录，您被迫退出", null);
			String json = JsonUtils.objectToJson(result);
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			PrintWriter printWriter = response.getWriter();
			try {
				printWriter.write(json);
				printWriter.flush();
				WebUtils.toHttp(request).getSession().invalidate();
			} catch (Exception e) {
				LOGGER.error("login time validate fail send error fail ,{}", e);
			} finally {
				if (printWriter != null) {
					printWriter.close();
				}
			}
		} else {
			saveRequest(request);
			WebUtils.issueRedirect(request, response, redirectUrl);
		}
		return false;

	}

	private boolean isAjaxRequest(ServletRequest request) {
		boolean isAjaxRequest = false;
		String requestType = ((HttpServletRequest) request).getHeader("X-Requested-With");
		if ("XMLHttpRequest".equals(requestType)) {
			isAjaxRequest = true;
		}
		return isAjaxRequest;
	}
}
