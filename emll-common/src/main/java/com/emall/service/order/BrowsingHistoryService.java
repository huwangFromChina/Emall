package com.emall.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emall.dao.order.BrowsingHistoryDao;
import com.emall.entity.order.BrowsingHistory;
import com.emall.service.base.BaseService;

@Service
public class BrowsingHistoryService extends BaseService<BrowsingHistory>{

	@Autowired
	private BrowsingHistoryDao dao;
}
