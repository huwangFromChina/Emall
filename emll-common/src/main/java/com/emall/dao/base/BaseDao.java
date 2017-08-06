package com.emall.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.emall.base.Base;

public abstract class BaseDao<E> extends Base {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public static QueryHandler getQueryHandler(String sql) {
		return new QueryHandler(sql);
	}

	public static String likes(String word) {
		return "%" + word + "%";
	}

	public Serializable saveEntity(E entity) {
		return getSession().save(entity);
	}

	@SuppressWarnings("unchecked")
	public E getEntity(Integer id) {
		return notEmpty(id) ? (E) getSession().get(getClassName(), id) : null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Class<E> getClassName() {
		// TODO Auto-generated method stub
		Class clazz = (Class) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		return clazz;
	}

	public void deleteEntity(Integer id) {
		E entity = getEntity(id);
		if (notEmpty(entity))
			getSession().delete(entity);
	}

	public void updateEntity(E entity) {
		getSession().update(entity);
	}

	@SuppressWarnings("unchecked")
	public List<E> getPage(QueryHandler queryHandler) {
		return queryHandler.getQuery(getSession()).list();
	}

	@SuppressWarnings("unchecked")
	public List<E> getPage(QueryHandler queryHandler, Integer pageIndex,
			Integer pageSize) {
		queryHandler.setPageIndex(pageIndex);
		queryHandler.setPageSize(pageSize);
		return queryHandler.getQuery(getSession()).list();
	}

	public int count(QueryHandler queryHandler) {
		return ((Number) queryHandler.getQuery(getSession()).iterate().next())
				.intValue();
	}

}
