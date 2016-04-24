package com.moon.interceptor;

import java.lang.reflect.Field;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.moon.common.util.AuthUtils;
import com.moon.entity.impl.Shop;

public class OnlineShopInterceptor implements HandlerInterceptor {
	private Logger log = LoggerFactory.getLogger(OnlineShopInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		@SuppressWarnings("unchecked")
		Class<AuthUtils> clazz = (Class<AuthUtils>) Class.forName(AuthUtils.class.getName());
		
		{
			Field field = clazz.getDeclaredField("request");
			boolean flag = field.isAccessible();
			field.setAccessible(true);
			field.set(AuthUtils.newInstance(), request);
			field.setAccessible(flag);
		}
		
		{
			Field field = clazz.getDeclaredField("response");
			boolean flag = field.isAccessible();
			field.setAccessible(true);
			field.set(AuthUtils.newInstance(), response);
			field.setAccessible(flag);
		}
		
		Shop shop = AuthUtils.newInstance().getShop().get();

		if (Objects.isNull(shop)) {
			request.getRequestDispatcher("/common/shop/login.action").forward(request, response);
			log.info("shop detail: {} try to login in,but failed...", request.getRemoteAddr());
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
