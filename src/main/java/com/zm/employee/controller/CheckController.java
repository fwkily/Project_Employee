package com.zm.employee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zm.employee.bean.Check;
import com.zm.employee.bean.Employee;
import com.zm.employee.bean.Msg;
import com.zm.employee.service.CheckService;

@Controller
public class CheckController {

	@Autowired
	private CheckService service;
	
	//总览
	@ResponseBody
	@RequestMapping("/checkMsg")
	public Msg showCheck(@RequestParam(value = "pn",defaultValue="1",required = false) Integer pn) {
	
		PageHelper.startPage(pn,10);
		List<Check> list = service.showCheck();
		
		PageInfo<Check> pageInfo = new PageInfo<>(list,5);
		
		return Msg.success().add("pageInfo", pageInfo);
	}
	
	//显示详细
	@ResponseBody
	@RequestMapping("/checkMsgAll")
	public Msg showCheckAll(@RequestParam String ids,HttpServletRequest req) {
	
		List<Employee> list = service.showCheckAll(ids);
		req.setAttribute("list", list);
		return Msg.success().add("list", list);
	}
	
	//查询
	@ResponseBody
	@RequestMapping("/cxCheck")
	public Msg cxCheck(@RequestParam String select,@RequestParam String msg,@RequestParam Integer pn, HttpServletRequest req) {
	
		PageHelper.startPage(pn,10);
		List<Check> list = service.cxCheck(select,msg);
	
		PageInfo<Check> pageInfo = new PageInfo<>(list,5);
		
		req.setAttribute("list", list);
		return Msg.success().add("pageInfo", pageInfo);
	}
	
	//查询单个
	@ResponseBody
	@RequestMapping("user/cxOne")
	public Msg cxCheckOne(@RequestParam Integer id) {
		List<Check> list = service.cxCheckOne(id);
		int count = list.size();
		return Msg.success().add("count", count);
	}
	
	//执行打卡
		@ResponseBody
		@RequestMapping("user/dk")
		public Msg CheckDk(@RequestParam Integer id) {
			
			 service.CheckDk(id);
		
			return Msg.success();
		}
}
