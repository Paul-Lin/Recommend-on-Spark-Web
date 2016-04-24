package com.moon.dao.impl;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moon.dao.Deletable;
import com.moon.dao.Insertable;
import com.moon.dao.Retrieved;
import com.moon.dao.Updatable;
import com.moon.dao.mapper.ShopMenuMapper;
import com.moon.entity.MoonEntity;
import com.moon.entity.dto.ShopMenuDto;
import com.moon.entity.impl.ShopMenu;

@Repository("shopMenuDao")
public class ShopMenuDao
		implements Deletable<ShopMenu>, Insertable<ShopMenu>, Retrieved<ShopMenu>, Updatable<ShopMenu> {
	@Autowired
	private ShopMenuMapper shopMenuMapper;
	private Logger log = LoggerFactory.getLogger(ShopMenuDao.class);
	private AtomicInteger count = new AtomicInteger(0);

	@Override
	public int update(List<ShopMenu> list) {
		Objects.requireNonNull(list, "list should be assignment but not found.");
		count = new AtomicInteger(0);
		list.stream().forEach(x -> {
			if (this.update(x))
				count.getAndIncrement();
		});
		return count.get();
	}

	@Override
	public boolean update(ShopMenu t) {
		try {
			return shopMenuMapper.update(t.getName(), t.getIntro(), t.getShopId(), t.getId()) == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			throw new RuntimeException("It can not update in ShopMenuDao");
		}
	}

	@Deprecated
	@Override
	public List<? extends MoonEntity> retrievedByShopMenuId(ShopMenu t, Long offset, Integer pageSize) {
		return null;
	}

	public List<? extends MoonEntity> retrievedByShopId(ShopMenu t, long offset, int pageSize) {
		try {
			Objects.requireNonNull(t, "The shopMenu should be assignment but not found");
			return shopMenuMapper.queryByShopId(t.getShopId(), offset, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			throw new RuntimeException("It can not retrieved by ShopId in ShopMenuDao");
		}
	}

	@Override
	public MoonEntity retrieved(ShopMenu t) {
		try {
			Objects.requireNonNull(t, "the shopMenu should be assignment but not found.");
			return shopMenuMapper.query(t.getId());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			throw new RuntimeException("It can not retrieved in shopMenuDao");
		}

	}

	@Override
	public int insert(List<ShopMenu> list) {
		Objects.requireNonNull(list, "list should be assignment but not found.");
		count = new AtomicInteger(0);
		list.stream().filter(x -> x.getName() != null).forEach(x -> {
			if (this.insert(x)) {
				count.getAndIncrement();
			}
		});
		return count.get();
	}

	@Override
	public boolean insert(ShopMenu t) {
		try {
			return shopMenuMapper.insert(t.getName(), t.getIntro(), t.getShopId()) == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			throw new RuntimeException("It can not insert in ShopMenuDao");
		}
	}
	public boolean insert(ShopMenuDto dto){
		try{
			return false;
		}catch(Exception e){
			e.printStackTrace();
			log.error("exception detail: {}",e.getCause());
			throw new RuntimeException("Can not insert in shopMenuDao");
		}
	}
	@Override
	public int delete(List<ShopMenu> list) {
		Objects.requireNonNull(list, "list should be assigment but not found.");
		count = new AtomicInteger(0);
		list.stream().forEach(x -> {
			if (this.delete(x)) {
				count.getAndIncrement();
			}
		});
		return count.get();
	}

	@Override
	public boolean delete(ShopMenu t) {
		try {
			return shopMenuMapper.delete(t.getId()) == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			throw new RuntimeException("It can not delete in ShopMenuDao");
		}
	}

	public List<ShopMenu> retrievedNameOrIntro(String content, long offset, int pageSize) {
		Objects.requireNonNull(content);
		try {
			return shopMenuMapper.queryNameOrIntro(new StringBuilder("%").append(content).append("%").toString(),
					new StringBuilder("%").append(content).append("%").toString(), offset, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			throw new RuntimeException("It can not retrieved name or intro in shopMenuDao");
		}
	}
}
