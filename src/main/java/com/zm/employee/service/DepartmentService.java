package com.zm.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.employee.bean.Department;
import com.zm.employee.bean.DepartmentExample;
import com.zm.employee.bean.DepartmentExample.Criteria;
import com.zm.employee.dao.DepartmentMapper;

@Service
public class DepartmentService {

	@Autowired
	DepartmentMapper mapper;

	//  查询所有部门
	public List<Department> getDepts() {
		// TODO Auto-generated method stub
		List<Department> list = mapper.selectByExample(null);
		return list;
	}

	public List<Department> getDeptsMsg() {
		// TODO Auto-generated method stub
		List<Department> list = mapper.selectByExample(null);

		//此处为了查询到各部门的人数 先取出来 然后通过id查询出来并设置上
		for (Department d : list) {
			int dept = mapper.selectCountByEmp(d.getDeptId()); 
			d.setDeptDesc(String.valueOf(dept));
		}
		return list;
	}

	public boolean addDept(String name) {
		// TODO Auto-generated method stub
		if(checkDeptName(name)==false) {
			mapper.insertSelective(new Department(null, name));
			return true;
		}else {
			return false;
		}

	}

	//检查部门名是否重复
	public boolean checkDeptName(String name) {
		DepartmentExample example = new DepartmentExample();
		Criteria criteria = example.createCriteria();
		//		给criteria添加筛选条件
		criteria.andDeptNameEqualTo(name);
		long l = mapper.countByExample(example);
		if(l==0) {
			return false;
		}else {
			return true;
		}

	}

	//更新部门信息
	public boolean updateDept(Integer id, String name) {
		// TODO Auto-generated method stub
		if(checkDeptName(name)==false) {
			mapper.updateByPrimaryKey(new Department(id, name));
			return true;
		}else {
			return false;
		}
	}
	

	//批量删除
	public void delDept(String id) {
		// TODO Auto-generated method stub
		DepartmentExample example = new DepartmentExample();
		Criteria criteria = example.createCriteria();
		List<Integer> list = new ArrayList<>();
		if(id.contains("-")) {
			String[] split = id.split("-");
			for (String ids : split) {
				list.add(Integer.parseInt(ids));
			}
			//存放所有被删除的id 
			criteria.andDeptIdIn(list);	
			mapper.deleteByExample(example);
		}else {
			mapper.deleteByPrimaryKey(Integer.parseInt(id));
		}


	}
}
