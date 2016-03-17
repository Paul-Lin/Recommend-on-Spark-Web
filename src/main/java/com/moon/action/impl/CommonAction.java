package com.moon.action.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.esotericsoftware.minlog.Log;
import com.moon.action.Action;
import com.moon.common.AppConstant;
import com.moon.entity.dto.RecommendMenuDto;
import com.moon.entity.dto.ShopDto;
import com.moon.entity.impl.Customer;
import com.moon.entity.impl.PageResult;
import com.moon.entity.impl.Shop;
import com.moon.enums.ShopMenu;
import com.moon.enums.ShopStatus;
import com.moon.service.impl.CustomerService;
import com.moon.service.impl.ShopMenuImageService;
import com.moon.service.impl.ShopMenuService;
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
	@Autowired
	private ShopMenuImageService shopMenuImageService;
	@Autowired
	private ShopMenuService shopMenuService;
	private Shop shop;

	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request) {
		Customer customer = (Customer) request.getSession().getAttribute(AppConstant.CUSTOMER);
		ModelAndView view = new ModelAndView("common/index");
		view.addObject("customer", customer);
		if(Objects.nonNull(customer)){
			List<RecommendMenuDto> list = shopMenuImageService.recommendShopMenu(customer.getId());
			view.addObject("list", list);
		}
		return view;
	}

	@RequestMapping(value = "common/register")
	public ModelAndView register() {
		ModelAndView view = new ModelAndView("common/register");
		return view;
	}
	@RequestMapping(value="shop/login")
	public ModelAndView login(){
		ModelAndView view=new ModelAndView("shop/login");
		return view;
	}
	
	@RequestMapping(value="shop/do-login")
	public ModelAndView doLogin(HttpServletRequest request,@RequestParam("nickname")String nickname,@RequestParam("password")String password){
		ModelAndView view=null;
		if(StringUtils.isNotBlank(nickname)&&StringUtils.isNotBlank(password)){
			if(shopService.login(nickname, password)){
				view=new ModelAndView("shop/index");
				view.addObject("menu", ShopMenu.MENU_MANAGE);
				view.addObject("title","菜单管理");
			}
			else
				view=new ModelAndView("shop/login");
		}else{
			view=new ModelAndView("shop/login");
		}
		return view;
	}
	@RequestMapping("/customer/login")
	public ModelAndView login(@RequestParam("name") String nickname, @RequestParam("pass") String pass,
			HttpServletRequest request) {
		ModelAndView view = new ModelAndView("common/index");
		if (StringUtils.isNotBlank(nickname) && StringUtils.isNotBlank(pass)) {
			Optional<Customer> customer = customerService.retrieved(nickname, pass);
			if (customer.isPresent()) {
				request.getSession().setAttribute(AppConstant.CUSTOMER, customer.get());
				List<RecommendMenuDto> list = shopMenuImageService.recommendShopMenu(customer.get().getId());
				view.addObject("list", list);
				view.addObject("customer", customer.get());
			}

		}
		return view;
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
		ShopStatus status = shopService.register(shop);
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
	
	@RequestMapping("show-shop")
	public ModelAndView showShop(@RequestParam("shopId")long shopId,@RequestParam(value="offset",defaultValue="0",required=false)long offset,HttpServletRequest request){
		ModelAndView view=new ModelAndView("/shop/show-shop");
		try{
			ShopDto dto=new ShopDto();
			dto.setShop(shopService.queryByShopId(shopId));
			dto.setList(shopMenuService.query(shopId, offset, AppConstant.PAGE));
		}catch(Exception e){
			e.printStackTrace();
			Log.error("exception detail: {}",e.getMessage());
		}
		view.addObject("customer",request.getSession().getAttribute(AppConstant.CUSTOMER));
		return view;
	}
}
