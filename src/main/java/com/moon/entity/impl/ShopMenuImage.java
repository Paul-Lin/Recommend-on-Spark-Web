package com.moon.entity.impl;

import com.moon.entity.MoonEntity;

public class ShopMenuImage implements MoonEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3761906074917002251L;
	private long id;
	private String path;
	private long shopMenuId;
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
	public long getShopMenuId() {
		return shopMenuId;
	}
	public void setShopMenuId(long shopMenuId) {
		this.shopMenuId = shopMenuId;
	}

	
}
