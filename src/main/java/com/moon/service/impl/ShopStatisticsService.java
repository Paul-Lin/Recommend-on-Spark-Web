package com.moon.service.impl;

import com.moon.entity.impl.StatisticsBill;
import com.moon.service.StatisticsService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/1/10.
 */
@Service("shopStatisticsService")
public class ShopStatisticsService implements StatisticsService{
    @Override
    public Set<StatisticsBill> querySaleSum(LocalDate start, LocalDate end) {
        Set<StatisticsBill> bills=new LinkedHashSet<StatisticsBill>();

        return bills;
    }
}
