package com.zm.employee.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.employee.bean.Check;
import com.zm.employee.bean.CheckExample;
import com.zm.employee.bean.CheckExample.Criteria;
import com.zm.employee.bean.Employee;
import com.zm.employee.dao.CheckMapper;
import com.zm.employee.dao.EmployeeMapper;
@Service
public class CheckService {

	@Autowired
	private CheckMapper mapper;
	@Autowired
	private EmployeeMapper employeeMapper;
	private Criteria createCriteria;
	
	//查询全部打卡详细
	public List<Check> showCheck() {
		// TODO Auto-generated method stub
		List<Check> list = mapper.selectByExample(null);
		return list;
	}

	//查看当天打开的人员名单
	public List<Employee> showCheckAll(String ids) {
		// TODO Auto-generated method stub
		//去掉第一个 ，
		
				if(ids.indexOf(",")==0) {
					ids = ids.substring(1, ids.length());
				}
				System.out.println(ids);
		List<Employee> list = new ArrayList<>();
		
		if(ids.trim().contains(",")) {
			String[] id = ids.split(",");
			for (String i : id) {
				Employee e = employeeMapper.selectByPrimaryKeyAndDept(Integer.parseInt(i));
				list.add(e);
			}
			
		}else {
			//只有一个的情况
			Employee e = employeeMapper.selectByPrimaryKeyAndDept(Integer.parseInt(ids));
			list.add(e);
		}
		
		
		return list;
	}

	//查询
	public List<Check> cxCheck(String select, String msg) {
		// TODO Auto-generated method stub
		List<Check> list = new ArrayList<>();
		
		//判断是按照id还是时间查询
		if(select.trim().equals("date")) {
			CheckExample example = new CheckExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andDateEqualTo(msg.trim());
			list = mapper.selectByExample(example);
		}
		
		if(select.trim().equals("id")) {
			CheckExample example = new CheckExample();
			Criteria createCriteria = example.createCriteria();
			//这里虽然是Example的like条件  但是他不会自动加% %
			createCriteria.andEpmidLike("%" + msg + "%");
			list = mapper.selectByExample(example);
		}
		
		return list;
	}
	
	//检查当前用户是否打卡
	public List<Check> cxCheckOne(Integer id) {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String ymd = format.format(date);
		
		CheckExample example = new CheckExample();
		Criteria criteria = example.createCriteria();
		criteria.andEpmidLike("%" + id.toString() + "%");
		criteria.andDateEqualTo(ymd);
		List<Check> list = mapper.selectByExample(example);
		
		return list;
	}

	//打卡的逻辑
	public void CheckDk(Integer id) {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String ymd = format.format(date);
		
		//如果数据库没有今天的数据  执行插入
		if(CheckNowDay()==false) {
			Check record = new Check();
			record.setDate(ymd);
			record.setEpmid(id.toString());
			mapper.insertSelective(record);
		}else {
			//如果及今天已经存在  执行更新后面的empId
			mapper.updateDkEmpid("," + id.toString(), ymd);
		}
	}
	
	//判断数据表有没有今天这一列
	public boolean CheckNowDay() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String ymd = format.format(date);
		
		CheckExample example = new CheckExample();
		Criteria criteria = example.createCriteria();
		criteria.andDateEqualTo(ymd);
		List<Check> list = mapper.selectByExample(example);
		
		if(list.size()>0){
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
}
