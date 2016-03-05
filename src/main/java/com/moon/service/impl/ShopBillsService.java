package com.moon.service.impl;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.dao.impl.ShopBillsDao;
import com.moon.entity.impl.ShopBill;
import com.moon.service.MoonService;

/**
 * Created by Administrator on 2016/1/16.
 */
@Service("shopBillsService")
public class ShopBillsService implements MoonService {
	private static final long serialVersionUID = -3854180569919976857L;
	private Logger log = LoggerFactory.getLogger(ShopBillsService.class);
	@Autowired
	private ShopBillsDao shopBillsDao;

	public List<ShopBill> queryByShopID(long shopId, long pageOffset, int pageSize) {
		try {
			Objects.requireNonNull(shopId, "shop id should not be null");
			ShopBill shopBill = new ShopBill();
			shopBill.setTo(shopId);
			@SuppressWarnings("unchecked")
			List<ShopBill> bills = (List<ShopBill>) shopBillsDao.retrieved(shopBill, pageOffset, pageSize);
			return bills;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			throw new RuntimeException("It can not query by shop id");
		}

	}

	public boolean insert(ShopBill shopBill) {
		try {
			return shopBillsDao.insert(shopBill);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			throw new RuntimeException("It can not insert in ShopBillsService");
		}
	}

	public boolean update(ShopBill shopBill) {
		try {
			return shopBillsDao.update(shopBill);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			throw new RuntimeException("It can not update in ShopBillsService");
		}
	}

	public int update(List<ShopBill> list) {
		try {
			return shopBillsDao.update(list);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			throw new RuntimeException("It can not batch update in ShopBillsService");
		}
	}

	public boolean delete(ShopBill shopBill) {
		try {
			return shopBillsDao.delete(shopBill);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			throw new RuntimeException("It can not batch update in ShopBillsService");
		}
	}

	public int delete(List<ShopBill> list) {
		try {
			return shopBillsDao.delete(list);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			throw new RuntimeException("It can not batch delete in ShopBillsService");
		}
	}
}
