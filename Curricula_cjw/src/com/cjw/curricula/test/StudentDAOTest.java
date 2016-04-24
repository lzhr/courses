package com.cjw.curricula.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.annotation.Resource;


import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.cjw.curricula.dao.StudentDAO;

import com.cjw.curricula.entity.Student;


public class StudentDAOTest  extends BaseTest  {
	@Autowired
	private StudentDAO studentDAO;	
	
	@Test
	public void testFindOne(){
		Map<String, Object> criterions=new HashMap<String, Object>();
		criterions.put("sname", "学生一");
		Student s=studentDAO.findOne(criterions);
		p("findone",s.getSid(),s.getSname());
	}
	
	@Test
	public void testUpdate(){
		Student s=studentDAO.findById(1007);
		p(s.getSid());
		s.setSname("测试名2");
		studentDAO.updateSudent(s);
		p(s.getSname());
	}
	
	@Test
	public void testFindById(){
		Student s=studentDAO.findById(1001);
		p(s.getSname());
	}
	
	@Test
	public void testStudentList() {
		List<Student> list = studentDAO.studentList();
		for(Student s:list){
			p(s.getSname());
		}
	}
	
	@Test 
	public void testDelete(){
		 
		studentDAO.deleteSudentById(1006);
	}

}