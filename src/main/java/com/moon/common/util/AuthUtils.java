package com.moon.common.util;

import java.util.Objects;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moon.common.AppConstant;
import com.moon.entity.impl.Customer;
import com.moon.entity.impl.Shop;


public final class AuthUtils {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private static AuthUtils utils=new AuthUtils();
	private AuthUtils(){
		
	}
	
	public static AuthUtils newInstance(){
		if(Objects.isNull(utils))
			utils=new AuthUtils();
		return utils;
	}
	
	
	public HttpServletRequest getRequest(){
		return this.request;
	}
	
	public HttpServletResponse getResponse(){
		return this.response;
	}
	
	public Optional<Shop> getShop(){
		return  (Optional<Shop>) Optional.of((Shop)request.getSession().getAttribute(AppConstant.SHOP));
	}
	public Optional<Customer> getCustomer(){
		return (Optional<Customer>) Optional.of((Customer)request.getSession().getAttribute(AppConstant.CUSTOMER));
	}
}
