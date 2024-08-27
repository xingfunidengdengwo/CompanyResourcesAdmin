package com.admin.service.impl;

import com.admin.bean.Items;
import com.admin.bean.Maintenance;
import com.admin.dao.IItemsDao;
import com.admin.dao.IMaintenanceDao;
import com.admin.service.IMaintenanceService;
import com.admin.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MaintenanceService implements IMaintenanceService {
    @Autowired
    IMaintenanceDao maintenanceDao;
    @Autowired
    IItemsDao itemsDao;
    @Override
    public Maintenance getMaintenanceByID(int id) {
        return maintenanceDao.getMaintenanceByID(id);
    }

    @Override
    public List<Maintenance> getMaintenance(Maintenance maintenance, Page page) {
        return maintenanceDao.getMaintenance(maintenance,page);
    }

    @Override
    public int getCount(Maintenance maintenance) {
        return maintenanceDao.getCount(maintenance);
    }

    @Override
    @Transactional
    public int editMaintenance(Maintenance maintenance) {
        Items item = new Items();
        item.setId(maintenance.getItemId());
        item.setStatus("空闲");
        System.out.println(item);
        int result=itemsDao.editItems(item);
        int maintenanceId=maintenanceDao.getMaintenanceIdByItemId(item.getId());
        maintenance.setId(maintenanceId);
        System.out.println(maintenance);
        return maintenanceDao.editMaintenance(maintenance);
    }

    @Override
    public int delMaintenance(int id) {
        int count = maintenanceDao.delMaintenance(id);
        return count;
    }

    @Override
    @Transactional
    public int addMaintenance(Maintenance maintenance) {
        System.out.println(maintenance);
        Items item = new Items();
        item.setId(maintenance.getItemId());
        item.setStatus("维修");
        System.out.println(item);
        int result=itemsDao.editItems(item);
        return maintenanceDao.addMaintenance(maintenance);
    }
}
