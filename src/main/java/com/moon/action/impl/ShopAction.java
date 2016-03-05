package com.moon.action.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moon.action.Action;
import com.moon.common.AppConstant;
import com.moon.entity.impl.PageResult;
import com.moon.entity.impl.Shop;
import com.moon.enums.ShopMenu;
import com.moon.enums.ShopStatus;
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
    private Shop shop;
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
    @RequestMapping(value="/login")
    @ResponseBody
    public PageResult login(@RequestParam("name") String name, @RequestParam("pass") String pass,HttpServletRequest request,HttpServletResponse response) {
        if (StringUtils.isBlank(name) || StringUtils.isBlank(pass)) {
            result.setIsSuccess(false);
            result.setDesc("shop's name or shop's pass should be not null");
            return result;
        }
        shop = new Shop();
        shop.setName(name);
        shop.setPassword(pass);
        shopService.setShop(shop);
        ShopStatus status= shopService.login();
        if (status.of().equals(ShopStatus.ENABLED.of())) {
            shop = shopService.getShop();
            request.getSession().setAttribute(AppConstant.SHOP,shop);
            result.setCode(ShopStatus.ENABLED.of());
            result.setIsSuccess(true);
        }
        else if(status.of().equals(ShopStatus.DISABLED.of()))
        {
            result.setIsSuccess(false);
            result.setCode(ShopStatus.DISABLED.of());
            result.setDesc("sorry,you account had disabled.please contact the moon plan.");
        }else{
            result.setIsSuccess(false);
            result.setCode(ShopStatus.NOT_EXIST.of());
            result.setDesc("sorry,you account never occur the moon.you can register that.");
        }
        return result;
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
