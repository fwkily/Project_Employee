package com.zm.employee.bean;

public class Words {
    private Integer id;

    private String empname;

    private String content;

    private String date;

    private String wordsdesc;
    
    public Words() {
		super();
	}

	public Words(String empname, String content, String date) {
		super();
		this.empname = empname;
		this.content = content;
		this.date = date;
	}

	public Integer getId() {
        return id;
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

    public String getWordsdesc() {
        return wordsdesc;
    }

    public void setWordsdesc(String wordsdesc) {
        this.wordsdesc = wordsdesc;
    }
}