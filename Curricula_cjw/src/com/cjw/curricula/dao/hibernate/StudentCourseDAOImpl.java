package com.cjw.curricula.dao.hibernate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cjw.curricula.dao.StudentCourseDAO;
import com.cjw.curricula.entity.Course;
import com.cjw.curricula.entity.Student;
import com.cjw.curricula.entity.StudentCourse;

@Repository
public class StudentCourseDAOImpl extends BaseDAO implements StudentCourseDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentCourse> findAll() {
		return createQuery("from StudentCourse").list();
	}

	@Override
	public List<Student> findS(int cid) {
		Map<String, Object> c=new HashMap<String, Object>();
		c.put("cid", cid);
		List<StudentCourse> list=findMany(c, StudentCourse.class);
		List<Student> students=new ArrayList<>();
		for(int i=0;i<list.size();i++){
			students.add(list.get(i).getStudent());
		}
 		return students;
	}

	@Override
	public List<Course> findC(int sid) {
		Map<String, Object> c=new HashMap<String, Object>();
		c.put("sid", sid);
		List<StudentCourse> list=findMany(c, StudentCourse.class);
		List<Course> courses=new ArrayList<>();
		for(int i=0;i<list.size();i++){
			courses.add(list.get(i).getCourse());
		}
 		return courses;
	}

	@Override
	public void add(StudentCourse sc) {
		saveOrUpdate(sc);
	}

	@Override
	public void update(StudentCourse sc) {
		 saveOrUpdate(sc);
	}

	@Override
	public void delete(StudentCourse sc) {
		Query q=createQuery("delete from StudentCourse where sid=:sid and cid=:cid");
		q.setParameter("sid", sc.getSid());
		q.setParameter("cid", sc.getCid()); 
		q.executeUpdate();
	}

	@Override
	public List<StudentCourse> findSCTByS(int sid) {
		Map<String, Object> c=new HashMap<String, Object>();
		c.put("sid", sid);
		List<StudentCourse> list=findMany(c, StudentCourse.class);
		 
 		return list;
	}

}
