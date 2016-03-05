package com.moon.dao.mapper;

import java.util.List;

import com.moon.entity.impl.ShopMenu;

public interface ShopMenuMapper {
	public void update();
	public void delete();
	public void insert();
	public List<ShopMenu> query();
}
