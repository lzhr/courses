package com.cjw.curricula.service;

import java.util.List;

import com.cjw.curricula.entity.Course;
import com.cjw.curricula.entity.Student;
import com.cjw.curricula.entity.StudentCourse;

public interface StudentService {
	Student findInfo(int sid);
	void editStudent(Student student);
	
	List<Course> findCourse(int sid);
	List<Course> toselect(int sid);
	List<Course> findUnslectedCourse(int sid);
	
	void selectCourse(int sid,int cid, int tid);
	void dropCourse(int sid,int cid);
	void selectCourse(int sid, int cid);
	List<StudentCourse> findStudying(int sid);
	
}
