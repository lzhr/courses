package com.cjw.curricula.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cjw.curricula.dao.TeacherDAO;
import com.cjw.curricula.entity.Teacher;

@Repository
public class TeacherDAOImpl extends BaseDAO implements TeacherDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> findAll() {
		return createQuery("from Teacher").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> findByPage(int start, int size) {
		return createQuery("from Teacher").
				setFirstResult(start).setMaxResults(size).list();
	}

	@Override
	public Teacher findById(int tid) {
		return load(tid, Teacher.class);
	}

	@Override
	public void addTeacher(Teacher teacher) {
		saveOrUpdate(teacher);
	}

	@Override
	public void updatTeacher(Teacher teacher) {
		saveOrUpdate(teacher);
	}

	@Override
	public void deleteTeacher(Teacher teacher) {
		createQuery("delete from Teacher where tid="+teacher.getTid());
	}

}
