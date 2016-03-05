package com.moon.dao;

import java.util.List;

import com.moon.entity.MoonEntity;
import com.moon.entity.RetrievedCondition;

public interface Retrieved <T extends RetrievedCondition>{
	public List<? extends MoonEntity> retrieved(T t,Long offset,Integer pageSize);

	public MoonEntity retrieved(T t);
}
