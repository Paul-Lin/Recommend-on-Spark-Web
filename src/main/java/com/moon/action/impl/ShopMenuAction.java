package com.moon.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moon.action.Action;
import com.moon.entity.impl.PageResult;

@RequestMapping("shopmenu")
public class ShopMenuAction extends Action {
	private static final long serialVersionUID = -7978968398167399162L;
	private Logger log = LoggerFactory.getLogger(ShopMenuAction.class);

	@RequestMapping("list")
	@ResponseBody
	public PageResult list(HttpServletRequest requeset, HttpServletResponse response) {
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
