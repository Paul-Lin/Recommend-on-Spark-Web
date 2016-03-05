package com.moon.dao;

import java.util.List;

import com.moon.entity.MoonEntity;

public interface Insertable<T extends MoonEntity> {
	public int insert(List<T> list);
	
	public boolean insert(T t);
}
