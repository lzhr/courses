package com.cjw.curricula.dao;

import java.util.List;

import com.cjw.curricula.entity.Course;

public interface CourseDAO {
	List<Course> findAll();
	List<Course> findByPage(int start, int size);
	Course findById(int cid);
	
	void add(Course course);
	void update(Course course);
	void delete(Course course);
	Course findByName(String cname);
	List<Course> findAllselectable();
	
}
