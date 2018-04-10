package com.zm.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.employee.bean.Index;
import com.zm.employee.dao.AdminMapper;
import com.zm.employee.dao.DepartmentMapper;
import com.zm.employee.dao.EmployeeMapper;
import com.zm.employee.dao.TaskMapper;

@Service
public class IndexService {

	@Autowired
	private EmployeeMapper empMapper;
	
	@Autowired
	private DepartmentMapper deptMapper;
	
	@Autowired
	private AdminMapper adMapper;
	
	@Autowired
	private TaskMapper tmapper;
	
	public Index shwIndex() {
		// TODO Auto-generated method stub
		Index i = new Index();
		i.setEmpCount(empMapper.countByExample(null));
		i.setDeptCount(deptMapper.countByExample(null));
		i.setAdminCount(adMapper.countByExample(null));
		i.setTaskCount(tmapper.countByExample(null));
		return i;
	}
	
}
