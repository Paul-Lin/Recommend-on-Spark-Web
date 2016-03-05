package com.moon.entity.impl;

import com.google.gson.GsonBuilder;
import com.moon.entity.MoonEntity;
import com.moon.entity.RetrievedCondition;

public class ShopMenu implements MoonEntity,RetrievedCondition{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7878917892473556311L;
	private long id;
	private String name;
	private String intro;
	private long shopId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getShopId() {
		return shopId;
	}
	public void setShopId(long shopId) {
		this.shopId = shopId;
	}
	@Override
	public String toString() {
		return new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}
	
}
