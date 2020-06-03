package com.mmm.mas.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

/**
 * Shiro的配置类
 * 
 */
@Configuration
public class ShiroConfig {

	/**
	 * 创建ShiroFilterFactoryBean
	 */
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(
			@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {

		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		// 设置安全管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager);

		// 添加Shiro内置过滤器
		/**
		 * Shiro内置过滤器，可以实现权限相关的拦截器 常用的过滤器： anon: 无需认证（登录）可以访问 authc: 必须认证才可以访问 user:
		 * 如果使用rememberMe的功能可以直接访问 perms： 该资源必须得到资源权限才可以访问 role: 该资源必须得到角色权限才可以访问
		 */
		Map<String, String> filterMap = new LinkedHashMap<String, String>();
		/*
		 * filterMap.put("/add", "authc"); filterMap.put("/update", "authc");
		 */

//		filterMap.put("/testThymeleaf", "anon");
		// 放行login.html页面
		filterMap.put("/login", "anon");

		// 授权过滤器
		// 注意：当前授权拦截后，shiro会自动跳转到未授权页面
		// perms括号中的内容是权限的值
//		filterMap.put("/add", "auth[user:add]");
//		filterMap.put("/update", "auth[user:update]");

		filterMap.put("/*", "authc");

		// 修改调整的登录页面
		shiroFilterFactoryBean.setLoginUrl("/toLogin");
		// 设置未授权提示页面
		shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");

		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

		return shiroFilterFactoryBean;
	}

	/**
	 * 创建DefaultWebSecurityManager
	 * 
	 * 里面主要定义了登录，创建subject，登出等操作
	 */
	@Bean(name = "securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("MyRealm") MyRealm MyRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 关联realm
		securityManager.setRealm(MyRealm);
		return securityManager;
	}

	/**
	 * 创建Realm,将自己的验证方式加入容器
	 */
	@Bean(name = "MyRealm")
	public MyRealm getRealm() {
		return new MyRealm();
	}

	/**
	 * 配置ShiroDialect，用于thymeleaf和shiro标签配合使用
	 */
	@Bean
	public ShiroDialect getShiroDialect() {
		return new ShiroDialect();
	}
}
