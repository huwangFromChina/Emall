package com.emall.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emall.dao.user.RoleDao;
import com.emall.entity.user.Role;
import com.emall.service.base.BaseService;

@Service
public class RoleService extends BaseService<Role>{
	
	@Autowired
	private RoleDao dao;

}
