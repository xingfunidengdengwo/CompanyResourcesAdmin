package com.admin.dao;

import com.admin.bean.MaintenanceCharts;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IMaintenanceChartsDao {
    List<MaintenanceCharts> getMaintenanceCharts(MaintenanceCharts maintenanceCharts);

}
