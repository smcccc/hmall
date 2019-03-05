package com.honpe.auth.shiro.credentials;

import java.util.concurrent.atomic.AtomicInteger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.honpe.log.enums.SysUserLockType;
import com.honpe.po.SysUser;
import com.honpe.user.service.SysUserService;

public class CustomizedHashedCredentialsMatcher extends HashedCredentialsMatcher {

	@Autowired
	private SysUserService sysUserService;

	private Cache<String, AtomicInteger> passwordRetryCache;

	private Cache<String, AtomicInteger> loginTimeCache;

	private final int MAX_RETRY_COUNT = 5;

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomizedHashedCredentialsMatcher.class);

	public CustomizedHashedCredentialsMatcher(CacheManager cacheManager) {
		this.passwordRetryCache = cacheManager.getCache("passwordRetryCache");
		this.loginTimeCache = cacheManager.getCache("loginTimesCache");
	}

	@Override
	/**
	 * 做认证匹配
	 */
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		return doAdminCredentialsMatch(token, info);
	}

	private void lockSysUser(SysUser sysUser) {
		sysUserService.updateSysUserLock(sysUser.getUserId(), SysUserLockType.RETRY_LOCK.lockLogType);
		passwordRetryCache.remove(sysUser.getLoginAccount());
	}

	private boolean doAdminCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		String loginAccount = (String) token.getPrincipal();// 获取用户名

		LOGGER.info("login account {} :" + loginAccount);

		AtomicInteger retryCount = passwordRetryCache.get(loginAccount);
		if (retryCount == null) {
			retryCount = new AtomicInteger(0);
			passwordRetryCache.put(loginAccount, retryCount);
		}
		SysUser sysUser = sysUserService.findByLoginAccount(loginAccount);
		if (retryCount.incrementAndGet() > MAX_RETRY_COUNT) {
			lockSysUser(sysUser);
			passwordRetryCache.remove(loginAccount);
			throw new ExcessiveAttemptsException();
		}
		LOGGER.info("login retry times {} :" + retryCount.get());
		boolean matches = super.doCredentialsMatch(token, info);
		if (matches) {
			AtomicInteger loginTimes = loginTimeCache.get(loginAccount);
			if (loginTimes == null) {
				loginTimes = new AtomicInteger(0);
			}
			loginTimes.addAndGet(1);
			LOGGER.info("login times {} :" + loginTimes.get());
			loginTimeCache.put(loginAccount, loginTimes);
			passwordRetryCache.remove(loginAccount);
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession();
			session.setAttribute("LOGIN_TIMES", loginTimes.get());
			session.setAttribute("SYS_USER", sysUser);
		}
		return matches;
	}
}
