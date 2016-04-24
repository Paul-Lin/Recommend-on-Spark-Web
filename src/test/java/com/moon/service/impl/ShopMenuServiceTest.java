package com.moon.service.impl;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.moon.common.AppConstant;
import com.moon.entity.dto.ShopMenuDto;
import com.moon.service.ServiceTest;

public class ShopMenuServiceTest extends ServiceTest{
	@Autowired
	private ShopMenuService shopMenuService;
	@Test
	public void testQueryByShopMenuId() {
		ShopMenuDto dto=shopMenuService.queryByShopMenuId(7L);
		System.out.println(dto);
	}

	@Test
	public void testQueryByShopId() {
		shopMenuService.queryByShopId(1026712, 0L, AppConstant.PAGE).stream().forEach(System.out::println);;
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		shopMenuService.delete(25L);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

}
