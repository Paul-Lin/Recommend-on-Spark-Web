package com.moon.entity.dto;

import java.util.List;

import com.google.gson.GsonBuilder;
import com.moon.entity.MoonEntity;
import com.moon.entity.impl.Shop;

public class ShopDto implements MoonEntity{
	private static final long serialVersionUID = 3788527771440261790L;
	private Shop shop;
	private List<ShopMenuDto> list;
	
	public List<ShopMenuDto> getList() {
		return list;
	}
	public void setList(List<ShopMenuDto> list) {
		this.list = list;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	@Override
	public String toString() {
		return new GsonBuilder().setPrettyPrinting().create().toJson(this);
	}
	
}
