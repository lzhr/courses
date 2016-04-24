package com.cjw.curricula.dao.hibernate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cjw.curricula.dao.CourseDAO;
import com.cjw.curricula.entity.Course;
import com.cjw.curricula.entity.CourseTeacher;
import com.cjw.curricula.entity.StudentCourse;
import com.sun.scenario.effect.Merge;

@Repository
public class CourseDAOImpl extends BaseDAO implements CourseDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> findAll() { 
		return createQuery("from Course").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> findByPage(int start, int size) {
		return createQuery("from Course")
				.setFirstResult(start).setMaxResults(size).list();
	}

	@Override
	public Course findById(int cid) {
		return load(cid, Course.class);
	}

	@Override
	public void add(Course course) {
		saveOrUpdate(course);
	}

	@Override
	public void update(Course course) {
		createQuery("update Course set cname='"+course.getCname()
				+ "',credit="+course.getCredit()
				+ ",c_details='"+course.getC_details()
				+ "',c_time='"+course.getC_time()
				+ "' where cid="+course.getCid()).executeUpdate();
	}

	@Override
	public void delete(Course course) {
		 
	}

	@Override
	public Course findByName(String cname) {
		Map<String, Object> c=new HashMap<String, Object>();
		c.put("cname", cname);
		return findOne(c, Course.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> findAllselectable() {
		 return createQuery("from Course where c_details is not null or credit is not null").list();
	}

	
	
}
