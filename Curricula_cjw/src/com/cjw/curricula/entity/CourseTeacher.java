package com.cjw.curricula.entity;

import javax.persistence.*;

@Entity
@Table(name="c_t")
public class CourseTeacher {
	private int ctid;
	private int cid;
	private int tid;
	private Course course;
	private Teacher teacher;
	
	public CourseTeacher(){}
			
	public CourseTeacher(int cid, int tid) {
		this.cid = cid;
		this.tid = tid;
	}
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO) 
	public int getCtid() {
		return ctid;
	}
	public void setCtid(int ctid) {
		this.ctid = ctid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "cid",insertable = false, updatable = false)
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "tid",insertable = false, updatable = false)
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
}
