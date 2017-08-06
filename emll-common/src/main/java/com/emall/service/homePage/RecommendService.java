package com.emall.service.homePage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emall.dao.homePage.RecommendDao;
import com.emall.entity.homePage.Recommend;
import com.emall.service.base.BaseService;

@Service
public class RecommendService extends BaseService<Recommend>{

	@Autowired
	private RecommendDao dao;
}
