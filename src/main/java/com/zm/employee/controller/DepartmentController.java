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
import com.zm.employee.bean.Department;
import com.zm.employee.bean.Msg;
import com.zm.employee.service.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService service;

	// 查询所有部门
	@ResponseBody
	@RequestMapping("depts")
	public Msg getDepts() {
		List<Department>list = service.getDepts();

		return Msg.success().add("depts", list);
	}


	// 查询所有部门详细信息
	@ResponseBody
	@RequestMapping(value = "deptsMsg",method = RequestMethod.GET)
	public Msg getDeptsMsg(@RequestParam(value = "pn",defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn,10);
		List<Department>list = service.getDeptsMsg();
		PageInfo<Department> pageInfo = new PageInfo<>(list, 5);
		return Msg.success().add("pageInfo", pageInfo);
	}

	//增加部门信息
	@ResponseBody
	@RequestMapping(value = "deptsMsg",method = RequestMethod.POST)
	public Msg addDept(@RequestParam String name) {
		boolean addDept = service.addDept(name.trim());
		if(addDept) {
			return Msg.success();
		}else {
			return Msg.error();
		}

	}

	//更新部门信息
	@ResponseBody
	@RequestMapping(value = "deptsMsg",method = RequestMethod.PUT)
	public Msg updateDept(@RequestParam String name,@RequestParam Integer id) {
		boolean updateDept = service.updateDept(id,name.trim());
		if(updateDept) {
			return Msg.success();
		}else {
			return Msg.error();
		}

	}
	
	//删除部门
	@ResponseBody
	@RequestMapping(value = "deptsMsg/{Ids}",method = RequestMethod.DELETE)	
	public Msg DeleteEmp(@PathVariable("Ids") String Ids) {
		service.delDept(Ids.trim());
		
		return Msg.success();
	}
	
	
	
	
	
	
	
	
}
