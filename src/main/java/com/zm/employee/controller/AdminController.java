package com.zm.employee.controller;

import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zm.employee.bean.Admin;
import com.zm.employee.bean.Msg;
import com.zm.employee.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService service;


	// 查询所有
	@ResponseBody
	@RequestMapping(value = "adminMsg",method = RequestMethod.GET)
	public Msg getAdminMsg(@RequestParam(value = "pn",defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn,10);
		List<Admin>list = service.getAdminMsg();
		PageInfo<Admin> pageInfo = new PageInfo<>(list, 5);
		return Msg.success().add("pageInfo", pageInfo);
	}

	//增加信息
	@ResponseBody
	@RequestMapping(value = "adminMsg",method = RequestMethod.POST)
	public Msg addAdmin(Admin admin) {
		System.out.println(admin);
		try {
			//盐值加密  即把用户名加进去   再把123MD5加密
			ByteSource credentialsSalt = ByteSource.Util.bytes(admin.getAdminname());
			//SimpleHash执行加密
			SimpleHash simpleHash = new SimpleHash("MD5",admin.getAdminpwd(), credentialsSalt, 1024);
			admin.setAdminpwd(simpleHash.toString());
			service.addAdmin(admin);
			return Msg.success();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Msg.error();
		}
	}

	//更新信息
	@ResponseBody
	@RequestMapping(value = "adminMsg",method = RequestMethod.PUT)
	public Msg updateAdmin(@RequestParam String pwd,@RequestParam Integer id) {
		service.updateAdmin(id,pwd.trim());
		return Msg.success();

	}

	//删除管理员
	@ResponseBody
	@RequestMapping(value = "adminMsg/{Ids}",method = RequestMethod.DELETE)	
	public Msg deleteEmp(@PathVariable("Ids") String Ids) {
		service.delAdmin(Ids.trim());

		return Msg.success();
	}
	
	@ResponseBody
	@RequestMapping(value = "updatePwd",method = RequestMethod.POST)	//此处路径填写empId  会自动绑定到Emp对象中
	public Msg updatePwd(@RequestParam String id,@RequestParam String oldPwd,@RequestParam String newPwd) {
		
		long suc = service.updatePwd(id,oldPwd,newPwd);	//更新
		return Msg.success().add("scount", suc);
		
	}
}
