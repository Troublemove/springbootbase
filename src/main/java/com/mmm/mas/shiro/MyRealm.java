package com.mmm.mas.shiro;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.mmm.mas.entity.User;
import com.mmm.mas.service.UserService;

/**
 * 自定义Realm
 * （1）AuthenticatingRealm：shiro中的用于进行认证的领域，实现doGetAuthentcationInfo方法实现用户登录时的认证逻辑；
 * （2）AuthorizingRealm：shiro中用于授权的领域，实现doGetAuthrozitionInfo方法实现用户的授权逻辑，AuthorizingRealm继承了AuthenticatingRealm，
 * 所以在实际使用中主要用到的就是这个AuthenticatingRealm类；
 * （3）AuthenticatingRealm、AuthorizingRealm这两个类都是shiro中提供了一些线程的realm接口
 * （4）在与spring整合项目中，shiro的SecurityManager会自动调用这两个方法，从而实现认证和授权，可以结合shiro的CacheManager将认证和授权信息保存在缓存中，
 * 这样可以提高系统的处理效率。
 *
 */
public class MyRealm extends AuthorizingRealm {

	private static Logger log = LogManager.getLogger(AuthorizingRealm.class);


	@Autowired
	private UserService userService;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//doGetAuthorizationInfo方法可能会执行多次，权限判断次数多少，就会执行多少次
        log.debug("执行授权逻辑");
        
        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        
        //添加资源的授权字符串
        //info.addStringPermission("user:add");
        
        //到数据库查询当前登录用户的授权字符串
        //获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
		Object principal = principals.getPrimaryPrincipal();
        User user = (User)subject.getPrincipal();
        User dbUser = userService.getUserByid(user.getId());
        
        info.addStringPermission(dbUser.getAuth());
		if ("admin".equals(principal)) {
			info.addRole("admin");
		}
		if ("user".equals(principal)) {
			info.addRole("list");
		}
		info.addRole("user");

        return info;
	}

	/**
	 * 用户验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		log.debug("执行用户验证");
		//加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (arg0.getPrincipal() == null) {
            return null;
        }
		
		// 编写shiro判断逻辑，判断用户名和密码
		// 1.判断用户名 token中的用户信息是登录时候传进来的
		UsernamePasswordToken token = (UsernamePasswordToken) arg0;
		
		User user = userService.findByName(token.getUsername());
		
		if (user == null) {
			// 用户名不存在
			return null;// shiro底层会抛出UnKnowAccountException
		} else {
			//这里验证authenticationToken和simpleAuthenticationInfo的信息
			// 2.判断密码
			// 第二个字段是user.getPassword()，注意这里是指从数据库中获取的password。第三个字段是realm，即当前realm的名称。
			// 这块对比逻辑是先对比username，但是username肯定是相等的，所以真正对比的是password。
			// 从这里传入的password（这里是从数据库获取的）和token（filter中登录时生成的）中的password做对比，如果相同就允许登录，
			// 不相同就抛出IncorrectCredentialsException异常。
			// 如果认证不通过，就不会执行下面的授权方法了
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword().toString(), getName());
            return simpleAuthenticationInfo;
		}
	}

	/**
	 * 将一些数据放到ShiroSession中,以便于其它地方使用
	 *
	 * 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
	 */
	private void setSession(Object key, Object value) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			log.debug("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
			if (null != session) {
				session.setAttribute(key, value);
			}
		}
	}
}
