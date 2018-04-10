package com.zm.employee.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zm.employee.bean.Gg;
import com.zm.employee.bean.Index;
import com.zm.employee.bean.Msg;
import com.zm.employee.service.GsService;
import com.zm.employee.service.IndexService;

@Controller	
public class IndexController {

	@Autowired
	private IndexService service;
	
	@Autowired
	private GsService ggService;
	
	@ResponseBody
	@RequestMapping("/ic")
	public Msg shwoIndex(HttpServletRequest req) {
		Index i = service.shwIndex();
		req.setAttribute("list", i);
		return Msg.success().add("map", i);
	}
	
	@ResponseBody
	@RequestMapping("user/ggOne")
	public Msg showGgOne() {
		Gg i = ggService.showGgOne();
		return Msg.success().add("map", i);
	}
}
