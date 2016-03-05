package com.moon.action.impl;

import java.util.Date;
import java.util.Optional;

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
import com.moon.entity.impl.Customer;
import com.moon.entity.impl.PageResult;
import com.moon.enums.UserStatus;
import com.moon.service.impl.CustomerService;

@Controller
@RequestMapping("user")
public class CustomerAction extends Action {
	private static final long serialVersionUID = 3172032091259870486L;
	@Autowired
	private CustomerService customerService;

	@RequestMapping("index")
	public ModelAndView index() {
		return new ModelAndView("/index");
	}

	@RequestMapping("register")
	@ResponseBody
	public PageResult register(@RequestParam("email") String email, @RequestParam("nickname") String nickname,
			@RequestParam("pass") String pass, @RequestParam("phone") String phone, @RequestParam("sex") short sex,
			@RequestParam("liveAddress") String liveAddress, HttpServletRequest request, HttpServletResponse response) {
		PageResult result = new PageResult();
		if (StringUtils.isBlank(email)) {
			result.setCode(UserStatus.valueOf(UserStatus.USER_REGISTER_ERROR_WITHOUT_EMAIL));
			result.setIsSuccess(false);
			return result;
		}
		if (StringUtils.isBlank(nickname)) {
			result.setCode(UserStatus.valueOf(UserStatus.USER_REGISTER_ERROR_WITHOUT_NICKNAME));
			result.setIsSuccess(false);
			return result;
		}
		if (StringUtils.isBlank(pass)) {
			result.setCode(UserStatus.valueOf(UserStatus.USER_REGISTER_ERROR_WITHOUT_PASS));
			result.setIsSuccess(false);
			return result;
		}

		Customer customer = new Customer();
		customer.setEmail(email);
		customer.setNickname(nickname);
		customer.setPass(pass);
		customer.setPhone(phone);
		customer.setLiveAddress(liveAddress);
		customer.setSex(sex);
		customer.setLoginTime(new Date());
		customer.setEstablish(new Date());
		customer.setLoginIp(request.getRemoteAddr());
		result.setIsSuccess(customerService.insert(customer));
		if(result.isSuccess()){
			request.getSession().setAttribute(AppConstant.CUSTOMER, customer);
		}
		result.setCode(result.isSuccess() ? UserStatus.valueOf(UserStatus.USER_REGISTER_SUCCESS)
				: UserStatus.valueOf(UserStatus.USER_REGISTER_ERROR));
		return result;
	}

	@RequestMapping("login")
	@ResponseBody
	public PageResult login(@RequestParam("nickname") String nickname, @RequestParam("pass") String pass,HttpServletRequest request) {
		PageResult result=new  PageResult();
		if(StringUtils.isBlank(nickname)){
			result.setCode(UserStatus.valueOf(UserStatus.USER_LOGIN_ERROR_WITHOUT_NICKNAME));
			result.setIsSuccess(false);
			return result;
		}
		if(StringUtils.isBlank(pass)){
			result.setCode(UserStatus.valueOf(UserStatus.USER_LOGIN_ERROR_WITHOUT_PASS));
			result.setIsSuccess(false);
			return result;
		}
		Optional<Customer> customer=customerService.retrieved(nickname,pass);
		if(customer.isPresent()){
			request.getSession().setAttribute(AppConstant.CUSTOMER, customer.get());
			result.setIsSuccess(true);
		}
		return result;
	}

	@RequestMapping("logout")
	@ResponseBody
	public PageResult logout(@RequestParam("nickname")String nickname,@RequestParam("pass")String pass,HttpServletRequest request) {
		PageResult result=new PageResult();
		if(StringUtils.isBlank(nickname)){
			result.setCode(UserStatus.valueOf(UserStatus.USER_LOGIN_ERROR_WITHOUT_NICKNAME));
			result.setIsSuccess(false);
			return result;
		}
		if(StringUtils.isBlank(pass)){
			result.setCode(UserStatus.valueOf(UserStatus.USER_LOGIN_ERROR_WITHOUT_PASS));
		}
		Optional<Customer> customer=customerService.retrieved(nickname, pass);
		if(customer.isPresent()){
			request.getSession().removeAttribute(AppConstant.CUSTOMER);
			result.setIsSuccess(true);
		}
		return result;
	}

}
