package org.hxn.app.shiro.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.hxn.app.entity.Resource;
import org.hxn.app.entity.Role;
import org.hxn.app.entity.User;
import org.hxn.app.service.UserService;
import org.hxn.app.shiro.kit.ShiroKit;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User user = (User) principals.getPrimaryPrincipal();

		Set<Role> rs = user.getRoles();
		Set<String> roles = new HashSet<String>();
		Set<String> permissions = new HashSet<String>();
		for (Role role : rs) {
			roles.add(role.getSn());
			for (Resource resource : role.getResources()) {
				permissions.add(resource.getUrl());
			}
		}

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setRoles(roles);
		info.setStringPermissions(permissions);

		return info;
	}

	// 认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//		UserService userService = (UserService) InitServlet.getBean("userServiceImpl");
		String username = (String) token.getPrincipal().toString();
		String password = new String((char[]) token.getCredentials());
		User user = userService.get("username", username);

		if (null == user) {
			throw new UnknownAccountException("用户不存在！");
		}
		if (user.getLocked()) {
			throw new LockedAccountException("帐号锁定!");
		}
		if (!ShiroKit.md5(password, user.getUsername()).equals(user.getPassword())) {
			throw new IncorrectCredentialsException("密码错误！");
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
		info.setCredentialsSalt(ByteSource.Util.bytes(user.getUsername()));
		return info;
	}

}
