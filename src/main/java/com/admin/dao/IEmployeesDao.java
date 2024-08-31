package com.admin.dao;

import com.admin.bean.Employees;
import com.admin.util.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IEmployeesDao {
    int delEmployees(int id) ;

    int addEmployees(Employees employees);

    Employees getEmployeesByID(int id);

    List<Employees> getEmployees(@Param("employees") Employees employees, @Param("page") Page page);

    int getCount(@Param("employees") Employees employees);

    int editEmployees(Employees employees);

    List<Employees> getEmployeesByName(String name);
}
