package com.emall.dao.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.emall.dao.base.BaseDao;
import com.emall.dao.base.QueryHandler;
import com.emall.entity.user.User;

@Repository
public class UserDao extends BaseDao<User> {

	public List<User> getPage(Integer pageIndex, Integer pageSize) {
		QueryHandler queryHandler = getQueryHandler("from User");
		return getPage(queryHandler, pageIndex, pageSize);
	}

	public User login(String username, String password, String activateCode) {
		// TODO Auto-generated method stub
		QueryHandler queryHandler = getQueryHandler("from User user");
		if (notEmpty(username)) {
			queryHandler
					.condition("( user.userName=:username or user.account=:username or user.email=:username )");
			queryHandler.setParamater("username", username);
		}
		if (notEmpty(password)) {
			queryHandler.condition("user.password=:password");
			queryHandler.setParamater("password", password);
		}
		if (notEmpty(activateCode)) {
			queryHandler.condition("user.activateCode=:activateCode");
			queryHandler.setParamater("activateCode", activateCode);
		}
		queryHandler.condition("user.status=1");
		List<User> list = getPage(queryHandler, 1, 3);
		if (list.size() == 0)
			return null;
		else
			return list.get(0);
	}

	public User exsit(String username, String activateCode) {
		// TODO Auto-generated method stub
		QueryHandler queryHandler = getQueryHandler("from User user");
		if (notEmpty(username)) {
			queryHandler
					.condition("( user.userName=:username or user.account=:username or user.email=:username )");
			queryHandler.setParamater("username", username);
		}
		if (notEmpty(activateCode)) {
			queryHandler.condition("user.activateCode=:activateCode");
			queryHandler.setParamater("activateCode", activateCode);
		}
		List<User> list = getPage(queryHandler, 1, 3);
		if (list.size() == 0)
			return null;
		else
			return list.get(0);
	}

}
