package com.admin.bean;

import lombok.Data;

@Data
public class Departments {
    private Integer id;
    private String name;
    private Employees employees;
}
