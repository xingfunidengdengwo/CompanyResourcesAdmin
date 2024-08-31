package com.admin.controller;


import com.admin.bean.Departments;
import com.admin.common.CommonResult;
import com.admin.service.IDepartmentsService;
import com.admin.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class DepartmentsController {

    @Autowired
    IDepartmentsService departmentsService;

    //增加
    @PostMapping("departments")
    public CommonResult addDepartments(@RequestBody Departments departments) {
        int result=departmentsService.addDepartments(departments);
        if(result==1){
        departments = departmentsService.getDepartmentsByID(departments.getId());
        return CommonResult.success(departments);
        }
        else {
            return CommonResult.fail(400,"部门已存在");
        }
    }

    //分页模糊查询
    @GetMapping("departments")
    public CommonResult getDepartments(Departments departments, Page page) {
        List<Departments> list = departmentsService.getDepartments(departments, page);
        int count = departmentsService.getCount(departments);
        HashMap map = new HashMap();
        map.put("list", list);
        map.put("count", count);
        return CommonResult.success(map);
    }


    //修改
    @PutMapping("departments")
    public CommonResult editDepartments(@RequestBody Departments departments) {
        int count = departmentsService.editDepartments(departments);
        if(count==1){
        departments = departmentsService.getDepartmentsByID(departments.getId());
        return CommonResult.success(departments);
        }else {
            return  CommonResult.fail(400,"部门已存在");
        }
    }

    //删除
    @DeleteMapping("departments/{id}")
    public CommonResult delDepartments(@PathVariable int id) {
        int result = departmentsService.getEmployeesByDepartmentId(id);
        if (result == 0) {
            int count = departmentsService.delDepartments(id);
            if (count > 0) {
                return CommonResult.success();
            } else {
                return CommonResult.fail();
            }
        }
        return CommonResult.fail(400, "部门下有员工不能删除");
    }

}
