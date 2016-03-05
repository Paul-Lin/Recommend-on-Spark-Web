package com.moon.entity.impl;

import com.moon.entity.MoonEntity;

public class ShopImage implements MoonEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8878062518605661212L;
	private long id;
	private String path;
	private long shopId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public long getShopId() {
		return shopId;
	}
	public void setShopId(long shopId) {
		this.shopId = shopId;
	}
	
}
