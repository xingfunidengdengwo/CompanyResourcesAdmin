package com.admin.service.impl;

import com.admin.bean.Employees;
import com.admin.dao.IEmployeesDao;
import com.admin.service.IEmployeesService;
import com.admin.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesService implements IEmployeesService {
    @Autowired
    IEmployeesDao employeesDao;
    @Override
    public Employees getEmployeesByID(int id) {
        return employeesDao.getEmployeesByID(id);
    }

    @Override
    public List<Employees> getEmployees(Employees employees, Page page) {
        return employeesDao.getEmployees(employees,page);
    }

    @Override
    public int getCount(Employees employees) {
        return employeesDao.getCount(employees);
    }

    @Override
    public int editEmployees(Employees employees) {
        int count = employeesDao.editEmployees(employees);
        return count;
    }

    @Override
    public int delEmployees(int id) {
        int count = employeesDao.delEmployees(id);
        return count;
    }



    @Override
    public int addEmployees(Employees employees) {
        return employeesDao.addEmployees(employees);
    }
}
