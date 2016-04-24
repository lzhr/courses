package com.cjw.curricula.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cjw.curricula.dao.CourseDAO;
import com.cjw.curricula.dao.CourseTeacherDAO;
import com.cjw.curricula.dao.StudentCourseDAO;
import com.cjw.curricula.dao.StudentDAO;
import com.cjw.curricula.dao.TeacherDAO;
import com.cjw.curricula.entity.Course;
import com.cjw.curricula.entity.CourseTeacher;
import com.cjw.curricula.entity.Student;
import com.cjw.curricula.entity.Teacher;
import com.cjw.curricula.service.AdminService;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class AdminServiceImpl  implements AdminService {
	
	private StudentDAO studentDAO;	
	@Autowired
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	private CourseDAO courseDAO;	
	@Autowired
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO=courseDAO;
	}
	
	private StudentCourseDAO studentCourseDAO;	
	@Autowired
	public void setStudentCourseDAO(StudentCourseDAO studentCourseDAO) {
		this.studentCourseDAO=studentCourseDAO;
	}
	
	private CourseTeacherDAO courseTeacherDAO;	
	@Autowired
	public void setCourseTeacherDAO(CourseTeacherDAO courseTeacherDAO) {
		this.courseTeacherDAO=courseTeacherDAO;
	}
	
	private TeacherDAO teacherDAO;
	@Autowired
	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}
	
	@Override
	public List<Student> studentList() {
		return studentDAO.studentList();
	}

	@Override
	public void addStudent(Student student) {
		studentDAO.addSudent(student);
	}

	@Override
	public void editStudent(Student student) {
		studentDAO.updateSudent(student);
	}

	@Override
	public void deleteStudent(int sid) {
		Student s=studentDAO.findById(sid);
		studentDAO.deleteSudent(s);
	}

	@Override
	public void deleteStudent(Student student) {
		 studentDAO.deleteSudent(student);
	}

	@Override
	public void deleteTeacher(Teacher teacher) {
		teacherDAO.deleteTeacher(teacher);
	}

	@Override
	public void deleteStudentById(int sid) {
		 studentDAO.deleteSudentById(sid);
	}

	@Override
	public void updateStudent(Student s) {
		 studentDAO.updateSudent(s);
	}

	@Override
	public void updateStudentName(int sid, String sname) {
		studentDAO.updateSudentName(sid,sname);
	}

	@Override
	public List<Course> findCourses() {
		return courseDAO.findAll();
	}

	@Override
	public Course findOne(int cid) {
		return courseDAO.findById(cid);
	}

	@Override
	public void editCourse(Course course,int[] tid) {
		courseDAO.update(course);
		for(int i=0;i<tid.length;i++){
			courseTeacherDAO.update(course.getCid(),tid[i]);
		}
	}

	@Override
	public void addCourse(String cname, String c_time, int tid) {
		Course course=new Course(cname,c_time);
		courseDAO.add(course);
		int cid=courseDAO.findByName(cname).getCid();
		courseTeacherDAO.addCT(cid,tid);
	}

	@Override
	public List<Teacher> findTeachers() {
		return  teacherDAO.findAll();
	}
}
