package com.emall.entity.goods;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.emall.util.MyColumn;

@Entity
@Table(name = "shop")
public class Shop {

	@MyColumn(title="ID")
	private int id;

	@MyColumn(title="店铺名")
	private String name;

	@MyColumn(title="店铺简介")
	private String description;

	@MyColumn(title="店铺头像图片地址")
	private String avater;

	@MyColumn(title="商品数量")
	private int goodsCount;

	@MyColumn(title="点赞数")
	private int thumbs;

	@MyColumn(title="评论数")
	private int comments;

	@MyColumn(title="店铺拥有者ID")
	private int createUserId;

	@MyColumn(title="是否置顶")
	private boolean top;
	
	@MyColumn(title="创建时间")
	private Date createDate;

	@Column(name="create_time")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="avater")
	public String getAvater() {
		return avater;
	}

	public void setAvater(String avater) {
		this.avater = avater;
	}

	@Column(name="goods_count")
	public int getGoods_count() {
		return goodsCount;
	}

	public void setGoods_count(int goods_count) {
		this.goodsCount = goods_count;
	}

	@Column(name="thumbs")
	public int getThumbs() {
		return thumbs;
	}

	public void setThumbs(int thumbs) {
		this.thumbs = thumbs;
	}

	@Column(name="comments")
	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	@Column(name="create_user_id")
	public int getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}

	@Column(name="top")
	public boolean isTop() {
		return top;
	}

	public void setTop(boolean top) {
		this.top = top;
	}

}
