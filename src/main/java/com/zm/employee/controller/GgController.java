package com.zm.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zm.employee.bean.Gg;
import com.zm.employee.bean.Msg;
import com.zm.employee.service.GsService;

@Controller
public class GgController {

	@Autowired
	private GsService service;
	
	//查询
	@ResponseBody
	@RequestMapping(value = "gg",method = RequestMethod.GET)
	public Msg showGg(@RequestParam(value = "pn",defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn,10);
		List<Gg> list = service.showGg();
		PageInfo<Gg>pageInfo = new PageInfo<>(list, 5);
		return Msg.success().add("pageInfo", pageInfo);
	}
	
	//新增
	@ResponseBody
	@RequestMapping(value = "gg",method = RequestMethod.POST)
	public Msg addGg(@RequestParam String name,@RequestParam String content) {
		service.addGg(name,content);
		return Msg.success();
	}
	
	//批量删除和单个删除
	@ResponseBody
	@RequestMapping(value = "gg/{id}",method = RequestMethod.DELETE)
	public Msg delGg(@PathVariable("id") String id) {
		service.delGg(id);
		return Msg.success();
	}
	
}
