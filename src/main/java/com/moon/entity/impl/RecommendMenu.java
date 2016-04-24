package com.moon.entity.impl;

import com.moon.entity.Entity;

public class RecommendMenu extends Entity{
	private static final long serialVersionUID = -3616903895434966092L;
	private long id;
	private long userId;
	private long shopMenuId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getShopMenuId() {
		return shopMenuId;
	}
	public void setShopMenuId(long shopMenuId) {
		this.shopMenuId = shopMenuId;
	}
	
}
