package com.moon.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moon.common.AppConstant;
import com.moon.common.MoonContext;
import com.moon.dao.impl.ShopDao;
import com.moon.entity.impl.Shop;
import com.moon.enums.ShopStatus;
import com.moon.service.MoonService;

/**
 * Created by Administrator on 2015/12/9.
 */
@Service("shopService")
@Transactional
public class ShopService implements MoonService{
	private static final long serialVersionUID = 1819766954799845950L;
	@Autowired
    private ShopDao shopDao;
    private Shop shop;

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Shop getShop() {
        return this.shop;
    }
    @SuppressWarnings("static-access")
	public ShopStatus login()
    {
        Objects.requireNonNull(this.shop,"shop property in ShopService should not be null");
        Shop temp= (Shop) shopDao.retrieved(shop);
        boolean flag=shop.equals(temp);
        if(flag==true){
            if(temp.getShopStatus()==null||temp.getShopStatus()==1) {
                MoonContext.getInstance().putShop(String.valueOf(temp.getId()), temp);
                this.shop=temp;
                this.shop.setPassword(AppConstant.PASSWORD);
                return ShopStatus.ENABLED;
            }else{
                return ShopStatus.DISABLED;
            }
        }
        return ShopStatus.NOT_EXIST;
    }

    public ShopStatus register() {
        Objects.requireNonNull(this.shop, "shop property in ShopService should not be null");
        Shop temp = (Shop) shopDao.retrieved(shop);
        if(Objects.isNull(temp)){
            shopDao.insert(this.shop);
            return ShopStatus.ENABLED;
        }
        boolean flag = shop.equals(temp);
        if (flag == true) {
            return ShopStatus.EXIST;
        }else{
            return ShopStatus.DISABLED;
        }
    }
}
