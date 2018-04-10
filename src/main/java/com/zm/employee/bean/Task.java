package com.zm.employee.bean;

public class Task {
    private Integer id;

    private Integer tclass;

    private String tnmae;

    private String tcontent;

    private String tdate;

    private String target;

    private String tadmin;

    private String tdesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTclass() {
        return tclass;
    }

    public void setTclass(Integer tclass) {
        this.tclass = tclass;
    }

    public String getTnmae() {
        return tnmae;
    }

    public void setTnmae(String tnmae) {
        this.tnmae = tnmae;
    }

    public String getTcontent() {
        return tcontent;
    }

    public void setTcontent(String tcontent) {
        this.tcontent = tcontent;
    }

    public String getTdate() {
        return tdate;
    }

    public void setTdate(String tdate) {
        this.tdate = tdate;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTadmin() {
        return tadmin;
    }

    public void setTadmin(String tadmin) {
        this.tadmin = tadmin;
    }

    public String getTdesc() {
        return tdesc;
    }

    public void setTdesc(String tdesc) {
        this.tdesc = tdesc;
    }

	@Override
	public String toString() {
		return "Task [id=" + id + ", tclass=" + tclass + ", tnmae=" + tnmae + ", tcontent=" + tcontent + ", tdate="
				+ tdate + ", target=" + target + ", tadmin=" + tadmin + ", tdesc=" + tdesc + "]";
	}
}