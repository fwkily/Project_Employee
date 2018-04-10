package com.zm.employee.test;


import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zm.employee.dao.DepartmentMapper;
import com.zm.employee.dao.EmployeeMapper;

/**
* @Title TestCrud
* @Description 本类主要功能是测试dao层工作
* @Company null
* @author 曾敏
* @date 2017年7月24日下午6:03:27
*/

/**
* 1、导入spring test
* 2、用@ContextConfiguration指定spring配置文件
* 3、@RunWith 指定Junit测试环境
* 4、直接autowride即可
*/
//指定bean注入的配置文件  
@SuppressWarnings("unused")
@ContextConfiguration(locations = { "classpath:applicationcontext.xml"})  
//使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner  
@RunWith(SpringJUnit4ClassRunner.class)  
public class TestCrud  extends AbstractJUnit4SpringContextTests{
	
	@Autowired
	private DepartmentMapper dept;
	
	@Autowired
	private EmployeeMapper e;
	

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void testEmp(){
//		int insertSelective2 = dept.insertSelective(new Department(null, "开发部"));
//		int insertSelective = dept.insertSelective(new Department(null, "测试部"));
		
		//  生成员工
//		e.insertSelective(new Employee(null, "zm", "1", "zm@qq.com", 1));
		
//		批量插入多个  使用可以批量执行的sqlsessesionFactory
//		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//		for (int i = 0; i < 500; i++) {
//			String uuid = UUID.randomUUID().toString().substring(0, 5);
//			mapper.insertSelective(new Employee(null, uuid + "_" + i
//					, String.valueOf(1%2), uuid + "@163.com", 2));
//		}
		
		
//		e.updateByPrimaryKey(new Employee(1, "zm1", "0", "zm1@qq.com", 2));
		
		System.out.println(e.selectByExampleAndDept(null));
	}
}















