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
import com.moon.dao.mapper.ShopMenuImageMapper;
import com.moon.entity.MoonEntity;
import com.moon.entity.impl.ShopMenuImage;

@Repository("shopMenuImageDao")
public class ShopMenuImageDao implements Deletable<ShopMenuImage>,Retrieved<ShopMenuImage>,Updatable<ShopMenuImage>,Insertable<ShopMenuImage>{
	private static final Logger log=LoggerFactory.getLogger(ShopMenuImageDao.class);
	@Autowired
	private ShopMenuImageMapper shopMenuImageMapper;
	private AtomicInteger count=new AtomicInteger(0);
	@Override
	public int delete(List<ShopMenuImage> list) {
		count=new AtomicInteger(0);
		list.stream().filter(x->x!=null).forEach(x->{
			if(delete(x))
				count.getAndIncrement();
		});
		return count.get();
	}
	@Override
	public boolean delete(ShopMenuImage t) {
		Objects.requireNonNull(t,"shopMenuImage should be assignment but not found.");
		try{
			
			return shopMenuImageMapper.delete(t.getId())==1?true:false;
		}catch(Exception e){
			e.printStackTrace();
			log.error("exception detail: {}",e.getMessage());
			throw new RuntimeException("It can not delete from shopMenuImageDao.");
		}
	}
	@Override
	public List<? extends MoonEntity> retrievedByShopMenuId(ShopMenuImage t, Long offset, Integer pageSize) {
		Objects.requireNonNull(t.getShopMenuId(),"shopMenuId should be assignment but not found.");
		try{
			return shopMenuImageMapper.retrieved(t.getShopMenuId(),offset,pageSize);
		}catch(Exception e){
			e.printStackTrace();
			log.error("exception detail: {}",e.getMessage());
			throw new RuntimeException("It can not query in ShopMenuImageDao.");
		}
	}
	@Override
	@Deprecated
	public MoonEntity retrieved(ShopMenuImage t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int insert(List<ShopMenuImage> list) {
		Objects.requireNonNull(list,"list should not null in shopMenuImageDao.");
		count=new AtomicInteger(0);
		list.stream().forEach(x->{
			if(this.insert(x))
				count.getAndIncrement();
		});
		return count.get();
	}
	@Override
	public boolean insert(ShopMenuImage t) {
		Objects.requireNonNull(t,"The argument ShopMenuImage should be assignment but not found");
		Objects.requireNonNull(t.getPath(), "The path of shopMenuImage should be assignment but not found.");
		Objects.requireNonNull(t.getShopMenuId(), "The shopMenuId of shopMenuImage should be assignment but not found.");
		try{
			return shopMenuImageMapper.insert(t.getPath(), t.getShopMenuId())==1?true:false;
			
		}catch(Exception e){
			e.printStackTrace();
			log.error("exception detail: {}",e.getMessage());
			throw new RuntimeException("It can not insert in shopMenuImageDao.");
		}
		
	}
	@Override
	public int update(List<ShopMenuImage> list) {
		Objects.requireNonNull(list,"The argumen should not null in shopMenuImageDao.");
		count=new AtomicInteger(0);
		list.stream().forEach(x->{
			if(this.update(x))
				count.getAndIncrement();
		});
		return count.get();
	}
	@Override
	public boolean update(ShopMenuImage t) {
		Objects.requireNonNull(t,"The argument ShopMenuImage should be assignment but not found");
		Objects.requireNonNull(t.getPath(), "The path of shopMenuImage should be assignment but not found.");
		Objects.requireNonNull(t.getShopMenuId(), "The shopMenuId of shopMenuImage should be assignment but not found.");
		try{
			
			return shopMenuImageMapper.update(t.getPath(), t.getShopMenuId(), t.getId())==1?true:false;
		}catch(Exception e){
			e.printStackTrace();
			log.error("exception detail: {}",e.getMessage());
			throw new RuntimeException("It can not update in shopMenuImageDao.");
		}
	}
	
	public int deleteByShopMenuId(ShopMenuImage t){
		Objects.requireNonNull(t,"The argument shouldMenuIamge should be assignment but not found");
		try{
			return shopMenuImageMapper.deleteByShopImageMenuId(t.getShopMenuId());
		}catch(Exception e){
			e.printStackTrace();
			log.error("exception detail: {}",e.getMessage());
			throw new RuntimeException("It can not delete in shopMenuImageDao");
		}
	}
}
