package com.moon.dao.mapper;

import java.util.Date;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.moon.entity.impl.StatisticsBill;

/**
 * Created by Administrator on 2016/1/10.
 */
public interface StatisticsBillsMapper{
   @Select("")
    public Set<StatisticsBill> retrievedByDate(@Param("start")Date start,@Param("end")Date end,@Param("shopid")String id);
}
