package com.emall.entity.order;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.emall.util.MyColumn;

@Entity
@Table(name="order")
public class Order {

	@MyColumn(title="ID")
	private int id;

	@MyColumn(title="用户ID")
	private int userId;

	@MyColumn(title="总工需要支付金额")
	private int totalPay;

	@MyColumn(title="商品ID")
	private int goodsId;

	@MyColumn(title="支付状态")
	private int payStatus;

	@MyColumn(title="商品数量")
	private int goodsCount;

	@MyColumn(title="商品价格")
	private int goodsPrice;
	
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
	
	@Column(name="total_pay")
	public int getTotalPay() {
		return totalPay;
	}
	
	public void setTotalPay(int totalPay) {
		this.totalPay = totalPay;
	}
	
	@Column(name="goods_id")
	public int getGoodsId() {
		return goodsId;
	}
	
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	
	@Column(name="pay_status")
	public int getPayStatus() {
		return payStatus;
	}
	
	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}
	
	@Column(name="goods_count")
	public int getGoodsCount() {
		return goodsCount;
	}
	
	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}
	
	@Column(name="goods_price")
	public int getGoodsPrice() {
		return goodsPrice;
	}
	
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	@Column(name="create_time")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
