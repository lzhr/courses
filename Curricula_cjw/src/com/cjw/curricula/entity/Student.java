package com.cjw.curricula.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {
	private int sid;
	private String sname;
	private List<StudentCourse> sc;
	
	public Student() {}

	public Student(int sid, String sname) {
		this.setSid(sid);
		this.setSname(sname);
	}
	
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO) 
	public int getSid() {
		return sid;
	}

	void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
	
	@OneToMany(mappedBy="student",cascade=CascadeType.ALL)
	public List<StudentCourse> getSc() {
		return sc;
	}

	void setSc(List<StudentCourse> sc) {
		this.sc = sc;
	}
	
}