package com.admin.service;

import com.admin.bean.Departments;
import com.admin.util.Page;

import java.util.List;

public interface IDepartmentsService {
    int addDepartments(Departments departments);

    Departments getDepartmentsByID(int id);

    List<Departments> getDepartments(Departments departments, Page page);

    int getCount(Departments departments);

    int editDepartments(Departments departments);

    int delDepartments(int id);

    int getEmployeesByDepartmentId(int id);
}
