package com.emall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emall.dao.base.BaseDao;
import com.emall.dao.goods.GoodsCategoryDao;
import com.emall.entity.goods.GoodsCategory;
import com.emall.entity.user.User;
import com.emall.service.base.BaseService;

@Service
public class GoodsCategoryService extends BaseService<GoodsCategory>{

	@Autowired
	private GoodsCategoryDao dao;
	
}
