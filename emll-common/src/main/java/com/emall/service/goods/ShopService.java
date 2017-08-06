package com.emall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emall.dao.goods.ShopDao;
import com.emall.entity.goods.Shop;
import com.emall.service.base.BaseService;

@Service
public class ShopService extends BaseService<Shop>{

	@Autowired
	private ShopDao dao;
}
