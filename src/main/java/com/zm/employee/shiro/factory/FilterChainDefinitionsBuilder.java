package com.zm.employee.shiro.factory;


import java.util.LinkedHashMap;

public class FilterChainDefinitionsBuilder {

	/**
	 * <!-- 配置哪些页面受保护以及访问这些页面需要的权限 
		anon 匿名可以访问 
		authc 必须认证之后才能访问 
		URL权限采取第一次匹配优先的原则 
		roles 角色权限控制  roles[角色名]
			logout 登出 
				/login.jsp = anon
				/logout = logout
				/shiro_auth = anon
				/user.jsp = roles[user]
				/admin.jsp = roles[admin]

				/static/** = anon
				# everything else requires authentication:
				/** = authc
	 * @Title: buildFilterChainDefinitionMap
	 * @Description:
	 * @return
	 */
	public LinkedHashMap<String , String> buildFilterChainDefinitionMap(){
		//添加权限   必须按照顺序
		LinkedHashMap<String , String> map = new LinkedHashMap<>();
		map.put("/AdminLogin", "anon");
		map.put("/login", "anon");
		map.put("/logout", "logout");
		map.put("/static/**", "anon");
		map.put("/a", "roles[superadmin]");
//		map.put("/user/**", "anon");
		map.put("/**", "authc");
		return map;
	}
}
