package com.cjw.curricula.dao;

import java.util.List;

import com.cjw.curricula.entity.Course;
import com.cjw.curricula.entity.Student;
import com.cjw.curricula.entity.StudentCourse;

public interface StudentCourseDAO {
	List<StudentCourse> findAll();
	
	List<Student> findS(int cid);
	List<Course> findC(int sid);
	
	void add(StudentCourse sc);
	void update(StudentCourse sc);
	void delete(StudentCourse sc);

	List<StudentCourse> findSCTByS(int sid);
}
