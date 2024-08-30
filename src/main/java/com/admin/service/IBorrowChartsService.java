package com.admin.service;

import com.admin.bean.BorrowCharts;

import java.util.List;

public interface IBorrowChartsService {
    List<BorrowCharts> getBorrowCharts(BorrowCharts borrowCharts);
}
