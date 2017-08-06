package com.emall.controller.test;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emall.base.ApiConfig;
import com.emall.base.Base;
import com.emall.entity.user.User;
import com.emall.entity.user.UserToken;
import com.emall.service.user.UserService;
import com.emall.service.user.UserTokenService;


@Controller
@RequestMapping(value="user")
public class test extends Base{

	@Autowired
	private UserTokenService service;
	
	@RequestMapping(value="delete")
	@ResponseBody
	public String test(int i)
	{
		service.delete(i);
		return "success";
	}
	
	@RequestMapping(value="update")
	@ResponseBody
	public String update(int i)
	{
		//service.delete(i);
		UserToken token=service.getEntity(i);
		token.setUserToken("huwang");
		service.updateEntity(token);
		return "success";
	}
	
}
