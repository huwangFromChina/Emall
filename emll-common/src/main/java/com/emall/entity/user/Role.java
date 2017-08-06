package com.emall.entity.user;

import javax.persistence.*;

import com.emall.util.MyColumn;

@Entity
@Table(name="role")
public class Role {

	@MyColumn(title="ID")
	private int id;
	
	@MyColumn(title="角色名")
	private String roleName;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="role_name")
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
