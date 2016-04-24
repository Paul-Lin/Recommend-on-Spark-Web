package com.moon.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.moon.service.ServiceTest;

public class ShopMenuImageServiceTest extends ServiceTest {
	@Autowired
	private ShopMenuImageService shopMenuImageService;
	@Test
	public void testRecommendShopMenu(){
		shopMenuImageService.recommendShopMenu(6L).stream().forEach(System.out::println);;
	}
}
