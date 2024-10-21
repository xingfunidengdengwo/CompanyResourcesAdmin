package com.admin.service.impl;

import com.admin.bean.MaintenanceCharts;
import com.admin.dao.IMaintenanceChartsDao;
import com.admin.service.IMaintenanceChartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceChartsService implements IMaintenanceChartsService {
    @Autowired
    IMaintenanceChartsDao maintenanceChartsDao;

    @Override
    public List<MaintenanceCharts> getMaintenanceCharts(MaintenanceCharts maintenanceCharts) {

        return maintenanceChartsDao.getMaintenanceCharts(maintenanceCharts);
    }
}
