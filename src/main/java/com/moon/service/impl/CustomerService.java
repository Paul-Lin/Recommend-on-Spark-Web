package com.moon.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moon.dao.impl.CustomerDao;
import com.moon.entity.impl.Customer;
import com.moon.service.MoonService;
@Service("customerService")
@Transactional
public class CustomerService implements MoonService{
	private static final long serialVersionUID = -5041294678196864595L;
	private AtomicInteger count=new AtomicInteger(0);
	@Autowired
	private CustomerDao customerDao;
	public Customer retrieved(Customer t){
		Objects.requireNonNull(t.getNickname(),"nickname of customer must be not null");
		Customer customer=(Customer) customerDao.retrieved(t);
		return Objects.isNull(customer.getNickname())?null:customer;
	}
	
	public Optional<Customer> retrieved(String nickname,String pass){
		Objects.requireNonNull(nickname,"nickname must be not nulll");
		Objects.requireNonNull(pass,"pass must be not null");
		
		Customer t=new Customer();
		t.setNickname(nickname);
		t.setPass(pass);
		Optional<Customer> optional=Optional.of((Customer)customerDao.retrieved(t));
		return optional;
	}
	public boolean login(String nickname,String pass){
		Customer t=new Customer();
		t.setNickname(nickname);
		t.setPass(t.getPass());
		return Objects.isNull(this.retrieved(t))?false:true;
	}
	
	public boolean update(Customer customer){
		Objects.requireNonNull(customer.getId(),"ID of customer must be not null");
		return customerDao.update(customer);
	}
	
	public int update(List<Customer> customers){
		count=new AtomicInteger(0);
		customers.stream().filter(x->Objects.nonNull(x.getId())).forEach(x->{
			if(customerDao.update(x))
				count.getAndIncrement();
		});
		return count.get();
	}
	
	public boolean insert(Customer t){
		Objects.requireNonNull(t.getNickname(),"nickname of customer must be not null");
		Objects.requireNonNull(t.getPass(),"pass of customer must be not null");
		Objects.requireNonNull(t.getEmail(),"eamil of customer must be not null");
		return customerDao.insert(t);
	}
	
	public int insert(List<Customer> customers){
		count=new AtomicInteger(0);
		customers.stream().forEach(x->{
			if(this.insert(x))
				count.getAndIncrement();
		});
		return count.get();
	}
}
