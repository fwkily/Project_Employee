package com.zm.employee.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;
import com.zm.employee.bean.Employee;

/**
 * @Title MvcTest
 * @Description 本类主要功能是测试mvc请求
 * @Company null
 * @author 曾敏
 * @date 2017年7月25日上午10:46:59
 */


//指定bean注入的配置文件  
@ContextConfiguration(locations = { "classpath:applicationcontext.xml","file:src/main/webapp/WebContent/WEB-INF/springmvc-servlet.xml"})
//用这个注释装载springmvc的容器  @ autowride注释只能装载容器里面的bena
@WebAppConfiguration
//使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner  
@RunWith(SpringJUnit4ClassRunner.class)  
public class MvcTest {

	// 模拟mvc  获取到处理结果
	MockMvc mockMvc;

	// 传入springmvc的ioc
	@Autowired
	WebApplicationContext context;

	@Before
	public void initMokeMvc() {
		// 返回一个模拟mvc结果
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testPageHelper() throws Exception {

		//模拟发送请求 带上参数   拿到返回值
		MvcResult res = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "3")).andReturn();

		//  请求成功后 请求域中有个pageInfo  可以取出来 验证  注意：返回是你模拟HttpServletRequest
		MockHttpServletRequest request = res.getRequest();

		@SuppressWarnings("rawtypes")
		PageInfo pageInfo =  (PageInfo) request.getAttribute("pageInfo");
		System.out.println("当前页码:" + pageInfo.getPageNum());
		System.out.println("总页码：" + pageInfo.getPages());
		System.out.println("总记录数：" + pageInfo.getTotal());

		int[] nums = pageInfo.getNavigatepageNums();
		for (int i = 1; i <= nums.length; i++) {
			System.out.println(nums[i]);
		}

		// 获取员工数据
		@SuppressWarnings("unchecked")
		List<Employee> list = pageInfo.getList();
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}

	@Test
	public void testSearch() throws Exception {
		MvcResult andReturn = mockMvc.perform(MockMvcRequestBuilders.get("/findEmp").param("selectValue", "dept").param("selectMsg", "1")).andReturn();
		MockHttpServletRequest request = andReturn.getRequest();
		System.out.println(request.getAttribute("list"));


	}

	@Test
	public void testMsgAll() throws Exception {
		try {
			MvcResult andReturn = mockMvc.perform(MockMvcRequestBuilders.get("/checkMsgAll").param("ids", ",1007,1025,")).andReturn();
			MockHttpServletRequest request = andReturn.getRequest();
			System.out.println(request.getAttribute("list"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	
	@Test
	public void cxMsgAll() throws Exception {
		try {
			MvcResult andReturn = mockMvc.perform(MockMvcRequestBuilders.get("/cxCheck").param("pn", "1")
					.param("select", "id").param("msg", "1025")).andReturn();
			MockHttpServletRequest request = andReturn.getRequest();
			System.out.println(request.getAttribute("list"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//
	@Test
	public void cxEmpMsgA() throws Exception {
		try {
			MvcResult andReturn = mockMvc.perform(MockMvcRequestBuilders.get("/empData").param("empid", "1007")).andReturn();
			MockHttpServletRequest request = andReturn.getRequest();
			System.out.println(request.getAttribute("list"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//
	@Test
	public void testCount() throws Exception {
		try {
			MvcResult andReturn = mockMvc.perform(MockMvcRequestBuilders.get("/ic")).andReturn();
			MockHttpServletRequest request = andReturn.getRequest();
			System.out.println(request.getAttribute("list"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testlogin() throws Exception {
		try {
			MvcResult andReturn = mockMvc.perform(MockMvcRequestBuilders.post("/login").param("name", "zm").param("pwd", "123")).andReturn();
			MockHttpServletRequest request = andReturn.getRequest();
			System.out.println(request.getSession().getAttribute("admin"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testTask() throws Exception {
		try {
			MvcResult andReturn = mockMvc.perform(MockMvcRequestBuilders.post("/taskByid/1")).andReturn();
			MockHttpServletRequest request = andReturn.getRequest();
			System.out.println(request.getAttribute("task"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
