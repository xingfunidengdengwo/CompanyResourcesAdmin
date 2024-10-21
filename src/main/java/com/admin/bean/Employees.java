package com.admin.bean;

import lombok.Data;

@Data
public class Employees {
    private Integer id;
    private String name;
    private Integer departmentId;
    private Departments departments;
}
