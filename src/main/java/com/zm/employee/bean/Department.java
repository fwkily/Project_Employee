package com.zm.employee.bean;

import java.io.Serializable;

public class Department implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer deptId;

    private String deptName;
    
    private String deptDesc;
    public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(Integer deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}

	public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

	public String getDeptDesc() {
		return deptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
}