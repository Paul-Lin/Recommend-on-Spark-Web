package com.moon.dao.impl;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.moon.dao.DaoTest;
import com.moon.entity.impl.ShopBill;
import com.moon.enums.ShopBillStatus;

public class ShopBillsDaoTest extends DaoTest{
	@Autowired
	private ShopBillsDao shopBillsDao;
	@Test
	public void testDeleteListOfShopBill() {
	}

	@Test
	public void testDeleteShopBill() {
		
	}

	@Test
	public void testInsertListOfShopBill() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertShopBill() {
		ShopBill bill=new ShopBill();
		bill.setCreateAt(new Date());
		bill.setFrom(1);
		bill.setTo(1L);
		bill.setStatus(ShopBillStatus.COMPLETING.valueOf());
		bill.setShopMenu(1L);
		bill.setPayNum(100);
		shopBillsDao.insert(bill);
	}

	@Test
	public void testRetrievedShopBillLongInteger() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrievedShopBill() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateListOfShopBill() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateShopBill() {
		fail("Not yet implemented");
	}
}
