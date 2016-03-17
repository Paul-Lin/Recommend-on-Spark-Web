package com.moon.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.moon.service.ServiceTest;

/**
 * Created by Administrator on 2015/12/11.
 */
public class ShopServiceTest extends ServiceTest{
    @Autowired
    private ShopService shopService;

    @Test
    public void testLogin(){
        System.out.println(shopService.login("aa", "aa"));
    }
   
}
