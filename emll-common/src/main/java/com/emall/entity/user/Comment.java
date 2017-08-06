package com.emall.entity.user;

import java.util.Date;

import javax.persistence.*;

import com.emall.util.MyColumn;

@Entity
@Table(name="comment")
public class Comment {

	@MyColumn(title="ID")
	private int id;
	
	@MyColumn(title="评论内容")
	private String text;
	
	@MyColumn(title="创建时间")
	private Date cretaDate;
	
	@MyColumn(title="评论对象所属类别")
	private String type;
	
	@MyColumn(title="评论对象的Id")
	private int contentId;
	
	@MyColumn(title="父评论ID")
	private int parentId;
	
	@MyColumn(title="用户ID")
	private int userId;
	
	@MyColumn(title="点赞数")
	private int likes;
	
	@MyColumn(title="子评论数")
	private int childs;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="text")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name="create_date")
	public Date getCretaDate() {
		return cretaDate;
	}

	public void setCretaDate(Date cretaDate) {
		this.cretaDate = cretaDate;
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

	@Column(name="parent_id")
	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	@Column(name="user_id")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name="likes")
	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	@Column(name="childs")
	public int getChilds() {
		return childs;
	}

	public void setChilds(int childs) {
		this.childs = childs;
	}
	
}
