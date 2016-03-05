package com.moon.action.impl;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moon.action.Action;
import com.moon.common.AppConstant;
import com.moon.entity.impl.PageResult;
import com.moon.entity.impl.Shop;
import com.moon.entity.impl.ShopBill;
import com.moon.service.impl.ShopBillsService;

/**
 * Created by Administrator on 2016/1/16.
 */
@Controller
@RequestMapping("shopBills")
public class ShopBillsAction extends Action {
	private static final long serialVersionUID = 3694904687155021101L;

	private Logger log = LoggerFactory.getLogger(ShopBillsAction.class);
	@Autowired
	private ShopBillsService shopBillsService;

	@RequestMapping("list")
	@ResponseBody
	public PageResult list(HttpServletRequest request, @RequestParam(value = "offset", defaultValue = "0") int offset,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		PageResult pageResult = new PageResult();
		try {

			Shop shop = (Shop) request.getSession().getAttribute(AppConstant.SHOP);
			Objects.requireNonNull(shop, "shop should be login but not found.");
			List<ShopBill> bills = shopBillsService.queryByShopID(shop.getId(), offset, pageSize);
			pageResult.setObject(bills);
			pageResult.setIsSuccess(true);
			return pageResult;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			pageResult.setIsSuccess(false);
			return pageResult;
		}

	}

	@RequestMapping("insert")
	@ResponseBody
	public PageResult insert(HttpServletRequest request, HttpServletResponse response, @RequestParam("to") long to,
			@RequestParam("payNum") double payNum,@RequestParam("shopMenu")long shopMenu) {
		PageResult pageResult = new PageResult();
		try {
			Shop shop = (Shop) request.getSession().getAttribute(AppConstant.SHOP);
			Objects.requireNonNull(shop, "shop should be login but not found.");
			ShopBill shopBill = new ShopBill();
			shopBill.setFrom(shop.getId());
			shopBill.setTo(to);
			shopBill.setPayNum(payNum);
			shopBill.setCreateAt(new Date());
			shopBill.setShopMenu(shopMenu);
			shopBillsService.insert(shopBill);
			pageResult.setIsSuccess(true);
			return pageResult;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			pageResult.setIsSuccess(false);
			return pageResult;
		}
	}

	@RequestMapping("delete")
	@ResponseBody
	public PageResult delete(HttpServletRequest request, HttpServletResponse response,@RequestParam("id")long id) {
		PageResult pageResult = new PageResult();
		try {
			Shop shop = (Shop) request.getSession().getAttribute(AppConstant.SHOP);
			Objects.requireNonNull(shop, "shop should be login but not found.");
			
			ShopBill shopBill=new ShopBill();
			shopBill.setId(id);
			shopBill.setFrom(shop.getId());
			
			shopBillsService.delete(shopBill);
			pageResult.setIsSuccess(true);
			return pageResult;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			pageResult.setIsSuccess(false);
			return pageResult;
		}
	}

	@RequestMapping("update")
	@ResponseBody
	public PageResult update(HttpServletRequest request, HttpServletResponse response) {
		PageResult pageResult = new PageResult();
		try {
			Shop shop = (Shop) request.getSession().getAttribute(AppConstant.SHOP);
			Objects.requireNonNull(shop, "shop should be login but not found.");
			pageResult.setIsSuccess(true);
			return pageResult;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			pageResult.setIsSuccess(false);
			return pageResult;
		}
	}
}
