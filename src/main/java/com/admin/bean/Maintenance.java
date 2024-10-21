package com.admin.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class Maintenance {
    private Integer id;
    private Integer itemId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endTime;
    private String description;
    private Items items;

    @Override
    public String toString() {
        return "Maintenance{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", description='" + description + '\'' +
                ", items=" + items +
                '}';
    }

}
