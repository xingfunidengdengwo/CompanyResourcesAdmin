package com.admin.controller;

import com.admin.bean.Maintenance;
import com.admin.common.CommonResult;
import com.admin.service.IMaintenanceService;
import com.admin.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class MaintenanceController {

    @Autowired
    IMaintenanceService maintenanceService;
    //增加
    @PostMapping("maintenance")
    public CommonResult addMaintenance(@RequestBody Maintenance maintenance) {
        maintenanceService.addMaintenance(maintenance);
        maintenance = maintenanceService.getMaintenanceByID(maintenance.getId());
        return CommonResult.success(maintenance);
    }

    //分页模糊查询
    @GetMapping("maintenance")
    public CommonResult getMaintenance(Maintenance maintenance, Page page) {
        List<Maintenance> list = maintenanceService.getMaintenance(maintenance, page);
        int count = maintenanceService.getCount(maintenance);
        HashMap map = new HashMap();
        map.put("list", list);
        map.put("count", count);
        return CommonResult.success(map);
    }


    //修改
    @PutMapping("maintenance")
    public CommonResult editMaintenance(@RequestBody Maintenance maintenance) {
        int count = maintenanceService.editMaintenance(maintenance);
        maintenance = maintenanceService.getMaintenanceByID(maintenance.getId());
        return CommonResult.success(maintenance);
    }

    //删除
    @DeleteMapping("maintenance/{id}")
    public CommonResult delMaintenance(@PathVariable int id) {
        int count = maintenanceService.delMaintenance(id);
        if (count > 0) {
            return CommonResult.success();
        } else {
            return CommonResult.fail();
        }
    }
}
