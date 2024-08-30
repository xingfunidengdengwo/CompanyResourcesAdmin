package com.admin.controller;

import com.admin.bean.BorrowCharts;
import com.admin.bean.MaintenanceCharts;
import com.admin.common.CommonResult;
import com.admin.service.IMaintenanceChartsService;
import com.admin.service.IMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class MaintenanceChartsController {
    @Autowired
    IMaintenanceChartsService maintenanceChartsService;
    @GetMapping("maintenancecharts")
    public CommonResult getMaintenanceCharts(MaintenanceCharts maintenanceCharts) {

        List<MaintenanceCharts> list = maintenanceChartsService.getMaintenanceCharts(maintenanceCharts);

        return CommonResult.success(list);
    }

}
