package com.moon.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moon.dao.mapper.RecommendMenuMapper;
import com.moon.entity.impl.RecommendMenu;
@Repository("recommendDao")
public class RecommendDao{
	private static final Logger log=LoggerFactory.getLogger(RecommendDao.class);
	@Autowired
	private RecommendMenuMapper recommendMenuMapper;
	public List<RecommendMenu> query(long customerId){
		try{
			return recommendMenuMapper.query(customerId);
		}catch(Exception e){
			e.printStackTrace();
			log.error("exception detail: {}",e.getMessage());
			throw new RuntimeException("It can not query recommend menus in recommendService.");
		}
	}
}
