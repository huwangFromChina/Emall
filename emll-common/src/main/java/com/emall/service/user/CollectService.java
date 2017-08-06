package com.emall.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emall.dao.user.CollectDao;
import com.emall.entity.user.Collect;
import com.emall.service.base.BaseService;

@Service
public class CollectService extends BaseService<Collect>{

	@Autowired
	private CollectDao dao;
}
