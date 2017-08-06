package com.emall.entity.user;

import java.util.Date;

import javax.persistence.*;

import com.emall.util.MyColumn;

@Entity
@Table(name="user")
public class User {
	
	@MyColumn(title="ID")
	private int id;
	
	@MyColumn(title="用户账号")
	private String account;
	
	@MyColumn(title="用户名")
	private String userName;
	
	@MyColumn(title="用户密码")
	private String password;
	
	@MyColumn(title="注册时间")
	private Date RegistedDate;
	
	@MyColumn(title="最近一次的登录时间")
	private Date lastLoginDate;
	
	@MyColumn(title="生日")
	private Date birthday;
	
	@MyColumn(title="性别，false为女性，true为男性")
	private boolean sex;
	
	@MyColumn(title="个人简介")
	private String description;
	
	@MyColumn(title="个人邮箱")
	private String email;
	
	@MyColumn(title="头像地址")
	private String avater;
	
	@MyColumn(title="账号状态")
	private int status;
	
	@MyColumn(title="激活码")
	private String activateCode;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="account")
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name="username")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="registed_date")
	public Date getRegistedDate() {
		return RegistedDate;
	}

	public void setRegistedDate(Date registedDate) {
		RegistedDate = registedDate;
	}

	@Column(name="last_login_date")
	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	@Column(name="birthday")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name="sex")
	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	@Column(name="decription")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="avater")
	public String getAvater() {
		return avater;
	}

	public void setAvater(String avater) {
		this.avater = avater;
	}

	@Column(name="status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name="activateCode")
	public String getActivateCode() {
		return activateCode;
	}

	public void setActivateCode(String activateCode) {
		this.activateCode = activateCode;
	}
	

}
