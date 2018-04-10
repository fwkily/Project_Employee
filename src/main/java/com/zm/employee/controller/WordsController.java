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
import com.zm.employee.bean.Msg;
import com.zm.employee.bean.Words;
import com.zm.employee.service.WordsService;

@Controller
public class WordsController {

	@Autowired
	private WordsService service; 
	
	//查询
	@ResponseBody
	@RequestMapping(value = {"words","user/words"},method = RequestMethod.GET)
	public Msg showW(@RequestParam(value = "pn",defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn,10);
		List<Words> list = service.showW();
		PageInfo<Words>pageInfo = new PageInfo<>(list, 5);
		return Msg.success().add("pageInfo", pageInfo);
	}
	
	//新增
	@ResponseBody
	@RequestMapping(value = {"words","user/addwords"},method = RequestMethod.POST)
	public Msg addW(@RequestParam String name,@RequestParam String content) {
		service.addW(name,content);
		return Msg.success();
	}
	
	//批量删除和单个删除
	@ResponseBody
	@RequestMapping(value = "words/{id}",method = RequestMethod.DELETE)
	public Msg delW(@PathVariable("id") String id) {
		service.delW(id);
		return Msg.success();
	}
	
}
