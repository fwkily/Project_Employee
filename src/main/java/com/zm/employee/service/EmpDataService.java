package com.zm.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.employee.bean.EmpData;
import com.zm.employee.bean.EmpDataExample;
import com.zm.employee.bean.EmpDataExample.Criteria;

import com.zm.employee.dao.EmpDataMapper;

@Service
public class EmpDataService {

	@Autowired
	private EmpDataMapper mapper;
	
	
	public List<EmpData> cxMsg(String empid) {
		// TODO Auto-generated method stub
	
		EmpDataExample dataExample = new EmpDataExample();
		Criteria criteria = dataExample.createCriteria();
		criteria.andEmpidEqualTo(Integer.parseInt(empid.trim()));
		List<EmpData> bs = mapper.selectByExample(dataExample);
		return bs;
	}

	
	//提交用户信息的方法
	public void addEmpdata(EmpData data) {
		// TODO Auto-generated method stub
		Integer id = data.getEmpid();
		
		//判断是否存在  
		if(checkData(id)==0) {
			mapper.insertSelective(data);
		}else {
			EmpDataExample example = new EmpDataExample();
			Criteria criteria = example.createCriteria();
			criteria.andEmpidEqualTo(data.getEmpid());
			mapper.updateByExampleSelective(data, example);
		}
	}
	
	public int checkData(Integer id) {
		EmpDataExample example = new EmpDataExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpidEqualTo(id);
		long l = mapper.countByExample(example);
		
		return (int) l;
	}
	
	

}
