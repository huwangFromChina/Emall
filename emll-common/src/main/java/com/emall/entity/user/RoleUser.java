package com.emall.entity.user;

import javax.persistence.*;

import com.emall.util.MyColumn;

@Entity
@Table(name="role_user")
public class RoleUser {

	@MyColumn(title="ID")
	private int id;
	
	@MyColumn(title="用户ID")
	private int userId;
	
	@MyColumn(title="角色ID")
	private int roleId;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="user_id")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name="role_id")
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	
}
