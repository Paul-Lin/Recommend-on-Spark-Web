package com.moon.enums;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserStatusTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(UserStatus.valueOf(UserStatus.USER_EXISTS));
	}

}
