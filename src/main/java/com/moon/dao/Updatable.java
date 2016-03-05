package com.moon.dao;

import java.util.List;

import com.moon.entity.MoonEntity;

public interface Updatable<T extends MoonEntity> {
	public int update(List<T> list);
	
	public boolean update(T t);
}
