package com.moon.dao.impl;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.moon.common.AppConstant;
import com.moon.dao.DaoTest;
import com.moon.entity.impl.ShopMenuImage;
import com.moon.entity.impl.ShopMenuImage.BuildShopMenuImage;

public class ShopMenuImageDaoTest extends DaoTest{
	@Autowired
	private ShopMenuImageDao shopMenuImageDao;
	@Test
	public void testDeleteListOfShopMenuImage() {
		ShopMenuImage t=new ShopMenuImage();
		t.setId(8L);
		List<ShopMenuImage> list=new ArrayList<ShopMenuImage>();
		list.add(t);
		System.out.println(shopMenuImageDao.delete(list));
	}

	@Test
	public void testDeleteShopMenuImage() {
		ShopMenuImage t=new ShopMenuImage();
		t.setId(8L);
		System.out.println(shopMenuImageDao.delete(t));
	}

	@Test
	public void testRetrievedShopMenuImageLongInteger() {
		@SuppressWarnings("unchecked")
		List<ShopMenuImage> shopMenuImage=(List<ShopMenuImage>) shopMenuImageDao.retrievedByShopMenuId(BuildShopMenuImage.build(1L), 0L, AppConstant.PAGE);
		shopMenuImage.stream().forEach(System.out::println);
	}

	@Test
	@Deprecated
	public void testRetrievedShopMenuImage() {
	}

	@Test
	public void testInsertListOfShopMenuImage() {
		ShopMenuImage t=BuildShopMenuImage.build(1L);
		t.setShopMenuId(4L);
		t.setPath("path++++++");
		List<ShopMenuImage> images=new ArrayList<ShopMenuImage>();
		images.add(t);
		System.out.println(shopMenuImageDao.insert(images));
	}

	@Test
	public void testInsertShopMenuImage() {
		ShopMenuImage t=BuildShopMenuImage.build(1L);
		t.setShopMenuId(1L);
		t.setPath("path....");
		
		System.out.println(shopMenuImageDao.insert(t));	}

	@Test
	public void testUpdateListOfShopMenuImage() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateShopMenuImage() {
		ShopMenuImage t=new ShopMenuImage();
		t.setShopMenuId(1L);
		t.setId(1L);
		t.setPath("udpate path");
		System.out.println(shopMenuImageDao.update(t));
	}

}
