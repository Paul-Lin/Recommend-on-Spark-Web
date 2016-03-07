package com.moon.dao.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.moon.entity.impl.Customer;

public interface CustomerMapper {
	@Insert("INSERT INTO customer(customer_pass,customer_establish_time,customer_avatar,customer_sex,customer_nickname,customer_live_address,customer_logintime,customer_loginip,customer_signnature,customer_email,customer_phone) VALUES (#{pass},#{establish},#{avatar},#{sex},#{nickname},#{liveAddress},#{loginTime},#{loginIp},#{signnature},#{email},#{phone})")
	public int insert(@Param("pass") String pass, @Param("establish") Date establish,
			@Param("avatar") String avatar, @Param("sex") short sex, @Param("nickname") String nickname,
			@Param("liveAddress") String liveAddress, @Param("loginTime") Date date, @Param("loginIp") String loginIp,
			@Param("signnature") String signnature, @Param("email") String email, @Param("phone") String phone);
	
	@Update("UPDATE customer SET customer_pass=#{pass},customer_establish_time=#{establish},customer_avatar=#{avatar},customer_sex=#{sex},customer_nickname=#{nickname},customer_live_address=#{liveAddress},customer_logintime=#{loginTime},customer_loginip=#{loginIp},customer_signnature=#{signnature},customer_email=#{email},customer_phone=#{phone} WHERE customer_pk_id=#{id}")
	public int update(@Param("id") long id, @Param("pass") String pass, @Param("establish") Date establish,
			@Param("avatar") String avatar, @Param("sex") short sex, @Param("nickname") String nickname,
			@Param("liveAddress") String liveAddress, @Param("loginTime") Date date, @Param("loginIp") String loginIp,
			@Param("signnature") String signnature, @Param("email") String email, @Param("phone") String phone);
	
	@Select("SELECT * FROM customer WHERE customer_nickname=#{nickname} LIMIT #{offset},#{pageSize}")
	@ResultMap("customer")
	public List<Customer> retrieved(@Param("nickname")String nickname,@Param("offset")long offset,@Param("pageSize")int pageSize);

}
