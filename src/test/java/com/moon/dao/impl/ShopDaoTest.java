package com.moon.dao.impl;

import static junit.framework.TestCase.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.moon.dao.DaoTest;
import com.moon.entity.impl.Shop;

/**
 * Created by Administrator on 2015/12/6.
 */

public class ShopDaoTest extends DaoTest {
    @Autowired
    private ShopDao dao;

    public void testInsert() {
        List<Shop> list = new ArrayList<Shop>();
        Shop shop = new Shop();
        shop.setBoss("kfc");
        shop.setAddress("guangzhou");
        shop.setEstablishTime(new Date());
        shop.setIntro("restrautant");
        shop.setName("kfc" + UUID.randomUUID().toString());
        shop.setPassword("hello");
        shop.setShopStatus(1);
        shop.setTel("13");
        list.add(shop);
        dao.insert(list);
    }

    public void testUpdate() {
        Shop shop = new Shop();
        shop.setName("kfc");
//        shop=(Shop)dao.retrieved(shop);
        shop.setShopStatus(1);
        dao.update(shop);
    }

    public void testDelete() {
        Shop shop = new Shop();
        shop.setName("kfc");
        dao.delete(shop);
    }

    public void testRetrieved() {
        Shop shop = new Shop();
        shop.setName("kfc");
        shop.setPassword("hello");
        Shop temp=(Shop)dao.retrieved(shop);
        assertTrue(temp.equals(shop));

        System.out.println(dao.retrieved(shop).toString());

    }

}
