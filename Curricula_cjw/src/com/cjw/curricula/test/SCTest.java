package com.cjw.curricula.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cjw.curricula.dao.StudentCourseDAO;
import com.cjw.curricula.entity.Course;
import com.cjw.curricula.entity.Student;
import com.cjw.curricula.entity.StudentCourse;

public class SCTest extends BaseTest {
	@Autowired
	private StudentCourseDAO scd;
	
	@Test
	public void testFindMany(){
		List<Student> lists=scd.findS(2005);
		for(Student s:lists){
			p(s.getSname());
		}
		
		List<Course> listc=scd.findC(1002);
		for(Course c:listc){
			p(c.getCname());
		}
	}
	
	@Test
	public void testUpdate(){
		StudentCourse sc=new StudentCourse(1005,2002);
		 
		scd.add(sc);
		
	}
}
