package com.emall.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emall.dao.user.RoleUserDao;
import com.emall.entity.user.RoleUser;
import com.emall.service.base.BaseService;

@Service
public class RoleUserSerivice extends BaseService<RoleUser>{

	@Autowired
	private RoleUserDao dao;
}
