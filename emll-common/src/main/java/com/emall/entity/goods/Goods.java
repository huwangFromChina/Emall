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
@Table(name="goods")
public class Goods {
	
	@MyColumn(title="ID")
	private int id;
	
	@MyColumn(title="商品名")
	private String name;
	
	@MyColumn(title="商品简介")
	private String description;
	
	@MyColumn(title="商品价格")
	private int price;
	
	@MyColumn(title="商品存货")
	private int stock;
	
	@MyColumn(title="商品头像展示")
	private String avater;
	
	@MyColumn(title="制造商")
	private String production;
	
	@MyColumn(title="信息发布时间")
	private Date createDate;
	
	@MyColumn(title="商品制造时间")
	private Date productDate;
	
	@MyColumn(title="已售卖出的数量")
	private int saleVolume;
	
	@MyColumn(title="点赞数")
	private int thumbs;
	
	@MyColumn(title="评论数")
	private int comments;
	
	@MyColumn(title="信息发布者ID")
	private int createUserId;
	
	@MyColumn(title="店铺Id")
	private int shopId;
	
	@MyColumn(title="售卖状态")
	private int status;
	
	@MyColumn(title="是否置顶")
	private boolean top;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
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

	@Column(name="price")
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Column(name="stock")
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Column(name="avater")
	public String getAvater() {
		return avater;
	}

	public void setAvater(String avater) {
		this.avater = avater;
	}

	@Column(name="production")
	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	@Column(name="create_time")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name="product_time")
	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	@Column(name="sale_volume")
	public int getSaleVolume() {
		return saleVolume;
	}

	public void setSaleVolume(int saleVolume) {
		this.saleVolume = saleVolume;
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

	@Column(name="shop_id")
	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	@Column(name="status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name="top")
	public boolean isTop() {
		return top;
	}

	public void setTop(boolean top) {
		this.top = top;
	}
	
}
