package com.emall.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emall.dao.order.ShoppingCartDao;
import com.emall.entity.order.ShoppingCart;
import com.emall.service.base.BaseService;

@Service
public class ShoppingCartService extends BaseService<ShoppingCart>{

	@Autowired
	private ShoppingCartDao dao;
}
