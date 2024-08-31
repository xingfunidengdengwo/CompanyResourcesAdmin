package com.admin.dao;

import com.admin.bean.Departments;
import com.admin.util.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IDepartmentsDao {
    int delDepartments(int id) ;

    int addDepartments(Departments departments);

    Departments getDepartmentsByID(int id);

    List<Departments> getDepartments(@Param("departments") Departments departments, @Param("page") Page page);

    int getCount(@Param("departments") Departments departments);

    int editDepartments(Departments departments);

    int getEmployeesByDepartmentId(int id);

    List<Departments> getDepartmentsByName(String name);
}
