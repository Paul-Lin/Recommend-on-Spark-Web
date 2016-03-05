package com.moon.service.impl;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.moon.entity.impl.Shop;
import com.moon.service.ServiceTest;

/**
 * Created by Administrator on 2015/12/11.
 */
public class ShopServiceTest extends ServiceTest{
    @Autowired
    private ShopService service;

    @Before
    public void init()
    {
        Shop shop=new Shop();
        shop.setName("kfcc245008e-af51-478e-9141-f5ca0b19fa1d");
        shop.setPassword("hello");
        service.setShop(shop);
    }
   
}
