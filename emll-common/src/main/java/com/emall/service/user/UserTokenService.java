package com.emall.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emall.dao.user.UserTokenDao;
import com.emall.entity.user.UserToken;
import com.emall.service.base.BaseService;


@Service
@Transactional
public class UserTokenService extends BaseService<UserToken>{
	
	@Autowired
	private UserTokenDao dao;

	public UserToken getByUserId(int id) {
		// TODO Auto-generated method stub
		return dao.getByUserId(id);
	}

	public void delete(int i) {
		// TODO Auto-generated method stub
		dao.delete(i);
	}

}
