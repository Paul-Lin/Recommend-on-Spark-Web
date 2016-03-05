package com.moon.action.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moon.action.Action;
import com.moon.entity.impl.PageResult;
@RequestMapping("photo")
@Controller
public class PhotoAction extends Action{
	private static final long serialVersionUID = 8936899547868192317L;
	private Logger log=LoggerFactory.getLogger(PhotoAction.class);
	
	@RequestMapping("insert")
	@ResponseBody
	public PageResult insert(){
		PageResult result=new PageResult();
		return result;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public PageResult update(){
		PageResult result=new PageResult();
		return result;
	}
	
	@RequestMapping("query")
	@ResponseBody
	public PageResult query(){
		PageResult result=new PageResult();
		return result;
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public PageResult delete(){
		PageResult result=new PageResult();
		return result;
	}
	
}
