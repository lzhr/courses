package com.cjw.curricula.entity;

import javax.persistence.*;

@Entity
@Table(name="s_c_t")
public class StudentCourse {
	private int scid;
	private int sid;
	private int cid;
	private int tid;
	
	private Student student;
	private Course course;
	private Teacher teacher;
	
	public StudentCourse() {}

	public StudentCourse(int sid, int cid, int tid) {
		this.sid = sid;
		this.cid = cid;
		this.tid = tid;
	}

	public StudentCourse(int scid, Student student, Course course) {
		this.scid = scid;
		this.student = student;
		this.course = course;
	}

	public StudentCourse(int sid, int cid) {
		this.sid = sid;
		this.cid = cid;
	}

	@Id
	@Column(name="sctid")
	@GeneratedValue(strategy =GenerationType.AUTO) 
	public int getScid() {
		return scid;
	}

	void setScid(int scid) {
		this.scid = scid;
	}

	

	public int getCid() {
		return cid;
	}

	void setCid(int cid) {
		this.cid = cid;
	}

	public int getSid() {
		return sid;
	}

	void setSid(int sid) {
		this.sid = sid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "sid", insertable = false, updatable = false)
	public Student getStudent() {
		return student;
	}

	void setStudent(Student student) {
		this.student = student;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "cid",insertable = false, updatable = false)
	public Course getCourse() {
		return course;
	}
	void setCourse(Course course) {
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
