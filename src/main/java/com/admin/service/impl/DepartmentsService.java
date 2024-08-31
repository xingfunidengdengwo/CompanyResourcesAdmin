package com.admin.service.impl;

import com.admin.bean.Departments;
import com.admin.dao.IDepartmentsDao;
import com.admin.service.IDepartmentsService;
import com.admin.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentsService implements IDepartmentsService {
    @Autowired
    IDepartmentsDao departmentsDao;

    @Override
    public Departments getDepartmentsByID(int id) {
        return departmentsDao.getDepartmentsByID(id);
    }

    @Override
    public List<Departments> getDepartments(Departments departments, Page page) {
        return departmentsDao.getDepartments(departments,page);
    }

    @Override
    public int getCount(Departments departments) {
        return departmentsDao.getCount(departments);
    }

    @Override
    public int editDepartments(Departments departments) {
        List<Departments> list=departmentsDao.getDepartmentsByName(departments.getName());
        if(list.size()==0){
            int count=0;
            count = departmentsDao.editDepartments(departments);
            return count;
        }else {
            return 0;
        }
    }

    @Override
    public int delDepartments(int id) {
        int count = departmentsDao.delDepartments(id);
        return count;
    }

    @Override
    public int getEmployeesByDepartmentId(int id) {
       int result= departmentsDao.getEmployeesByDepartmentId(id);
        System.out.println("当前部门人数"+result);
       return result;
    }


    @Override
    public int addDepartments(Departments departments) {
        List<Departments> list=departmentsDao.getDepartmentsByName(departments.getName());
        System.out.println(list);
        if(list.size()==0){
            departmentsDao.addDepartments(departments);
            return 1;
        }else {
            return 0;
        }
    }
}
