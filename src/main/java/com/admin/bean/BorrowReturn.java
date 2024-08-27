package com.admin.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public class BorrowReturn {
    private Integer id;
    private Integer itemId;
    private Integer operatorId;
    private Integer employeeId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate borrowTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expectedReturnTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate actualReturnTime;
    private Items items;
    private Operators operators;
    private Employees employees;

    public Operators getOperators() {
        return operators;
    }

    public void setOperators(Operators operators) {
        this.operators = operators;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "BorrowReturn{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", operatorId=" + operatorId +
                ", employeeId=" + employeeId +
                ", borrowTime=" + borrowTime +
                ", expectedReturnTime=" + expectedReturnTime +
                ", actualReturnTime=" + actualReturnTime +
                ", item=" + items +
                '}';
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items item) {
        this.items = item;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public LocalDate getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(LocalDate borrowTime) {
        this.borrowTime = borrowTime;
    }

    public LocalDate getExpectedReturnTime() {
        return expectedReturnTime;
    }

    public void setExpectedReturnTime(LocalDate expectedReturnTime) {
        this.expectedReturnTime = expectedReturnTime;
    }

    public LocalDate getActualReturnTime() {
        return actualReturnTime;
    }

    public void setActualReturnTime(LocalDate actualReturnTime) {
        this.actualReturnTime = actualReturnTime;
    }

}
