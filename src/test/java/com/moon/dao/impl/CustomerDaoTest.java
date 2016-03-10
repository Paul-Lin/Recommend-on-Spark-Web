package com.moon.dao.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.moon.dao.DaoTest;
import com.moon.entity.impl.Customer;

public class CustomerDaoTest extends DaoTest{
	@Autowired
	private CustomerDao dao;
	@Test
	public void testInsert() {
		Customer t=new Customer();
		t.setAvatar("avatar");
		t.setNickname("aa");
		t.setEmail("email");
		t.setPass("aa");
		dao.insert(t);
	}
	@Test
	public void testUpdate() {
		Customer t=new Customer();
		t.setNickname("nickname");
		t=(Customer) dao.retrieved(t);
		t.setNickname("a");
		dao.update(t);
		t=(Customer) dao.retrieved(t);
		System.out.println(t.toString());
	}
	@Test
	public void testDelete() {
		
	}
	@Test
	public void testRetrieved() {
		Customer t=new Customer();
		t.setNickname("nickname");
		t=(Customer) dao.retrieved(t);
		System.out.println(t.toString());
	}
	
}
