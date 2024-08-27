package com.admin.dao;

import com.admin.bean.Maintenance;
import com.admin.util.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IMaintenanceDao {
    int delMaintenance(int id) ;

    int addMaintenance(Maintenance maintenance);

    Maintenance getMaintenanceByID(int id);

    List<Maintenance> getMaintenance(@Param("maintenance") Maintenance maintenance, @Param("page") Page page);

    int getCount(@Param("maintenance") Maintenance maintenance);

    int editMaintenance(Maintenance maintenance);

    int getMaintenanceIdByItemId(Integer id);
}
