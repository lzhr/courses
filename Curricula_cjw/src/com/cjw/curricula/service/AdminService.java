package com.cjw.curricula.service;

import java.util.List;

import com.cjw.curricula.entity.Course;
import com.cjw.curricula.entity.Student;
import com.cjw.curricula.entity.Teacher;

public interface AdminService {
	List<Student> studentList();
	void addStudent(Student student);
	void editStudent(Student student);
	void deleteStudent(int sid);
	void deleteStudent(Student student);
	
	void deleteTeacher(Teacher teacher);
	void deleteStudentById(int sid);
	void updateStudent(Student s);
	void updateStudentName(int sid, String sname);
	List<Course> findCourses();
	Course findOne(int cid);
	void editCourse(Course course, int[] tid);
	void addCourse(String cname, String c_time, int tid);
	List<Teacher> findTeachers();
}	
