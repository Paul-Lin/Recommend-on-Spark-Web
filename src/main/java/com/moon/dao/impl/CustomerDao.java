package com.moon.dao.impl;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moon.dao.Dao;
import com.moon.dao.Retrieved;
import com.moon.dao.mapper.CustomerMapper;
import com.moon.entity.MoonEntity;
import com.moon.entity.impl.Customer;

@Repository("customerDao")
public class CustomerDao implements Dao<Customer>, Retrieved<Customer> {
	@Autowired
	private CustomerMapper mapper;
	private AtomicInteger count = new AtomicInteger(0);

	@Deprecated
	@Override
	public int delete(List<Customer> list) {
		return 0;
	}

	@Deprecated
	@Override
	public boolean delete(Customer t) {
		return false;
	}

	@Override
	public int insert(List<Customer> list) {
		count = new AtomicInteger(0);
		list.stream().filter(new NotNullCustomer()).forEach(x -> {
			if (this.insert(x) == true)
				count.getAndIncrement();
		});
		return count.get();
	}

	@Override
	public boolean insert(Customer t) {
		try {

			return mapper.insert(t.getPass(), t.getEstablish(), t.getAvatar(), t.getSex(), t.getNickname(),
					t.getLiveAddress(), t.getLoginTime(), t.getLoginIp(), t.getSignnature(), t.getEmail(),
					t.getPhone()) == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int update(List<Customer> list) {
		count = new AtomicInteger(0);
		list.stream().filter(new NotNullCustomer()).forEach(x -> {
			if (this.update(x) == true)
				count.getAndIncrement();
		});
		return count.get();
	}

	@Override
	public boolean update(Customer t) {
		try {
			return mapper.update(t.getId(), t.getPass(), t.getEstablish(), t.getAvatar(), t.getSex(), t.getNickname(),
					t.getLiveAddress(), t.getLoginTime(), t.getLoginIp(), t.getSignnature(), t.getEmail(),
					t.getPhone()) == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<? extends MoonEntity> retrievedByShopMenuId(Customer t, Long offset, Integer pageSize) {
		List<Customer> customers = mapper.retrieved(t.getNickname(), offset, pageSize);
		return customers;
	}

	@Override
	public MoonEntity retrieved(Customer t) {
		return this.retrievedByShopMenuId(t, 0L, 1).get(0);
	}

	static class NotNullCustomer implements Predicate<Customer> {
		@Override
		public boolean test(Customer t) {
			return Objects.nonNull(t.getEmail()) && Objects.nonNull(t.getNickname()) && Objects.nonNull(t.getPass());
		}
	}
}
