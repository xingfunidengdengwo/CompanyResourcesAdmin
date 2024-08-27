package com.admin.controller;

import com.admin.bean.Employees;
import com.admin.common.CommonResult;
import com.admin.service.IEmployeesService;
import com.admin.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class EmployeesController {
    @Autowired
    IEmployeesService employeesService;
    //增加
    @PostMapping("employees")
    public CommonResult addEmployees(@RequestBody Employees employees) {
        employeesService.addEmployees(employees);
        employees = employeesService.getEmployeesByID(employees.getId());
        return CommonResult.success(employees);
    }

    //分页模糊查询
    @GetMapping("employees")
    public CommonResult getEmployees(Employees employees, Page page) {
        List<Employees> list = employeesService.getEmployees(employees, page);
        int count = employeesService.getCount(employees);
        HashMap map = new HashMap();
        map.put("list", list);
        map.put("count", count);
        return CommonResult.success(map);
    }


    //修改
    @PutMapping("employees")
    public CommonResult editEmployees(@RequestBody Employees employees) {
        int count = employeesService.editEmployees(employees);
        employees = employeesService.getEmployeesByID(employees.getId());
        return CommonResult.success(employees);
    }

    //删除
    @DeleteMapping("employees/{id}")
    public CommonResult delEmployees(@PathVariable int id) {
        int count = employeesService.delEmployees(id);
        if (count > 0) {
            return CommonResult.success();
        } else {
            return CommonResult.fail();
        }
    }
}
