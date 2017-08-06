package com.emall.base;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.ui.ModelMap;


public class ApiConfig {

	public static final Map<Integer,String> code_msg=new HashMap<Integer,String>();
	public static final int SUCCESS=100;  //操作成功
	public static final int FAILD=200;  //操作失败
	public static final int PARAM_INVALID=300;   //参数错误 
	
	//用户模块
	public static final int ERROR_NAME=201; //用户名或账号不存在
	public static final int ERROR_PASS=202; //密码错误或账号未激活
	public static final int NAME_CONFLICT=203;//用户名或账号冲突
	
	static{
		code_msg.put(SUCCESS, "操作成功");
		code_msg.put(FAILD, "操作失败");
		code_msg.put(PARAM_INVALID, "参数错误");
		code_msg.put(ERROR_NAME, "用户名或账号不存在");
		code_msg.put(ERROR_PASS,"密码错误或账号未激活");
		code_msg.put(NAME_CONFLICT,"用户名或账号冲突");
	}
	
	public static MappingJacksonValue RETURN(ModelMap model,int code,Object object)
	{
		model.put("RES_CODE", code);
		model.put("RES_MSG", code_msg.get(code));
		model.put("DATA", object);
		return new MappingJacksonValue(model);
	}
	
	public static MappingJacksonValue RETURN(ModelMap model,int code)
	{
		model.put("RES_CODE", code);
		model.put("RES_MSG", code_msg.get(code));
		return new MappingJacksonValue(model);
	}
	
	
}
