package com.admin.bean;

import lombok.Data;

@Data
public class Items {
    private Integer id;
    private Integer code;
    private String name;
    private Integer typeId;
    private String status;
    private ItemTypes itemTypes;

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", typeId=" + typeId +
                ", status='" + status + '\'' +
                ", itemTypes=" + itemTypes +
                '}';
    }

}
