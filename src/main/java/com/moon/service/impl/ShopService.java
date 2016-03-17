package com.moon.service.impl;

import java.util.Objects;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moon.dao.impl.ShopDao;
import com.moon.entity.impl.Shop;
import com.moon.enums.ShopStatus;
import com.moon.service.MoonService;

/**
 * Created by Administrator on 2015/12/9.
 */
@Service("shopService")
@Transactional
public class ShopService implements MoonService {
	private static final long serialVersionUID = 1819766954799845950L;
	private static final Logger log = LoggerFactory.getLogger(ShopService.class);
	@Autowired
	private ShopDao shopDao;

	public Optional<Shop> queryByName(String nickname) {
		Shop shop = new Shop();
		shop.setName(nickname);
		return Optional.of((Shop) shopDao.retrieved(shop));
	}

	public boolean login(String nickname, String password) {
		Shop shop = new Shop();
		if (StringUtils.isNotBlank(nickname))
			shop.setName(nickname);
		if (StringUtils.isNotBlank(password))
			shop.setPassword(password);
		return Objects.nonNull(shopDao.retrieved(shop)) ? true : false;

	}

	public ShopStatus register(Shop shop) {

		Objects.requireNonNull(shop, "shop property in ShopService should not be null");
		Shop temp = (Shop) shopDao.retrieved(shop);
		if (Objects.isNull(temp)) {
			shopDao.insert(shop);
			return ShopStatus.ENABLED;
		}
		boolean flag = shop.equals(temp);
		if (flag == true) {
			return ShopStatus.EXIST;
		} else {
			return ShopStatus.DISABLED;
		}
	}

	public Shop queryByShopId(long shopId) {
		try {
			Shop t = new Shop();
			t.setId(shopId);
			return shopDao.retrievedByShopId(t).orElseThrow(NullPointerException::new);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			throw new RuntimeException("It can not query by shopid in shop service.");
		}
	}
}
