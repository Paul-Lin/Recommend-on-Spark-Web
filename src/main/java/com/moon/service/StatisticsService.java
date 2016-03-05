package com.moon.service;

import com.moon.entity.impl.StatisticsBill;

import java.time.LocalDate;
import java.util.Set;

/**
 * Created by Administrator on 2016/1/10.
 */
public interface StatisticsService {
    public Set<StatisticsBill> querySaleSum(LocalDate start,LocalDate end);

}
