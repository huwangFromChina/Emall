package com.emall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emall.dao.goods.GoodsDao;
import com.emall.entity.goods.Goods;
import com.emall.service.base.BaseService;

@Service
public class GoodsService extends BaseService<Goods>{

	@Autowired
	private GoodsDao dao;
}
