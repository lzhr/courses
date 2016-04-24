package com.cjw.curricula.dao;

import java.util.List;

import com.cjw.curricula.entity.Course;

public interface CourseTeacherDAO {
	List<Course> findCt(int tid);

	void update(int cid, int tid);

	void addCT(int cid, int tid);
}
