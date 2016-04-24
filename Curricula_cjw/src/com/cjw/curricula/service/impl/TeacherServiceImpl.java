package com.cjw.curricula.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cjw.curricula.dao.CourseDAO;
import com.cjw.curricula.dao.CourseTeacherDAO;
import com.cjw.curricula.dao.StudentCourseDAO;
import com.cjw.curricula.dao.TeacherDAO;
import com.cjw.curricula.entity.Course;
import com.cjw.curricula.entity.Teacher;
import com.cjw.curricula.service.TeacherService;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class TeacherServiceImpl implements TeacherService {

	private CourseTeacherDAO courseTeacherDAO;	
	@Autowired
	public void setCourseTeacherDAO(CourseTeacherDAO courseTeacherDAO) {
		this.courseTeacherDAO=courseTeacherDAO;
	}
	
	private CourseDAO courseDAO;	
	@Autowired
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO=courseDAO;
	}
	
	private TeacherDAO teacherDAO;
	@Autowired
	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	@Override
	public Teacher findById(int tid) {
		
		return  teacherDAO.findById(tid);
	}

	@Override
	public List<Course> findCourses(int tid) {
		return courseTeacherDAO.findCt(tid);
	}

	@Override
	public Course findCourseById(int cid) {
		return courseDAO.findById(cid);
	}

	@Override
	public void editCourse(Course course) {
		 courseDAO.update(course);
	}

}
