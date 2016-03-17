package com.moon.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.moon.dao.DaoTest;
import com.moon.entity.impl.Shop;

/**
 * Created by Administrator on 2015/12/6.
 */

public class ShopDaoTest extends DaoTest {
	@Autowired
	private ShopDao shopDao;

	@Test
	public void testInsert() {
		List<Shop> list = new ArrayList<Shop>();
		Shop shop = new Shop();
		shop.setBoss("kfc");
		shop.setAddress("guangzhou");
		shop.setEstablishTime(new Date());
		shop.setIntro("restrautant");
		shop.setName("jay chou");
		shop.setPassword("hello");
		shop.setShopStatus(1);
		shop.setTel("13");
		list.add(shop);
		shopDao.insert(list);
	}

	@Test
	public void testUpdate() {
		Shop shop = new Shop();
		shop.setName("kfc");
		// shop=(Shop)dao.retrieved(shop);
		shop.setShopStatus(1);
		shopDao.update(shop);
	}

	@Test
	public void testDelete() {
		Shop shop = new Shop();
		shop.setName("kfc");
		shopDao.delete(shop);
	}

	@Test
	public void testRetrieved() {
		Shop shop = new Shop();
		shop.setName("bb");
		shop.setPassword("bb");
		Shop temp = (Shop) shopDao.retrieved(shop);
		System.out.println(temp.toString());

	}
	
	@Test
	public void testRetrievedByShopId(){
		Shop shop=new Shop();
		shop.setId(6L);
		System.out.println(shopDao.retrievedByShopId(shop));
	}

}
