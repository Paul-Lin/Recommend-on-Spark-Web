package com.moon.common.util;

import org.junit.Test;

public class PropUtilsTest {
	@Test
	public void testGetRecomendValue(){
		System.out.println(PropUtils.getRecomendValue("sparkJar"));
	}

	@Test
	public void testGetJedisConfiguration(){
		System.out.println(PropUtils.getRecomendValue("jedisHost")+" : "+PropUtils.getRecomendValue("jedisPort"));
	}
}
