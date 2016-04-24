package com.cjw.curricula.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cjw.curricula.dao.CourseDAO;
import com.cjw.curricula.dao.StudentCourseDAO;
import com.cjw.curricula.dao.StudentDAO;
import com.cjw.curricula.entity.*;
import com.cjw.curricula.service.*;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class StudentServiceImpl implements StudentService {

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
	
	@Override
	public Student findInfo(int sid) {
		return studentDAO.findById(sid);
	}
	
	@Override
	public void editStudent(Student student) {
		studentDAO.updateSudent(student);
	}

	@Override
	public List<Course> findCourse(int sid) {
		return studentCourseDAO.findC(sid);
	}

	@Override
	public void selectCourse(int sid, int cid) {
		StudentCourse sc=new StudentCourse(sid,cid);
		studentCourseDAO.add(sc);
	}

	@Override
	public void dropCourse(int sid, int cid) {	
		StudentCourse sc=new StudentCourse(sid,cid);
		studentCourseDAO.delete(sc);
	}

	@Override
	public List<Course> toselect(int sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findUnslectedCourse(int sid) {
		List<Course> all=courseDAO.findAllselectable();
		List<Course> s=studentCourseDAO.findC(sid);
		List<Course> us=new ArrayList<Course>();
		
		for (Course c : all) {
			if (!s.contains(c)) {
				us.add(c);
			}
		}
		return us;
	}

	@Override
	public void selectCourse(int sid, int cid, int tid) {
		StudentCourse sc=new StudentCourse(sid,cid,tid);
		studentCourseDAO.add(sc);
	}

	@Override
	public List<StudentCourse> findStudying(int sid) {
		 return studentCourseDAO.findSCTByS(sid);
	}
	
}
