package com.moon.interceptor;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.moon.common.AppConstant;
import com.moon.entity.impl.Customer;

/**
 * Created by Administrator on 2016/1/9.
 */
public class OnlineUserInterceptor implements HandlerInterceptor{
	private Logger log=LoggerFactory.getLogger(OnlineUserInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	Customer customer=(Customer) request.getSession().getAttribute(AppConstant.CUSTOMER);
    	
        if(Objects.isNull(customer)){
        	request.getRequestDispatcher("/").forward(request, response);
            log.debug("ip: "+request.getRemoteAddr()+" try to login but failed.");
        	return false;
        }
    	return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
