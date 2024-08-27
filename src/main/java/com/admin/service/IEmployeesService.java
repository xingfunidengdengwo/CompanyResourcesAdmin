package com.admin.service;

import com.admin.bean.Employees;
import com.admin.util.Page;

import java.util.List;

public interface IEmployeesService {
    int addEmployees(Employees employees);

    Employees getEmployeesByID(int id);

    List<Employees> getEmployees(Employees employees, Page page);

    int getCount(Employees employees);

    int editEmployees(Employees employees);

    int delEmployees(int id);


}
