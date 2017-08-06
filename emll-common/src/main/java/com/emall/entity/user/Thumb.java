package com.emall.entity.user;

import java.util.Date;

import javax.persistence.*;

import com.emall.util.MyColumn;

@Entity
@Table(name="thumb")
public class Thumb {

	@MyColumn(title="ID")
	private int id;
	
	@MyColumn(title="用户ID")
	private int userId;
	
	@MyColumn(title="点赞对象的所属类别")
	private String type;
	
	@MyColumn(title="点赞对象的ID")
	private int contentId;
	
	@MyColumn(title="创建时间")
	private Date createDate;

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

	@Column(name="type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name="content_id")
	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	@Column(name="create_date")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}