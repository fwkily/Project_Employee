package com.zm.employee.bean;

public class Gg {
    private Integer id;

    private String empname;

    private String content;

    private String date;

    private String ggDesc;

    public Integer getId() {
        return id;
    }
    
    public Gg() {
		super();
	}

	public Gg(String empname, String content, String date) {
		super();
		this.empname = empname;
		this.content = content;
		this.date = date;
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGgDesc() {
        return ggDesc;
    }

    public void setGgDesc(String ggDesc) {
        this.ggDesc = ggDesc;
    }
}