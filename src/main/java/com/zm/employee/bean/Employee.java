package com.zm.employee.bean;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

public class Employee implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer empId;
    @Pattern(regexp = "(^[a-z0-9_-]{3,16})|(^[\u2E80-\u9FFF]{2,5})",message="用户名必须是3~16位英文或者是2~5位汉字组合?")
    private String empName;

    private String gender;
    //@Email
    @Pattern(regexp = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$",message="邮箱格式有误")
    private String email;

    private String pwd;

    private Integer dId;
    //希望查询员工的同时部门信息也是查询好的
    private Department dept;
    
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", gender=" + gender + ", email=" + email
				+ ", pwd=" + pwd + ", dId=" + dId + ", department=" + dept + "]";
	}
}