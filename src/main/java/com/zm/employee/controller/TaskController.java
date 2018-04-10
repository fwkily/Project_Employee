package com.zm.employee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.zm.employee.bean.Employee;
import com.zm.employee.bean.Msg;
import com.zm.employee.bean.Task;
import com.zm.employee.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	private TaskService service; 
	
	//查询
	@ResponseBody
	@RequestMapping(value = "task",method = RequestMethod.GET)
	public Msg showTask(@RequestParam(value = "pn",defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn,10);
		List<Task> list = service.showTask();
		PageInfo<Task>pageInfo = new PageInfo<>(list, 5);
		return Msg.success().add("pageInfo", pageInfo);
	}
	
	
	//按ID查询
		@ResponseBody
		@RequestMapping(value = "taskByid/{id}",method = RequestMethod.GET)
		public Msg showTaskById(@PathVariable(value = "id") Integer id,HttpServletRequest req) {
			Task task = service.showTaskById(id);
			req.setAttribute("task", task);
			return Msg.success().add("task", task);
		}
		
	
	//新增
	@ResponseBody
	@RequestMapping(value = "task",method = RequestMethod.POST)
	public Msg addW(Task t,HttpServletRequest req) {
		System.out.println(t);
		Admin admin = (Admin) req.getSession().getAttribute("admin");
		service.addTask(t,admin.getAdminname());
		return Msg.success();
	}
	
	//批量删除和单个删除
	@ResponseBody
	@RequestMapping(value = "task/{id}",method = RequestMethod.DELETE)
	public Msg delW(@PathVariable("id") String id) {
		service.delTask(id);
		return Msg.success();
	}
	
	
	/*********用户功能*********/
	//查询
	@ResponseBody
	@RequestMapping(value = "user/task",method = RequestMethod.GET)
	public Msg showTaskByUser(@RequestParam(value = "pn",defaultValue = "1") Integer pn,HttpServletRequest request) {
		PageHelper.startPage(pn,10);
		Employee e  = (Employee) request.getSession().getAttribute("user");
		Integer empId = e.getEmpId();
	
		List<Task> list = service.showTaskByUser(empId);
		PageInfo<Task>pageInfo = new PageInfo<>(list, 5);
		return Msg.success().add("pageInfo", pageInfo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
