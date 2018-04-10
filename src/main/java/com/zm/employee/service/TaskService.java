package com.zm.employee.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.employee.bean.Department;
import com.zm.employee.bean.Employee;
import com.zm.employee.bean.Task;
import com.zm.employee.bean.TaskExample;
import com.zm.employee.bean.TaskExample.Criteria;
import com.zm.employee.dao.DepartmentMapper;
import com.zm.employee.dao.EmployeeMapper;
import com.zm.employee.dao.TaskMapper;

@Service
public class TaskService {

	@Autowired
	private TaskMapper mapper;

	@Autowired
	private EmployeeMapper empMapper;
	@Autowired
	private DepartmentMapper deMapper;

	//查询全部
	public List<Task> showTask() {
		// TODO Auto-generated method stub
		TaskExample example = new TaskExample();
		example.setOrderByClause("id DESC");
		List<Task> list = mapper.selectByExample(example);

		return list;
	}
	//按照id查询
	public Task showTaskById(Integer id) {
		// TODO Auto-generated method stub
		Task list = mapper.selectByPrimaryKey(id);
		StringBuffer buffer = new StringBuffer();
		//0为单人任务  通过id查出员工名称
		if(list.getTclass()==0) {
			String ids = list.getTarget();
			String[] strings = ids.split(",");
	
			for (String i : strings) {
				Employee e = empMapper.selectByPrimaryKey(Integer.parseInt(i));
				buffer.append(e.getEmpName() + ",");
			}
		}
		//1为部门任务  通过id查出部门名称
		if(list.getTclass()==1) {
			String ids = list.getTarget();
			String[] strings = ids.split(",");
			for (String i : strings) {
				Department d = deMapper.selectByPrimaryKey(Integer.parseInt(i));
				buffer.append(d.getDeptName() + ",");
			}
		}


		String target = buffer.toString();
		
		//去掉最后的，
		if(target.charAt(target.length()-1)==',') {
			target = target.substring(0, target.length()-1);
		}
		
		list.setTarget(target);

		return list;
	}



	public void addTask(Task t,String admin) {
		// TODO Auto-generated method stub
		//替换中文逗号
		if(t.getTarget().contains("，")) {
			t.getTarget().replaceAll("，", ",");
		}
		Date date = new Date();
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = d.format(date);
		t.setTdate(format);
		t.setTadmin(admin);
		mapper.insertSelective(t);
	}

	public void delTask(String id) {
		// TODO Auto-generated method stub
		TaskExample example = new TaskExample();
		Criteria criteria = example.createCriteria();

		List<Integer> list = new ArrayList<>();
		if(id.contains("-")) {
			String[] split = id.split("-");
			for (String ids : split) {
				list.add(Integer.parseInt(ids));
			}
			//存放所有被删除的id 
			criteria.andIdIn(list);
			mapper.deleteByExample(example);
		}else {
			mapper.deleteByPrimaryKey(Integer.parseInt(id));
		}
	}
	public List<Task> showTaskByUser(Integer empId) {
		// TODO Auto-generated method stub
		TaskExample example = new TaskExample();
		example.setOrderByClause("id DESC");
		Criteria criteria = example.createCriteria();
		criteria.andTargetLike("%" + empId.toString() + "%");
		List<Task> list = mapper.selectByExample(example);
		return list;
	}







}
