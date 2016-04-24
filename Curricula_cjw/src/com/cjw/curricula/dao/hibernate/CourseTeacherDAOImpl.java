package com.cjw.curricula.dao.hibernate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cjw.curricula.dao.CourseTeacherDAO;
import com.cjw.curricula.entity.Course;
import com.cjw.curricula.entity.CourseTeacher;

@Repository
public class CourseTeacherDAOImpl extends BaseDAO implements CourseTeacherDAO {
	
	@Override
	public List<Course> findCt(int tid) {
		Map<String, Object> c=new HashMap<String, Object>();
		c.put("tid", tid);
		List<CourseTeacher> list=findMany(c, CourseTeacher.class);
		List<Course> courses=new ArrayList<>();
		for(int i=0;i<list.size();i++){
			courses.add(list.get(i).getCourse());
		}
 		return courses;
	}

	@Override
	public void update(int cid, int tid) {
		 createQuery("delete from CourseTeacher where cid="+cid).executeUpdate();
		 CourseTeacher ct=new CourseTeacher(cid, tid);
		 saveOrUpdate(ct);
	}

	@Override
	public void addCT(int cid, int tid) {
		CourseTeacher ct=new CourseTeacher(cid,tid);
		saveOrUpdate(ct);
	}
}
