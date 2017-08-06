package com.emall.service.base;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.emall.base.Base;
import com.emall.dao.base.BaseDao;


@Transactional
public abstract class BaseService<E> extends Base{
	
	@Autowired
	protected BaseDao<E> dao;
	
	public E getEntity(Integer id)
	{
		return dao.getEntity(id);
	}
	
	public void deleteEntity(Integer id)
	{
		dao.deleteEntity(id);
	}
	
	public void updateEntity(E entity)
	{
		dao.updateEntity(entity);
	}
	
	public Serializable saveEntity(E entity)
	{
		return dao.saveEntity(entity);
	}

}
