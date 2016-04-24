package com.cjw.curricula.dao.hibernate;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDAO {
private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
	Query createQuery(String hql) {
		return sessionFactory.getCurrentSession().createQuery(hql);
	}
	
	@SuppressWarnings("unchecked")
	<T> T load(Serializable id, Class<T> clazz) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}
	
	@SuppressWarnings("unchecked")
	<T> T findOne(Map<String, Object> criterions, Class<T> clazz) {
		Criteria criteria = createCriteria(criterions, clazz);
		return (T) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	<T> List<T> findMany(Map<String, Object> criterions, Class<T> clazz) {
		Criteria criteria = createCriteria(criterions, clazz);
		return criteria.list();
	}

	Criteria createCriteria(Map<String, Object> criterions, Class<?> clazz) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);
		
		for (Map.Entry<String, Object> criterionEntry : criterions.entrySet()) {
			criteria.add(Restrictions.eq(criterionEntry.getKey(), criterionEntry.getValue()));
		}
		return criteria;
	}
	
	void update(Object obj) {
		sessionFactory.getCurrentSession().update(obj);
	}
	
	void merge(Object obj){
		sessionFactory.getCurrentSession().merge(obj);
	}
	
	void saveOrUpdate(Object obj) {
		sessionFactory.getCurrentSession().saveOrUpdate(obj);
	}
	 
}
