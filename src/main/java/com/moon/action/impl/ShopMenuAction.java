package com.moon.action.impl;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.moon.action.Action;
import com.moon.common.AppConstant;
import com.moon.entity.dto.ShopMenuDto;
import com.moon.entity.impl.Customer;
import com.moon.entity.impl.PageResult;
import com.moon.entity.impl.ShopMenu;
import com.moon.kafka.MoonUserEventProducer;
import com.moon.service.impl.ShopMenuService;

@Controller
@RequestMapping("shopmenu")
public class ShopMenuAction extends Action {
	private static final long serialVersionUID = -7978968398167399162L;
	private Logger log = LoggerFactory.getLogger(ShopMenuAction.class);
	@Autowired
	private ShopMenuService shopMenuService;

	@RequestMapping("show-recommend")
	public ModelAndView show(@RequestParam("shopMenuId") long shopMenuId, HttpServletRequest request) {
		ModelAndView view = new ModelAndView("/recommend/index");
		ShopMenu menu = new ShopMenu();
		menu.setId(shopMenuId);
		view.addObject("shopmenu", shopMenuService.queryByShopMenuId(shopMenuId));

		Customer customer = (Customer) request.getSession().getAttribute(AppConstant.CUSTOMER);
		if (Objects.nonNull(customer))
			view.addObject("customer", customer);
		return view;
	}

	@RequestMapping("list")
	@ResponseBody
	public PageResult list(@RequestParam("shopId") long shopId, @RequestParam("offset") long offset,
			HttpServletRequest requeset, HttpServletResponse response) {
		PageResult result = new PageResult();
		try {
			List<ShopMenuDto> list = shopMenuService.queryByShopId(shopId, offset, AppConstant.PAGE);
			result.setObject(list);
			result.setPageSize(AppConstant.PAGE);
			result.setIsSuccess(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			result.setIsSuccess(false);
			return result;
		}
	}

	@RequestMapping("insert")
	@ResponseBody
	public PageResult insert(@RequestParam(value = "img", required = false) MultipartFile file,
			@RequestParam("name") String name, @RequestParam("intro") String intro,
			HttpServletRequest requeset, HttpServletResponse response) {
		PageResult result = new PageResult();
		try {
			result.setIsSuccess(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			result.setIsSuccess(false);
			return result;
		}
	}

	@RequestMapping("update")
	@ResponseBody
	public PageResult update(HttpServletRequest requeset, HttpServletResponse response) {
		PageResult result = new PageResult();
		try {
			result.setIsSuccess(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			result.setIsSuccess(false);
			return result;
		}
	}

	@RequestMapping("delete")
	@ResponseBody
	public PageResult delete(HttpServletRequest requeset, HttpServletResponse response) {
		PageResult result = new PageResult();
		try {
			result.setIsSuccess(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
			result.setIsSuccess(false);
			return result;
		}
	}

	@RequestMapping("queryByShopName")
	public ModelAndView queryShopName(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView();
		try {

		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}", e.getMessage());
		}
		return view;
	}
	
	@RequestMapping("queryByContent")
	public ModelAndView queryShopName(@RequestParam("content")String content,HttpServletRequest request,HttpServletResponse response){
		ModelAndView view=new ModelAndView("shop/index");
		if(StringUtils.isNotBlank(content)){
			
		}
		return view;
	}
	public PageResult viewShopMenu(@RequestParam("customerId")long customerId,@RequestParam("menuId")long menuId,@RequestParam("count")int count){
		PageResult result=new PageResult();
		try{
			MoonUserEventProducer producer=new MoonUserEventProducer();
			producer.sendMenuViewEvent(customerId, menuId, count);
		}catch(Exception e){
			e.printStackTrace();
			result.setIsSuccess(false);
		}
		return result;
	}
}
