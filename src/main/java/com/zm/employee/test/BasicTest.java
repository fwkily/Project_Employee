package com.zm.employee.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class BasicTest {

	@Test
	public void test1() {
		String ids = ",45646,";
		System.out.println(ids.indexOf(","));
		System.out.println(ids.length());
		
//		//去掉最后的 ，
//		if(ids.indexOf(",")==0) {
//			ids = ids.substring(1, ids.length()-1);
//		}
		
		if(ids.charAt(ids.length()-1)==',') {
			ids = ids.substring(0, ids.length()-1);
		}
		System.out.println(ids);
	}
	
	
	@Test
	public void test2() {
		Date date = new Date();
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = d.format(date);
		System.out.println(format);
	
	}
}
