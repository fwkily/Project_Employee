package com.zm.employee.bean;

public class Index {

	private long empCount;
	private long deptCount;
	private long adminCount;
	private long taskCount;
	private String desc;//预留字段
	public long getEmpCount() {
		return empCount;
	}
	public void setEmpCount(long empCount) {
		this.empCount = empCount;
	}
	public long getDeptCount() {
		return deptCount;
	}
	public void setDeptCount(long deptCount) {
		this.deptCount = deptCount;
	}
	public long getAdminCount() {
		return adminCount;
	}
	public void setAdminCount(long adminCount) {
		this.adminCount = adminCount;
	}
	public long getTaskCount() {
		return taskCount;
	}
	public void setTaskCount(long taskCount) {
		this.taskCount = taskCount;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Index [empCount=" + empCount + ", deptCount=" + deptCount + ", adminCount=" + adminCount
				+ ", taskCount=" + taskCount + ", desc=" + desc + "]";
	}
	
	
	
}
