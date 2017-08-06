package com.emall.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emall.dao.user.CommentDao;
import com.emall.entity.user.Comment;
import com.emall.service.base.BaseService;

@Service
public class CommentService extends BaseService<Comment>{

	@Autowired
	private CommentDao dao;
}
