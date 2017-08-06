package com.emall.entity.goods;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.emall.util.MyColumn;

@Entity
@Table(name="goods_pic")
public class GoodsPic {

	@MyColumn(title="ID")
	private int id;

    @MyColumn(title="图片地址")
	private String url;
    
    @MyColumn(title="图片所属对象的Id")
	private int contentId;
    
    @MyColumn(title="图片所属对象的类别")
	private String type;

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name="content_id")
	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	@Column(name="type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
}
