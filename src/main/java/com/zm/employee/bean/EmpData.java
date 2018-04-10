package com.zm.employee.bean;

public class EmpData {
    private Integer id;

    private Integer empid;

    private String name;

    private String sex;

    private String birth;

    private Integer high;

    private String area;

    private String ethnic;

    private String school;

    private String studybg;

    private String major;

    private String ps;

    private String qq;

    private String tel;

    private String mail;

    private String myability;

    private String myspeciality;

    private String myteach;

    private String myidea;

    private String img;

    private String empdesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStudybg() {
        return studybg;
    }

    public void setStudybg(String studybg) {
        this.studybg = studybg;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMyability() {
        return myability;
    }

    public void setMyability(String myability) {
        this.myability = myability;
    }

    public String getMyspeciality() {
        return myspeciality;
    }

    public void setMyspeciality(String myspeciality) {
        this.myspeciality = myspeciality;
    }

    public String getMyteach() {
        return myteach;
    }

    public void setMyteach(String myteach) {
        this.myteach = myteach;
    }

    public String getMyidea() {
        return myidea;
    }

    public void setMyidea(String myidea) {
        this.myidea = myidea;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getEmpdesc() {
        return empdesc;
    }

    public void setEmpdesc(String empdesc) {
        this.empdesc = empdesc;
    }

	@Override
	public String toString() {
		return "EmpData [id=" + id + ", empid=" + empid + ", name=" + name + ", sex=" + sex + ", birth=" + birth
				+ ", high=" + high + ", area=" + area + ", ethnic=" + ethnic + ", school=" + school + ", studybg="
				+ studybg + ", major=" + major + ", ps=" + ps + ", qq=" + qq + ", tel=" + tel + ", mail=" + mail
				+ ", myability=" + myability + ", myspeciality=" + myspeciality + ", myteach=" + myteach + ", myidea="
				+ myidea + ", img=" + img + ", empdesc=" + empdesc + "]";
	}
}