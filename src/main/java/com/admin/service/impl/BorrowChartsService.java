package com.admin.service.impl;

import com.admin.bean.BorrowCharts;
import com.admin.dao.IBorrowChartsDao;
import com.admin.service.IBorrowChartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowChartsService implements IBorrowChartsService {
    @Autowired
    IBorrowChartsDao borrowChartsDao;

    @Override
    public List<BorrowCharts> getBorrowCharts(BorrowCharts borrowCharts) {

        return borrowChartsDao.getBorrowCharts(borrowCharts);
    }
}
