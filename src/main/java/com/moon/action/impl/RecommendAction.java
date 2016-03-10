package com.moon.action.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moon.action.Action;
import com.moon.entity.dto.RecommendMenuDto;
import com.moon.entity.impl.PageResult;
import com.moon.service.impl.ShopMenuImageService;
@Controller
@RequestMapping("common/recommend")
public class RecommendAction extends Action {
	private static final long serialVersionUID = 3894612842983109403L;
	private Logger log=LoggerFactory.getLogger(RecommendAction.class);
	@Autowired
	private ShopMenuImageService shopMenuImageService;
	@RequestMapping("refresh-recommend-shop-menu")
	@ResponseBody
	public PageResult refresh(@RequestParam(value="customerId",defaultValue="0")long customerId){
		PageResult result=new PageResult();
		return result;
	}
	
	@RequestMapping("index")
	@ResponseBody
	public PageResult index(){
		PageResult result=new PageResult();
		return result;
	}
	
	@RequestMapping("recommend-shop-menu")
	@ResponseBody
	public PageResult recommendShopMenu(@RequestParam(value="customerId",defaultValue="0")long customerId){
		PageResult result=new PageResult();
		try{
			List<RecommendMenuDto> list=shopMenuImageService.recommendShopMenu(customerId);
			result.setObject(list);
			result.setIsSuccess(true);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			log.error("exception detail: {}",e.getMessage());
			result.setIsSuccess(false);
			return result;
		}
	}
}
