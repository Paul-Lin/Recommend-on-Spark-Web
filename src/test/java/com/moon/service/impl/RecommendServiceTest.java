package com.moon.service.impl;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.moon.service.ServiceTest;

public class RecommendServiceTest extends ServiceTest{
	@Autowired
	private RecommendService recommendService;
	@Test
	public void testQuery() {
		fail("Not yet implemented");
	}

	@Test
	public void testRecommend() {
		recommendService.recommend();
	}
	
	@Test
	public void testBatchInsertRecommend(){
		recommendService.batchInsertRecommend();
	}

}
