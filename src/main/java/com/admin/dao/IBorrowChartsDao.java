package com.admin.dao;

import com.admin.bean.BorrowCharts;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IBorrowChartsDao {
    List<BorrowCharts> getBorrowCharts(BorrowCharts borrowCharts);
}
