package com.emall.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emall.dao.base.BaseDao;
import com.emall.dao.user.UserDao;
import com.emall.entity.user.User;
import com.emall.service.base.BaseService;

@Service
@Transactional
public class UserService extends BaseService<User>{
	
	@Autowired
	private UserDao dao;


	public List<User> getPage(Integer pageIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		return dao.getPage(pageIndex,pageSize);
	}


	public User login(String username, String password, String activateCode) {
		// TODO Auto-generated method stub
		return dao.login(username,password,activateCode);
	}


	public boolean ExsitUser(String username,  String activateCode) {
		// TODO Auto-generated method stub
		return empty(dao.exsit(username,activateCode))?false:true;
	}


	public User getUserByActivateCode(String activateCode) {
		// TODO Auto-generated method stub
		return dao.exsit(null,activateCode);
	}

}
