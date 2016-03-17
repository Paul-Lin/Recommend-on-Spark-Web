package com.moon.action.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moon.action.Action;
import com.moon.entity.impl.PageResult;
import com.moon.enums.ShopMenu;
import com.moon.service.impl.ShopService;

/**
 * Created by Administrator on 2015/12/9.
 */
@Controller
@RequestMapping(value="/shop")
public class ShopAction extends Action {
	private static final long serialVersionUID = 326285203412367955L;
	@Autowired
    private ShopService shopService;
    @RequestMapping(value="url")
    public ModelAndView view(@RequestParam(value="path")String path){
        ModelAndView view=new ModelAndView(path);
        return view;
    }
    @RequestMapping(value="index")
    public ModelAndView index(@RequestParam(value="menu",defaultValue = "5")Integer menu){
        Map<String,Object> map=new ConcurrentHashMap<String,Object>();
        map.put("menu", ShopMenu.of(menu));
        ModelAndView view=new ModelAndView("shop/index",map);
        return view;
    }
   

    @RequestMapping(value="saleSum")
    @ResponseBody
    public PageResult saleSum(@RequestParam(value="start")String start,@RequestParam(value="end")String end){
        PageResult result=new PageResult();
//        LocalDate startDate=LocalDate.parse(start);
//        LocalDate endDate=LocalDate.parse(end);

        return result;
    }

}
