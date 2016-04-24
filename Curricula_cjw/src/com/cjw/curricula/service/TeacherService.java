package com.cjw.curricula.service;

import java.util.List;

import com.cjw.curricula.entity.Course;
import com.cjw.curricula.entity.Teacher;

public interface TeacherService {
	

	Teacher findById(int tid);

	List<Course> findCourses(int tid);

	Course findCourseById(int cid);

	void editCourse(Course course);
}
