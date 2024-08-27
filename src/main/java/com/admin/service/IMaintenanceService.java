package com.admin.service;

import com.admin.bean.Maintenance;
import com.admin.util.Page;

import java.util.List;

public interface IMaintenanceService {
    int addMaintenance(Maintenance maintenance);

    Maintenance getMaintenanceByID(int id);

    List<Maintenance> getMaintenance(Maintenance maintenance, Page page);

    int getCount(Maintenance maintenance);

    int editMaintenance(Maintenance maintenance);

    int delMaintenance(int id);


}
