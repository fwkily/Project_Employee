package com.zm.employee.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
* @Title Check
* @Description 本类主要功能是考勤表
* @Company null
* @author 曾敏
* @date 2017年8月5日下午2:18:41
*/
@Entity
public class Check {
    @Id
	@GeneratedValue
	private Integer id;

    private String date;

    private String epmid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEpmid() {
        return epmid;
    }

    public void setEpmid(String epmid) {
        this.epmid = epmid;
    }

	@Override
	public String toString() {
		return "Check [id=" + id + ", date=" + date + ", epmid=" + epmid + "]";
	}
}