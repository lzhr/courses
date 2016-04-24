package com.cjw.curricula.dao;

import java.util.List;
import java.util.Map;

import com.cjw.curricula.entity.Student;

public interface StudentDAO {
	
	Student findById(int sid);
	List<Student> studentList();
	
	List<Student> studentListBypage(int start, int size);
	Student findOne(Map<String, Object> s);
	
	void addSudent(Student student);
	void updateSudent(Student student);
	void deleteSudent(Student student);
	void deleteSudentById(int sid);
	void updateSudentName(int sid, String sname);
}
