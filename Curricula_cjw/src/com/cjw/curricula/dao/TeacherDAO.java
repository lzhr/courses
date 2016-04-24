package com.cjw.curricula.dao;

import java.util.List;

import com.cjw.curricula.entity.Teacher;

public interface TeacherDAO {
	List<Teacher> findAll();
	List<Teacher> findByPage(int start, int size);
	Teacher findById(int tid);
	
	void addTeacher(Teacher teacher);
	void updatTeacher(Teacher teacher);
	void deleteTeacher(Teacher teacher);
	
}
