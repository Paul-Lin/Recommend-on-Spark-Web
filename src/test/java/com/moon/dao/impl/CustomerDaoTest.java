package com.moon.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.moon.dao.DaoTest;
import com.moon.entity.impl.Customer;

public class CustomerDaoTest extends DaoTest{
	@Autowired
	private CustomerDao dao;
	public void testInsert() {
		Customer t=new Customer();
		t.setAvatar("avatar");
		t.setNickname("nickname");
		t.setEmail("email");
		t.setPass("pass");
		dao.insert(t);
	}

	public void testUpdate() {
		Customer t=new Customer();
		t.setNickname("nickname");
		t=(Customer) dao.retrieved(t);
		t.setNickname("a");
		dao.update(t);
		t=(Customer) dao.retrieved(t);
		System.out.println(t.toString());
	}
	public void testDelete() {
		
	}

	public void testRetrieved() {
		Customer t=new Customer();
		t.setNickname("nickname");
		t=(Customer) dao.retrieved(t);
		System.out.println(t.toString());
	}
	
}
