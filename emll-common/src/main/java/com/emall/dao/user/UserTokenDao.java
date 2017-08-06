package com.emall.dao.user;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emall.dao.base.BaseDao;
import com.emall.dao.base.QueryHandler;
import com.emall.entity.user.UserToken;

@Repository
public class UserTokenDao extends BaseDao<UserToken>{

	public UserToken getByUserId(Integer id) {
		// TODO Auto-generated method stub
		QueryHandler query=getQueryHandler("from UserToken bean");
		if(notEmpty(id))
		{
			query.condition("bean.userId=:id");
			query.setParamater("id", id);
		}
		List<UserToken> list=getPage(query,1,3);
		if(list.size()==0) return null;
		else return list.get(0);
	}

	public void delete(int i) {
		// TODO Auto-generated method stub
		UserToken token=getEntity(i);
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		session.delete(token);
		ts.commit();
	}

}
