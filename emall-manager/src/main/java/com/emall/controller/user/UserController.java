package com.emall.controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
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

@SuppressWarnings("deprecation")
@Controller
@RequestMapping(value = "user")
public class UserController extends Base {

	@Autowired
	private UserService service;
	@Autowired
	private UserTokenService tokenService;
	private final String mailUrl = "http://localhost:8080/emall_agent/mail/send.do";
	private final String activateUrl = "http://localhost:8080/emall_manager/user/activate.do";

	@RequestMapping(value = "login")
	@ResponseBody
	public MappingJacksonValue Loging(String username, String password,
			ModelMap model, HttpServletRequest request) {
		if (empty(username) || empty(password))
			return ApiConfig.RETURN(model, ApiConfig.PARAM_INVALID);
		User user = service.login(username, password, null);
		if (empty(user)) {
			if (!service.ExsitUser(username,null))
				return ApiConfig.RETURN(model, ApiConfig.ERROR_NAME);
			else
				return ApiConfig.RETURN(model, ApiConfig.ERROR_PASS);
		}
		try {
			UserToken token = tokenService.getByUserId(user.getId());
			if (notEmpty(token))
				tokenService.deleteEntity(token.getId());
			token = new UserToken();
			token.setLastLoginDate(getDate());
			token.setUserId(user.getId()); 
			token.setUserToken(UUID.randomUUID().toString());
			token.setIp(request.getRemoteAddr());
			tokenService.saveEntity(token);
			model.put("userToken", token.getUserToken());
			return ApiConfig.RETURN(model, ApiConfig.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ApiConfig.RETURN(model, ApiConfig.FAILD);
	}

	@RequestMapping(value = "register")
	@ResponseBody
	public MappingJacksonValue Register(String name, String password,
			String email, ModelMap model) {
		if (empty(name) || empty(password) || empty(email))
			return ApiConfig.RETURN(model, ApiConfig.PARAM_INVALID);
		if (service.ExsitUser(name, null)
				|| service.ExsitUser(email, null))
			return ApiConfig.RETURN(model, ApiConfig.NAME_CONFLICT);
		try {
			User user = new User();
			String activateCode = UUID.randomUUID().toString();
			user.setAccount(null);
			user.setAvater(null);
			user.setBirthday(null);
			user.setDescription(null);
			user.setEmail(email);
			user.setPassword(password);
			user.setRegistedDate(getDate());
			user.setSex(false);
			user.setUserName(name);
			user.setStatus(0); // 默认设为0，待激活
			user.setActivateCode(activateCode);
			if (sendEmail(name, email, activateCode) == 0)
				return ApiConfig.RETURN(model, ApiConfig.FAILD);
			else {
				service.saveEntity(user);
				return ApiConfig.RETURN(model, ApiConfig.SUCCESS);
			}
		} catch (Exception e) {
			return ApiConfig.RETURN(model, ApiConfig.FAILD);
		}
	}

	// 发送邮件
	private int sendEmail(String name, String email, String activateCode) {
		// TODO Auto-generated method stub
		HttpClient http = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(mailUrl);
		try {
			List<NameValuePair> value = new ArrayList<NameValuePair>();
			JSONObject json = new JSONObject();
			json.put("user", email);
			json.put("subject", "Emall商城");
			json.put("activateUrl", activateUrl + "?activateCode="
					+ activateCode);
			value.add(new BasicNameValuePair("user", email));
			value.add(new BasicNameValuePair("subject", "Emall商城"));
			value.add(new BasicNameValuePair("activateUrl", activateUrl
					+ "?activateCode=" + activateCode));
			// value.add(new BasicNameValuePair("msg",
			// getStringFromJson(json)));
			httpPost.setHeader("Content-type",
					"application/x-www-form-urlencoded");
			httpPost.setEntity(new UrlEncodedFormEntity(value, "utf-8"));
			HttpResponse response = http.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == 200) {
				String conResult = EntityUtils.toString(response.getEntity());
				JSONObject sobj = new JSONObject();
				sobj = JSONObject.fromObject(conResult);
				String result = sobj.getString("RES_CODE");
				if (result.equals("100"))
					return 1;
				else
					return 0;
			} else {
				return 0;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@RequestMapping(value = "activate")
	@ResponseBody
	public String ActivateUser(String activateCode, ModelMap model) {
		if (notEmpty(activateCode)) {
			User user = service.getUserByActivateCode(activateCode);
			if (user != null) {
				user.setStatus(1);
				service.updateEntity(user);
				return "激活成功";
			}
		}
		return "激活失败";
	}
}
