package com.emall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emall.dao.goods.GoodsPicDao;
import com.emall.entity.goods.GoodsPic;
import com.emall.service.base.BaseService;

@Service
public class GoodsPicService extends BaseService<GoodsPic>{

	@Autowired
	private GoodsPicDao dao;
}
