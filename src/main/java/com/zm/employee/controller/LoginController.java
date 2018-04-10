package com.zm.employee.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
* @Title LoginController
* @Description 本类主要功能是登陆类  用来与Service层分离  用Shiro登陆
* @Company null
* @author 曾敏
* @date 2017年8月17日下午6:57:43
*/
@Controller
public class LoginController {

	//管理员登陆
	@RequestMapping(value = "login",method = RequestMethod.POST)	
	public String login(@RequestParam String username,@RequestParam String password,HttpServletRequest req) {
		//获取当前的subject
		Subject currentUser = SecurityUtils.getSubject();

		if (!currentUser.isAuthenticated()) {
			//如果没有认证  就执行登录
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		
			token.setRememberMe(true);
			try {
				//登录  调用subject的login   实际上是securityManager.login()
				currentUser.login(token);
			
				System.out.println("是否认证：" + currentUser.isAuthenticated());
			}
			//所有认证时异常的父类
			catch (AuthenticationException ae) {
				//unexpected condition?  error?
				System.out.println("登陆失败：" + ae.getMessage());
				
			}
		}
		//Session中存入当前登陆用户对象   Shiro中的Session存的key是JsessionId   不好取值
		Session session = currentUser.getSession();
		
		//如果是管理员  跳转到管理员页面
		if(currentUser.hasRole("admin")) {
			session.setAttribute("admin", currentUser.getPrincipal());
			return "redirect:i";	
		}else if(currentUser.hasRole("user")) {
			//如果是用户
			session.setAttribute("user", currentUser.getPrincipal());
			return "redirect:user/i";	
		}else {
			return "redirect:AdminLogin";	
		}
		
		
	
	}
	
}
