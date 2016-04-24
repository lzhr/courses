package com.cjw.curricula.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cjw.curricula.dao.TeacherDAO;
import com.cjw.curricula.entity.Teacher;

public class TeacherDAOTest extends BaseTest {
	@Autowired
	private TeacherDAO td;
	
	@Test
	public void testFindAll(){
		@SuppressWarnings("unused")
		List<Teacher> list=td.findAll();
		for(Teacher t:list){
			p(t.getTname());
		}
 	}
	
	@Test
	public void testFindById(){
		Teacher t=td.findById(3002);
		p(t.getTid(),t.getTname());
	}
	
	@Test
	public void testAdd(){
		Teacher t1=new Teacher();
		t1.setTname("测试");
		td.addTeacher(t1);
		List<Teacher> list=td.findAll();
		for(Teacher t:list){
			p(t.getTname());
		}
	}
}
