package com.emall.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emall.dao.user.ThumbDao;
import com.emall.entity.user.Thumb;
import com.emall.service.base.BaseService;

@Service
public class ThumbService extends BaseService<Thumb>{
	
	@Autowired
	private ThumbDao dao;

}
