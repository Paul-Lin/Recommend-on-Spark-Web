package com.moon.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.moon.entity.impl.RecommendMenu;

public interface RecommendMenuMapper {
	@Select("select * from recommend_menu where recommend_menu_user_id=#{userId} limit 0,10")
	@ResultMap("recommendMenu")
	public List<RecommendMenu> query(@Param("userId")long userId);
	
}
