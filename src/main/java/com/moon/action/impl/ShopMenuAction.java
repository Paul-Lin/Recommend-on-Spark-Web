package com.moon.action.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moon.action.Action;
import com.moon.common.AppConstant;
import com.moon.entity.dto.ShopMenuDto;
import com.moon.entity.impl.PageResult;
import com.moon.service.impl.ShopMenuService;

@RequestMapping("shopmenu")
public class ShopMenuAction extends Action {
	private static final long serialVersionUID = -7978968398167399162L;
	private Logger log = LoggerFactory.getLogger(ShopMenuAction.class);
	@Autowired
	private ShopMenuService shopMenuService;
	
	@RequestMapping("show-recommend")
	public ModelAndView show(@RequestParam("shopMenuId")long shopMenuId,HttpServletRequest request){
		ModelAndView view=new ModelAndView("recommend/show-recommend.jsp");
		
		return view;
	}
	
	@RequestMapping("list")
	@ResponseBody
	public PageResult list(@RequestParam("shopId")long shopId,@RequestParam("offset")long offset,HttpServletRequest requeset, HttpServletResponse response) {
		PageResult result = new PageResult();
		try {
			List<ShopMenuDto> list=shopMenuService.query(shopId, offset, AppConstant.PAGE);
			result.setObject(list);
			result.setPageSize(AppConstant.PAGE);
			result.setIsSuccess(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}",e.getMessage());
			result.setIsSuccess(false);
			return result;
		}
	}
	
	@RequestMapping("insert")
	@ResponseBody
	public PageResult insert(HttpServletRequest requeset, HttpServletResponse response) {
		PageResult result = new PageResult();
		try {
			result.setIsSuccess(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception detail: {}",e.getMessage());
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
			log.error("exception detail: {}",e.getMessage());
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
			log.error("exception detail: {}",e.getMessage());
			result.setIsSuccess(false);
			return result;
		}
	}
}
