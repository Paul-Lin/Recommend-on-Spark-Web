package com.moon.dao.impl;

import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moon.dao.Dao;
import com.moon.dao.Retrieved;
import com.moon.dao.mapper.ShopMapper;
import com.moon.entity.MoonEntity;
import com.moon.entity.impl.Shop;

@Repository("shopDao")
public class ShopDao  implements Retrieved<Shop>,  Dao<Shop>{
    @Autowired
    private ShopMapper mapper;
    private int num = 0;

    @Override
    public List<? extends MoonEntity> retrievedByShopMenuId(Shop t, Long offset, Integer pageSize) {
        return mapper.retrieved(t.getName(), offset, pageSize);
    }

    @Override
    public MoonEntity retrieved(Shop shop) {
        if(Objects.nonNull(shop)){
            if(Objects.nonNull(shop.getName()))
                return mapper.retrievedByName(shop.getName());
            else
                throw new NullPointerException("shop name cannot be null");
        }
        else
            throw new NullPointerException("shop cannot be null");
    }

    @Override
    public int delete(List<Shop> list) {
        if(Objects.isNull(list))
            throw new NullPointerException("shop list to be delete cannot be null");
        list.stream().filter(x -> x.getName() != null).forEach(x ->
        {
            if (this.delete(x))
                num++;
        });
        return num;
    }

    @Override
    public boolean delete(Shop t) {
        if(Objects.isNull(t))
            throw new NullPointerException("shop to be delete cannot be null");
        if (t != null && StringUtils.isNotBlank(t.getName())) {
            
            return mapper.delete(t.getName())==1?true:false;
        }
        return false;
    }

    @Override
    public int insert(List<Shop> list) {
        if(Objects.isNull(list))
            throw new NullPointerException("shop list to be insert cannot be null");
        num = 0;
        list.stream().forEach(x ->
        {
            if (this.insert(x))
                num++;
        });
        return num;
    }

    @Override
    public boolean insert(Shop t) {
        if(Objects.isNull(t))
            throw new NullPointerException("shop to be insert cannot be null");
        if (t != null) {
            return mapper.insert( t.getName(), t.getAddress(), t.getTel(), t.getBoss(), t.getIntro(), t.getEstablishTime(), t.getPassword(),t.getShopStatus())==1?true:false;

        }
        return false;
    }

    @Override
    public int update(List<Shop> list) {
        if(Objects.isNull(list))
            throw new NullPointerException("shop list to be update cannot be null");
        num = 0;
        list.stream().forEach(x ->
                {
                    if (update(x))
                        num++;
                }
        );
        return num;
    }

    @Override
    public boolean update(Shop t) {
        if(Objects.isNull(t))
            throw new NullPointerException("shop to be insert cannot be null");
        if (t != null) {
            return mapper.update(t.getId(), t.getName(), t.getAddress(), t.getTel(), t.getBoss(), t.getIntro(), t.getEstablishTime(), t.getPassword(), t.getName(),t.getShopStatus())==1?true:false;
        }
        return false;
    }

}
