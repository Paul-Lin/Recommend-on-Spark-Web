package com.moon.dao.impl;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moon.dao.Dao;
import com.moon.dao.Retrieved;
import com.moon.dao.mapper.ShopBillsMapper;
import com.moon.entity.MoonEntity;
import com.moon.entity.impl.ShopBill;

/**
 * Created by Administrator on 2016/1/16.
 */
@Repository("shopBillsDao")
public class ShopBillsDao implements Dao<ShopBill>, Retrieved<ShopBill> {
	@Autowired
	private ShopBillsMapper shopBillsMapper;
	private Logger log = LoggerFactory.getLogger(ShopBillsDao.class);
	private AtomicInteger count = new AtomicInteger(0);

	@Override
	public int delete(List<ShopBill> list) {
		count = new AtomicInteger(0);
		list.stream().forEach(x -> {
			this.delete(x);
			count.getAndIncrement();
		});
		return count.get();
	}

	@Override
	public boolean delete(ShopBill shopBill) {
		try {
			return shopBillsMapper.delete(shopBill.getId()) == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			throw new RuntimeException("It can not delete.");
		}

	}

	@Override
	public int insert(List<ShopBill> list) {
		count = new AtomicInteger(0);
		list.stream().forEach(x -> {
			this.insert(x);
			count.getAndIncrement();
		});
		return count.get();
	}

	@Override
	public boolean insert(ShopBill shopBill) {
		Objects.requireNonNull(shopBill.getPayNum(), "shopBill should be assignment but null");
		try {
			return shopBillsMapper.insert(shopBill.getShopMenu(), shopBill.getPayNum(), shopBill.getFrom(),
					shopBill.getTo(), shopBill.getCreateAt(), shopBill.getStatus()) == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			throw new RuntimeException("It can not insert shopbill.");
		}

	}

	@Override
	public List<? extends MoonEntity> retrievedByShopMenuId(ShopBill shopBill, Long offset, Integer pageSize) {
		try {
			Objects.requireNonNull(shopBill.getTo(), "shopBill should not be null");
			List<ShopBill> bills = shopBillsMapper.query(shopBill.getTo(), offset, pageSize);
			return bills;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			throw new RuntimeException("It can not query.");
		}

	}

	@Override
	public MoonEntity retrieved(ShopBill shopBill) {
		return this.retrievedByShopMenuId(shopBill, 0L, 1).get(0);
	}

	@Override
	public int update(List<ShopBill> list) {
		list.stream().forEach(x -> {
			update(x);
			count.getAndIncrement();
		});
		return count.getAndIncrement();
	}

	@Override
	public boolean update(ShopBill shopBill) {
		Objects.requireNonNull(shopBill, "The argument shopBill should be assignemnt but not found.");
		try {
			return shopBillsMapper.update(Integer.valueOf(shopBill.getStatus()), shopBill.getShopMenu(),
					shopBill.getPayNum(), shopBill.getId()) == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			throw new RuntimeException("It can not update.");
		}

	}
}
