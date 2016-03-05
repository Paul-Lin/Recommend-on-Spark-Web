package com.moon.dao;

import java.util.List;

import com.moon.entity.MoonEntity;

public interface Deletable<T extends MoonEntity> {
	public int delete(List<T> list);
	
	public boolean delete(T t);
}
