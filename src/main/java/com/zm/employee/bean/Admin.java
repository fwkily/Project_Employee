package com.zm.employee.bean;

import java.io.Serializable;

public class Admin implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String adminname;

    private String adminpwd;

    private String adminpower;

    private String admindesc;

    public Integer getId() {
        return id;
    }

    public Admin() {
		super();
	}

	public Admin(Integer id, String adminpwd) {
		super();
		this.id = id;
		this.adminpwd = adminpwd;
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getAdminpwd() {
        return adminpwd;
    }

    public void setAdminpwd(String adminpwd) {
        this.adminpwd = adminpwd;
    }

    public String getAdminpower() {
        return adminpower;
    }

    public void setAdminpower(String adminpower) {
        this.adminpower = adminpower;
    }

    public String getAdmindesc() {
        return admindesc;
    }

    public void setAdmindesc(String admindesc) {
        this.admindesc = admindesc;
    }

	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminname=" + adminname + ", adminpwd=" + adminpwd + ", adminpower=" + adminpower
				+ ", admindesc=" + admindesc + "]";
	}
}