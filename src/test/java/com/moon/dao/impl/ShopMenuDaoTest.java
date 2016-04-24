package com.moon.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.moon.common.AppConstant;
import com.moon.dao.DaoTest;
import com.moon.entity.impl.ShopMenu;

public class ShopMenuDaoTest extends DaoTest {
	@Autowired
	private ShopMenuDao shopMenuDao;

	@Test
	public void testUpdateListOfShopMenu() {
		ShopMenu shopMenu = new ShopMenu();
		shopMenu.setIntro("data algorithm");
		shopMenu.setName("data algorithm in cpp");
		shopMenu.setShopId(1L);
		shopMenu.setId(7L);
		shopMenuDao.update(shopMenu);
	}

	@Test
	public void testUpdateShopMenu() {
		List<ShopMenu> list = new ArrayList<ShopMenu>();
		ShopMenu shopMenu = new ShopMenu();
		shopMenu.setIntro("data algorithm");
		shopMenu.setName("data algorithm in c");
		shopMenu.setShopId(1L);
		shopMenu.setId(7L);
		list.add(shopMenu);
		shopMenuDao.update(list);
	}

	@Test
	public void testRetrievedShopMenuLongInteger() {
		ShopMenu t = new ShopMenu();
		t.setShopId(1L);
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<ShopMenu> list=(List<ShopMenu>) shopMenuDao.retrievedByShopMenuId(t,0L,AppConstant.PAGE);
		list.forEach(System.out::println);
	}

	@Test
	public void testRetrievedShopMenu() {
		ShopMenu t = new ShopMenu();
		t.setShopId(1L);
		ShopMenu shopMenu = (ShopMenu) shopMenuDao.retrieved(t);
		System.out.println(shopMenu.toString());
	}

	@Test
	public void testInsertListOfShopMenu() {
		List<ShopMenu> list = new ArrayList<ShopMenu>();
		ShopMenu shopMenu = new ShopMenu();
		shopMenu.setIntro("advanced data analysix");
		shopMenu.setName("advanced data analysix");
		shopMenu.setShopId(1L);
		list.add(shopMenu);
		shopMenuDao.insert(list);
	}

	@Test
	public void testInsertShopMenu() {
		ShopMenu shopMenu = new ShopMenu();
		shopMenu.setIntro("apache spark code analysix");
		shopMenu.setName("apache spark");
		shopMenu.setShopId(1L);
		shopMenuDao.insert(shopMenu);
	}

	@Test
	public void testDeleteListOfShopMenu() {
		List<ShopMenu> list = new ArrayList<ShopMenu>();
		ShopMenu shopMenu = new ShopMenu();
		shopMenu.setIntro("advanced data analysix");
		shopMenu.setName("advanced data analysix");
		shopMenu.setShopId(1L);
		shopMenu.setId(5L);
		list.add(shopMenu);
		shopMenuDao.delete(list);
	}

	@Test
	public void testDeleteShopMenu() {
		ShopMenu shopMenu = new ShopMenu();
		shopMenu.setId(3L);
		shopMenuDao.delete(shopMenu);
	}
	@Test
	public void testRetrievedByShopId(){
		ShopMenu shopMenu=new ShopMenu();
		shopMenu.setShopId(1026712);
		shopMenuDao.retrievedByShopId(shopMenu, 0L, AppConstant.PAGE).stream().forEach(System.out::println);;
	}
	
	@Test
	public void testRetrievedNameOrIntro(){
		shopMenuDao.retrievedNameOrIntro("杰", 0L, AppConstant.PAGE).stream().forEach(System.out::println);;
	}
}
