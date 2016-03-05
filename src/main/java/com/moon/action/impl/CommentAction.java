package com.moon.action.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moon.action.Action;
import com.moon.entity.impl.PageResult;
@Controller
@RequestMapping("comment")
public class CommentAction extends Action{
	private static final long serialVersionUID = -2315051728529756607L;
	private Logger log=LoggerFactory.getLogger(CommentAction.class);
	
	@RequestMapping("insert")
	@ResponseBody
	public PageResult insert(){
		
		return null;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public PageResult update(){
		return null;
	}
	
	@RequestMapping("query")
	@ResponseBody
	public PageResult query(){
		return null;
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public PageResult delete(){
		return null;
	}
}
