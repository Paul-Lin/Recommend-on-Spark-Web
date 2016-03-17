package com.moon.dao.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.moon.entity.impl.Shop;

public interface ShopMapper {
    @Delete("DELETE FROM shop WHERE shop_name=#{name}")
    public int delete(@Param("name") String name);

    @Insert("INSERT INTO shop(shop_name,shop_address,shop_tel,shop_boss,shop_intro,shop_establish_time,shop_password,shop_status) VALUES (#{name},#{address},#{tel},#{boss},#{intro},#{establishTime},#{password},#{shopStatus})")
    public int insert( @Param("name") String name,
                       @Param("address") String address, @Param("tel") String tel,
                       @Param("boss") String boss, @Param("intro") String intro,
                       @Param("establishTime") Date establishTime,
                       @Param("password") String password, @Param("shopStatus") Integer shopStatus);

    @Select("SELECT * FROM shop WHERE shop_name LIKE #{name} LIMIT #{offset},#{pageSize}")
    @ResultMap("shop")
    public List<Shop> retrieved(@Param("name") String name,
                                @Param("offset") Long offset, @Param("pageSize") Integer pageSize);

    @Select("SELECT * FROM shop WHERE shop_name = #{name}")
    @ResultMap("shop")
    public Shop retrievedByName(@Param("name") String name);

    @Update("UPDATE shop SET shop_name=#{name},shop_address=#{address},shop_tel=#{tel},shop_boss=#{boss},shop_intro=#{intro},shop_establish_time=#{establishTime},shop_password=#{password}, shop_status=#{shopStatus} WHERE shop_name=#{shop_name}")
    public int update(@Param("id") long id, @Param("name") String name,
                       @Param("address") String address, @Param("tel") String tel,
                       @Param("boss") String boss, @Param("intro") String intro,
                       @Param("establishTime") Date date,
                       @Param("password") String password,
                       @Param("shop_name") String shopName, @Param("shopStatus") Integer shopStatus);
    @Select("SELECT * FROM shop where shop_pk_id=#{id}")
    @ResultMap("shop")
    public Shop retrievedByShopId(@Param("id")long id);
    
}
