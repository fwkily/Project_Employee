package com.zm.employee.shiro.realm;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.zm.employee.bean.Admin;
import com.zm.employee.bean.AdminExample;
import com.zm.employee.bean.AdminExample.Criteria;
import com.zm.employee.dao.AdminMapper;

/**
* @Title ShiroRealm
* @Description 本类主要功能是自定义Realm  来连接数据库验证用户名密码  验证方式MD5
* @Company null
* @author 曾敏
* @date 2017年8月14日下午12:12:42
*/
public class ShiroRealm extends AuthorizingRealm{

	@Autowired
	private AdminMapper mapper;
	
	//用于认证的方法
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
	
		//1 把AuthenticationToken强制转换为UsernamePasswordToken  好获取表单传过来的username
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		
		//2 从数据库获取username  一般通过usernamePasswordToken。getUsername()来查  如果没有这个用户名 抛出异常   有的话 就查密码
		String username = usernamePasswordToken.getUsername(); //"admin";
		
		//3 调用数据库方法  从数据库中查询username对应的用户记录
		System.out.println("从数据库中查询：" + username + " 的信息");

		
		
		//以下信息是从数据库中获取的
		//principal 数据库用户名
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andAdminnameEqualTo(username);
		List<Admin> principal =  mapper.selectByExample(example);	
		String credentials ="";
		SimpleHash simpleHash = null;
		if(principal.size()==0) {
			//4 若用户不存在  抛出异常  这里异常不要往出抛 不然gg
//			throw new UnknownAccountException("用户不存在");
		}else {
			//若存在   取出密码加密
			//credentials 数据库密码   查出来再加密
			String pwd = "";		//从List获取密码出来加密
			for (Admin user : principal) {
				pwd = user.getAdminpwd();
			}
			
			//盐值加密  即把用户名加进去   再把123MD5加密
			ByteSource credentialsSalt = ByteSource.Util.bytes(username);
			//SimpleHash执行加密
			simpleHash = new SimpleHash("MD5",pwd, credentialsSalt, 1024);
			
			// 吧simplehsh赋值给密码
			credentials = simpleHash.toString();
			
		}
		
		//realm的名称  直接从父类获取
		String realmName = getName();
		//设置盐值  保证不同用户相同的密码加密后不一样
		ByteSource credentialsSalt = ByteSource.Util.bytes(username);
		
		/*
		5 根据用户信息的情况 决定是否需要抛出其他的AuthenticationException异常
		if("lock".equals(username)){
			throw new LockedAccountException("用户被锁定");
		}
		
		if("admin".equals(username)) {
			credentials= "c41d7c66e1b8404545aa3a0ece2006ac";
		}
		if("user".equals(username)) {
			credentials	= "2bbffae8c52dd2532dfe629cecfb2c85";
		}
		 */
		//6 构建 AuthenticationInfo对象并且返回  通常实现类为SimpleAuthenticationInfo
		//这里把数据库中查询到相对应username的password返回  然后shiro  使用复杂构造器 添加MD5盐值加密
																//	用户名			密码		  盐值(用于计算前台密码加密) realm名称 就是本类
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
		
		return info;
	}

	//用于授权的方法
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		//3 用登陆用户的信息获取角色和权限   把权限放进去  
			AuthorizationInfo info  =null ;
		//1 从PrincipalCollection获取登陆用户的信息（用户名）
		Admin principal = null;
		try {
			principal =	(Admin) principals.getPrimaryPrincipal();
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
			return info;
		}
	
		//2 获取当前用户的角色和权限  （查询数据库）  
		Set<String> set = new HashSet<>();
		//添加权限名称  需要和ApplicationContent.xml中的roles后面的权限名称相同
		set.add("admin");
		
		//从数据库查询权限
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andAdminnameEqualTo(principal.getAdminname());
		List<Admin> list = mapper.selectByExample(example);
		String power = "0";
		for (Admin user : list) {
			power = user.getAdminpower();		//从user中获取权限
		}	
		
		if(power.trim().equals("1")) {
			set.add("superadmin");
		}
		
		//返回
		info = new SimpleAuthorizationInfo(set);
		return info;
	}

	
	

}
