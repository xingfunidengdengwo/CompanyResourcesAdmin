package com.admin.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
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

}
