package com.zm.employee.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.employee.bean.Employee;
import com.zm.employee.bean.EmployeeExample;
import com.zm.employee.bean.EmployeeExample.Criteria;
import com.zm.employee.dao.EmployeeMapper;

@Service
public class EmployeeService {

	@Autowired
	EmployeeMapper mapper;

	//查询所有
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return mapper.selectByExampleAndDept(null);
	}

	//保存员工
	public void saveEmps(Employee e) {
		// TODO Auto-generated method stub
		mapper.insertSelective(e);
	}

	//检查用户名是否重复
	public boolean checkUser(String empName) {
		// TODO Auto-generated method stub
		EmployeeExample example = new EmployeeExample();
		//创建一个条件查询
		Criteria criteria = example.createCriteria();
		// 给criteria中添加比较条件
		criteria.andEmpNameEqualTo(empName);
		//查询出符合条件的有多少行
		long c = mapper.countByExample(example);
		return c == 0;	//c为true表示没有相同的用户名
	}

	//按id查询
	public Employee getEmpsById(Integer id) {
		// TODO Auto-generated method stub
		Employee employee = mapper.selectByPrimaryKeyAndDept(id);
		return employee;
	}

	//更新
	public long updateEmp(Employee e) {
		// TODO Auto-generated method stub
		int key = mapper.updateByPrimaryKeySelective(e);
		return key;
	}

	//单个删除
	public long deleteEmp(Integer id) {
		// TODO Auto-generated method stub
		int key = mapper.deleteByPrimaryKey(id);
		return key;
	}

	//批量删除
	public long delteEmpBactch(List<Integer> values) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();

		// 相当于delete from tb_emp where id in(1,2,3,4)
		criteria.andEmpIdIn(values);
		int byExample = mapper.deleteByExample(example);
		return byExample;
	}

	//查找员工
	public List<Employee> findEmp(String selectValue, String selectMsg) {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<>();

		//判断用户的选择
		switch (selectValue.trim()) {
		case "id":
			Employee e  = mapper.selectByPrimaryKeyAndDept(Integer.parseInt(selectMsg.trim()));
			list.add(e);
			break;
		case "name":
			list = mapper.selectEmpByName("%" +selectMsg + "%");
			break;
		case "dept":
			list = mapper.selectEmpByDept(Integer.parseInt(selectMsg));
			break;
		default:
			list = mapper.selectByExample(null);
			break;
		}
		System.out.println(list);
		return list;
	}

	//修改密码逻辑
	public long updatePwd(String id, String oldPwd, String newPwd) {
		// TODO Auto-generated method stub
		long keySelective = 0;
		if(checkPwd(id, oldPwd)>0) {
			keySelective = mapper.updateEmpPwd(Integer.parseInt(id.trim()), newPwd.trim());
			return keySelective;
		}else {
			return -1;
		}
	}

	//检查原密码是否正确
	public int checkPwd(String id,String oldPwd) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andPwdEqualTo(oldPwd);
		criteria.andEmpIdEqualTo(Integer.parseInt(id));
		List<Employee> list = mapper.selectByExample(example);
		return list.size();
	}

}
