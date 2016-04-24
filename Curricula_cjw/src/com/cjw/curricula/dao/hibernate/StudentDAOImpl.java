package com.cjw.curricula.dao.hibernate;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cjw.curricula.dao.StudentDAO;
import com.cjw.curricula.entity.Student;

@Repository
public class StudentDAOImpl extends BaseDAO implements StudentDAO {

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> studentList() {
		return createQuery("from Student").list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> studentListBypage(int start, int size) {
		return createQuery("from Student").
				setFirstResult(start).setMaxResults(size).list();
		
	}
	
	@Override
	public Student findById(int sid) {
		return load(sid,Student.class);
	}
	
	@Override
	public Student findOne(Map<String, Object> s) {
		return findOne(s, Student.class);
	}

	@Override
	public void addSudent(Student student) {
		 saveOrUpdate(student);
	}

	@Override
	public void updateSudent(Student student) {
		update(student);
	}

	@Override
	public void deleteSudent(Student student) {
		 //createQuery("delete from Student where sid="+student.getSid());
	}

	@Override
	public void deleteSudentById(int sid) {
		createQuery("delete from Student where sid="+sid).executeUpdate();
	}

	@Override
	public void updateSudentName(int sid, String sname) {
		createQuery("update Student s set s.sname='"+sname+"' where s.sid="+sid).executeUpdate();
	}

}
