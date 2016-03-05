package com.moon.action.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moon.action.Action;
import com.moon.entity.impl.PageResult;
@Controller
@RequestMapping("recommend")
public class RecommendAction extends Action {
	private static final long serialVersionUID = 3894612842983109403L;
	private Logger log=LoggerFactory.getLogger(RecommendAction.class);
	
	@RequestMapping("refresh")
	@ResponseBody
	public PageResult refresh(){
		PageResult result=new PageResult();
		return result;
	}
	
	@RequestMapping("index")
	@ResponseBody
	public PageResult index(){
		PageResult result=new PageResult();
		return result;
	}
}
