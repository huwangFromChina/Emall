package com.emall.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emall.dao.order.OrderDao;
import com.emall.entity.order.Order;
import com.emall.service.base.BaseService;

@Service
public class OrderService extends BaseService<Order>{

	@Autowired
	private OrderDao dao;
}
