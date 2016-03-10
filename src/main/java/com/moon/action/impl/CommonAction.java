package com.moon.action.impl;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moon.action.Action;
import com.moon.common.AppConstant;
import com.moon.entity.impl.Customer;
import com.moon.entity.impl.PageResult;
import com.moon.entity.impl.Shop;
import com.moon.enums.ShopStatus;
import com.moon.enums.UserStatus;
import com.moon.service.impl.CustomerService;
import com.moon.service.impl.ShopService;

/**
 * Created by Administrator on 2015/12/14.
 */
@Controller
@RequestMapping(value = "common")
public class CommonAction extends Action {
	private static final long serialVersionUID = -2325688609806086821L;
	@Autowired
	private ShopService shopService;
	@Autowired
	private CustomerService customerService;
	private Shop shop;

	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request) {
		Customer customer = (Customer) request.getSession().getAttribute(AppConstant.CUSTOMER);
		ModelAndView view = new ModelAndView("common/index");
		view.addObject("customer", customer);
		return view;
	}

	@RequestMapping(value = "common/register")
	public ModelAndView register() {
		ModelAndView view = new ModelAndView("common/register");
		return view;
	}

	@RequestMapping("/user/login")
	@ResponseBody
	public PageResult login(@RequestParam("name") String nickname, @RequestParam("pass") String pass,
			HttpServletRequest request) {
		PageResult result = new PageResult();
		if (request.getSession().getAttribute(AppConstant.CUSTOMER) != null) {
			Customer customer = (Customer) request.getSession().getAttribute(AppConstant.CUSTOMER);
			result.setIsSuccess(true);
			result.setObject(customer);
			return result;
		}
		if (StringUtils.isBlank(nickname)) {
			result.setCode(UserStatus.valueOf(UserStatus.USER_LOGIN_ERROR_WITHOUT_NICKNAME));
			result.setIsSuccess(false);
			return result;
		}
		if (StringUtils.isBlank(pass)) {
			result.setCode(UserStatus.valueOf(UserStatus.USER_LOGIN_ERROR_WITHOUT_PASS));
			result.setIsSuccess(false);
			return result;
		}

		Optional<Customer> customer = customerService.retrieved(nickname, pass);
		if (customer.isPresent()) {
			request.getSession().setAttribute(AppConstant.CUSTOMER, customer.get());
			result.setObject(customer.get());
			result.setIsSuccess(true);
		}
		return result;
	}

	@RequestMapping(value = "registerShop")
	@ResponseBody
	public PageResult registerShop(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "pass", required = false) String pass,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "tel", required = false) String tel,
			@RequestParam(value = "boss", required = false) String boss,
			@RequestParam(value = "intro", required = false) String intro) {

		if (StringUtils.isBlank(name) || StringUtils.isBlank(pass)) {
			result.setIsSuccess(false);
			result.setCode(-1);
			result.setDesc("user's name or user's pass should be not null");
			return result;
		}
		shop = new Shop();
		shop.setName(name);
		shop.setPassword(pass);
		shop.setAddress(address);
		shop.setTel(tel);
		shop.setBoss(boss);
		shop.setIntro(intro);
		shopService.setShop(shop);
		ShopStatus status = shopService.register();
		if (status.of().equals(ShopStatus.EXIST.of())) {
			result.setCode(ShopStatus.EXIST.of());
			result.setIsSuccess(false);
		} else if (status.of().equals(ShopStatus.DISABLED.of())) {
			result.setCode(ShopStatus.DISABLED.of());
			result.setIsSuccess(false);
		} else if (status.of().equals(ShopStatus.ENABLED.of())) {
			result.setCode(ShopStatus.ENABLED.of());
			result.setIsSuccess(true);
		} else {
			result.setCode(ShopStatus.ERROR.of());
			result.setIsSuccess(false);
		}

		return result;
	}
}
