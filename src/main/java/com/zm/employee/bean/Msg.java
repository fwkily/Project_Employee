package com.zm.employee.bean;

import java.util.HashMap;
import java.util.Map;
/**
* @Title Msg
* @Description 本类主要功能是通用的返回类-方法返回类型都是Msg  可以链式操作
* @Company null
* @author 曾敏
* @date 2017年7月27日下午8:09:21
*/
public class Msg {
	
	private int code;
	private String msg;
	private Map<String,Object> map = new HashMap<>();
	
	public static Msg success() {
		Msg resuest = new Msg();
		resuest.setCode(200);
		resuest.setMsg("处理成功");
		return resuest;
	}
	
	public static Msg error() {
		Msg resuest = new Msg();
		resuest.setCode(500);
		resuest.setMsg("处理失败");
		return resuest;
	}
	//  把要返回的信息放在map中
	public Msg add(String k, Object v) {
		// TODO Auto-generated method stub
		this.getMap().put(k, v);
		return this;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}


	
	
}
