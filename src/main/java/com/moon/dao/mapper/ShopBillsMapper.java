package com.moon.dao.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.moon.entity.impl.ShopBill;

/**
 * Created by Administrator on 2016/1/10.
 */
public interface ShopBillsMapper {
    @Select("select * from bill where bill_to=#{id} order by bill_create_at desc limit #{offset},#{pageSize}")
    @ResultMap("bill")
    public List<ShopBill> query(@Param("id")long shopId,@Param("offset")long offset,@Param("pageSize")int pageSize);

    @Update("update bill set status=#{status},bill_fk_shop_menu=#{menu},bill_pay_num=#{num} where bill_pk_id=#{id}")
    public int update(@Param("status")int status,@Param("menu")long menu,@Param("num")double num,@Param("id")long id);

    @Insert("insert into bill (bill_fk_shop_menu,bill_pay_num,bill_from,bill_to,bill_create_at,bill_status) values (#{menu},{#num},#{from},#{to},#{create_at},#{status})")
    public int insert(@Param("menu")long menu,@Param("num")double num,@Param("from")long from,@Param("to")long to,@Param("create_at")Date createAt,@Param("status")int status);

    @Delete("delete from bill where bill_pk_id=#{id}")
    public int delete(@Param("id")long id);
}
