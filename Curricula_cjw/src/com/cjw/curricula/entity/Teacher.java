package com.cjw.curricula.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class Teacher {
	private int tid;
	private String tname;
	private List<CourseTeacher> ct;
	private List<StudentCourse> sct;
	
	public Teacher() {}

	public Teacher(int tid, String tname) {
		this.setTid(tid);
		this.setTname(tname);
	}

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO) 
	public int getTid() {
		return tid;
	}

	void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}
	
	@OneToMany(mappedBy="teacher",cascade=CascadeType.ALL)
	public List<CourseTeacher> getCt() {
		return ct;
	}

	public void setCt(List<CourseTeacher> ct) {
		this.ct = ct;
	}
	
	@OneToMany(mappedBy="teacher",cascade=CascadeType.ALL)
	public List<StudentCourse> getSct() {
		return sct;
	}

	public void setSct(List<StudentCourse> sct) {
		this.sct = sct;
	}
	
}
