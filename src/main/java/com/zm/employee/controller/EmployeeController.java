package com.zm.employee.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zm.employee.bean.Employee;
import com.zm.employee.bean.Msg;
import com.zm.employee.service.EmployeeService;

/**
* @Title EmployeeController
* @Description 本类主要功能是处理Employee crud请求
* @Company null
* @author 曾敏
* @date 2017年7月25日上午10:18:41
*/

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	// slf4j输出日志
//	Logger log = LoggerFactory.getLogger(EmployeeController.class);
	/**
	* @Title: getEmps
	* @Description:查询员工数据
	* @return
	 */
	@ResponseBody
	@RequestMapping("/emps")
	public Msg getEmps(@RequestParam(value="pn",defaultValue = "1")Integer pn) {
		
		try {
				// 分页  传入页码  和 每页大小
		PageHelper.startPage(pn, 10);
		List<Employee> emps = empService.getAll();
		
		//  用pageInfo包装结果集  里面封装了详细的分页详细信息  传入页码导航
		PageInfo<Employee> page = new PageInfo<>(emps,5);
		// 传到页面
//		log.info("已经存入page到Request中" + page.toString());
		
		// 如果成功  返回状态信息以及数据
		return Msg.success().add("pageInfo",page);
		
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Msg.error();
		}
	}
	
	/**
	* @Title: 按名称查询用户
	* @Description:
	* @param e
	* @param result
	* @return
	 */
	@ResponseBody
	@RequestMapping("/findEmp")
	public Msg findEmp(@RequestParam String selectBox,@RequestParam String selectMsg,@RequestParam(value = "pn",
	defaultValue ="1" )Integer pn) {
		List<Employee> list = new ArrayList<>();
		
		//如果他不为空就是按照id和姓名查询了
		if(selectMsg!="") {
		PageHelper.startPage(pn,10);
		list =  empService.findEmp(selectBox,selectMsg.trim());
		}else {
			//如果文本框为空  就是按照部门查询了
			PageHelper.startPage(pn,10);
			list =  empService.findEmp(selectBox,String.valueOf(selectMsg));
		}
		PageInfo<Employee> info = new PageInfo<>(list, 5);
		
		return Msg.success().add("pageInfo", info);
	}
	
	
	
	
	
	
	/*
	 * Restful风格的URi
	 * emp/{id} GET 查询员工 
	 * emp POSt 保存员工
	 * emp{id} PUT 修改员工
	 * emp{id} DELETE  删除员工
	 * JSR 303校验
	 * 导入Hibernate-validator
	 */
	@RequestMapping(value="emp",method = RequestMethod.POST)
	@ResponseBody
	public Msg saveEmps(@Valid Employee e,BindingResult result) {	// 这边直接传对象  SpringMVc会映射表单的字段到bean中
				//@Valid	JSR303校验
		if(result.hasErrors()) {
			//声明一个放错误信息的map
			Map<String , Object> map = new HashMap<>();
			
			//取出所有错误信息
			List<FieldError> fieldErrors = result.getFieldErrors();
			for (FieldError fieldError : fieldErrors) {
				System.out.println(fieldError.getField());
				System.out.println(fieldError.getDefaultMessage());
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.error().add("fieldError", map);
		}else {
			empService.saveEmps(e);
			return Msg.success();
		}
	}
	
	//判断用户名重复
	@RequestMapping(value = "checkUser",method = RequestMethod.POST)
	@ResponseBody
	public Msg checkuser(@RequestParam("empName")String empName) {
		String regex = "(^[a-z0-9_-]{3,16})|(^[\\u2E80-\\u9FFF]{2,5})";
		//创建正则表达式匹配字符串
		boolean c = empName.matches(regex);
//		System.out.println(c);
		if(c == false) {
			return Msg.error().add("val_msg", "用户名必须是3~16位英文或者是2~5位汉字组合");
		}
		
		boolean b = empService.checkUser(empName);
		if (b) {
			return Msg.success();
		}else {
			return Msg.error().add("val_msg", "用户名不可用");
		}
	}
	
	//修改员工》》》按id查询
	@ResponseBody
	@RequestMapping(value = "emp/{id}",method = RequestMethod.GET)
	public Msg getEmpsById(@PathVariable("id") Integer id) {
		Employee e = empService.getEmpsById(id);
		
		return Msg.success().add("emp", e);
	}
	
	//更新员工
	/**
	* 
	* @Title: updateEmp
	* @Description:
	* @param e
	* @return
	* 
	* 问题：ajax不能直接发送PUT请求 
	* 		导致SPringMVC封装请求体的表单数据  也就是reqeus.getParameter("")拿不到值
	* 	Employee [empId=999, empName=null, gender=null, email=null, dId=null, dept=null]
	* 原因：Tomcat底层识别是put请求  则不会封装参数进map  只有post形式的请求才会封装map
	* 
	* 解决：若要直接发送put请求 需要在web.xml配置put请求过滤器 HttpPutFormContentFilter
	* 			HttpPutFormContentFilter作用：将请求体中的数据包装成一个map
	* 				request被重新包装  request.getParameter("")被重新包装就能从map中取出参数值
	 */
	@ResponseBody
	@RequestMapping(value = "emp/{empId}",method = RequestMethod.PUT)	//此处路径填写empId  会自动绑定到Emp对象中
	public Msg updateEmp(Employee e) {
		
//		System.out.println(e);
		
		long suc = empService.updateEmp(e);	//更新
		
		return Msg.success().add("scount", suc);
		
	}
	
	//删除员工  批量和单个二合一的方法  主要是判断有没有 - 
	@ResponseBody
	@RequestMapping(value = "emp/{empIds}",method = RequestMethod.DELETE)	
	public Msg DeleteEmp(@PathVariable("empIds") String empIds) {
		
		List<Integer>list = new ArrayList<>();
		
		if(empIds.contains("-")) {
			//如果存在-   截取字符串遍历
			String[] split = empIds.split("-");
			for (String str : split) {
				list.add(Integer.parseInt(str));
			}
			
			long bactch = empService.delteEmpBactch(list);
			System.out.println(list);
			return Msg.success().add("sucount", bactch);
		}else {
			long suc = empService.deleteEmp(Integer.parseInt(empIds));	//更新
			return Msg.success().add("scount", suc);
		}
		
	}

	@ResponseBody
	@RequestMapping(value = "user/updatePwd",method = RequestMethod.POST)	//此处路径填写empId  会自动绑定到Emp对象中
	public Msg updatePwd(@RequestParam String id,@RequestParam String oldPwd,@RequestParam String newPwd) {
		
		System.out.println("id:" + id);
		System.out.println("oldPwd:" + oldPwd);
		System.out.println("newPwd:" + newPwd);
		long suc = empService.updatePwd(id,oldPwd,newPwd);	//更新
		return Msg.success().add("scount", suc);
		
	}
}
