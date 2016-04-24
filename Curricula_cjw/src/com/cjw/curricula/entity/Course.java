package com.cjw.curricula.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="course")
public class Course {
	private int cid;
	private String cname;
	private	Integer credit;
	private String c_time;
	private String c_details;
	private List<StudentCourse> sc;
	private List<CourseTeacher> ct;
	
	public Course() {}

	public Course(String cname, String c_time) {
		this.cname = cname;
		this.c_time=c_time;
	}

	public Course(int cid,String cname, Integer credit, String c_time, String c_details) {
		this.cid=cid;
		this.cname = cname;
		this.credit = credit;
		this.c_time = c_time;
		this.c_details = c_details;
	}

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO) 
	public int getCid() {
		return cid;
	}

	void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getCredit() {
		return credit;
	}

	void setCredit(Integer credit) {
		this.credit = credit;
	}

	public String getC_time() {
		return c_time;
	}

	void setC_time(String c_time) {
		this.c_time = c_time;
	}

	public String getC_details() {
		return c_details;
	}

	void setC_details(String c_details) {
		this.c_details = c_details;
	}
	
	@OneToMany(mappedBy="course",cascade=CascadeType.ALL)
	public List<StudentCourse> getSc() {
		return sc;
	}

	void setSc(List<StudentCourse> sc) {
		this.sc = sc;
	}

	@OneToMany(mappedBy="course",cascade=CascadeType.ALL)
	public List<CourseTeacher> getCt() {
		return ct;
	}

	public void setCt(List<CourseTeacher> ct) {
		this.ct = ct;
	}
	
}
