package com.emall.dao.base;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.emall.base.Base;

public class QueryHandler extends Base{

	private StringBuilder sql;
	private Map<String,Object> map;
	private boolean whereFlag=true;
	private boolean orderFlag=true;
	private Integer pageIndex;
	private Integer pageSize;
	
	public QueryHandler(String sql)
	{
		this.sql=new StringBuilder(" ");
		this.sql.append(sql);
	}
	
	public QueryHandler() {
		this.sql=new StringBuilder();
	}
	
	public void condition(String condition)
	{
		if(whereFlag)
		{
			whereFlag=false;
			sql.append(" where ");
		}
		else
			sql.append(" and ");
		sql.append(condition);
	}
	
	public void order(String order)
	{
		if(orderFlag)
		{
			orderFlag=false;
			sql.append(" order ");
		}
		else 
			sql.append(" , ");
		sql.append(order);
	}
	
	public void setParamater(String key,Object value)
	{
		if(empty(map))
			map=new HashMap<String,Object>();
		map.put(key, value);
	}
	
	public Query getQuery(Session session)
	{
		Query query=session.createQuery(getSql());
		if(notEmpty(map))
		{
			for(String key:map.keySet())
				query.setParameter(key,map.get(key));
		}
		if(notEmpty(pageIndex))
			query.setFirstResult((pageIndex-1)*pageSize);
		if(notEmpty(pageSize))
			query.setMaxResults(pageSize*pageIndex);
		return query;
	}

	private String getSql() {
		// TODO Auto-generated method stub
		return sql.toString();
	}

	public void setPageIndex(Integer pageIndex) {
		// TODO Auto-generated method stub
		this.pageIndex=pageIndex;
	}

	public void setPageSize(Integer pageSize) {
		// TODO Auto-generated method stub
		this.pageSize=pageSize;
	}
}
