package com.honpe.auth.shiro.realm;

import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import com.honpe.perm.service.PermService;
import com.honpe.po.SysUser;
import com.honpe.role.service.RoleService;
import com.honpe.user.service.SysUserService;

public class AdminRealm extends AuthorizingRealm {

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PermService permService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 获取登录用户名
		String loginAccount = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		SysUser sysUser = (SysUser) session.getAttribute("SYS_USER");
		if (sysUser == null) {
			sysUser = sysUserService.findByLoginAccount(loginAccount);
			session.setAttribute("SYS_USER", sysUser);
		}
		Integer userId = sysUser.getUserId();
		@SuppressWarnings("unchecked")
		Set<String> roles = (Set<String>) session.getAttribute("ROLES");
		if (roles == null || roles.isEmpty()) {
			roles = new HashSet<>();
			String role = roleService.findSysUserRoles(userId).getRoleCode();
			roles.add(role);
			session.setAttribute("ROLES", roles);
		}
		// 设置角色
		authorizationInfo.setRoles(roles);
		@SuppressWarnings("unchecked")
		Set<String> permisstions = (Set<String>) session.getAttribute("PERMISSIONS");
		if (permisstions == null || permisstions.isEmpty()) {
			permisstions = permService.findPermsByUserId(userId);
			session.setAttribute("PERMISSIONS", permisstions);
		}
		// 设置权限
		authorizationInfo.setStringPermissions(permisstions);
		return authorizationInfo;
	}

	@Override
	// 验证的核心方法
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String loginAccount = (String) token.getPrincipal();
		if (StringUtils.isEmpty(loginAccount.trim())) {
			throw new UnknownAccountException();// 没找到帐号
		}
		// 根据登录名查询操作员
		SysUser sysUser = sysUserService.findByLoginAccount(loginAccount);
		if (sysUser == null) {
			throw new UnknownAccountException();// 没找到帐号
		}
		if (sysUser.getIsLock()) {
			throw new LockedAccountException(); // 帐号锁定
		}
		if (sysUser.getIsDiscard()) {
			throw new DisabledAccountException(); // 帐号废弃异常
		}
		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(sysUser.getLoginAccount(),
				sysUser.getLoginPass(), ByteSource.Util.bytes(sysUser.getSalt()), getName());
		return authenticationInfo;
	}

	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}

}
