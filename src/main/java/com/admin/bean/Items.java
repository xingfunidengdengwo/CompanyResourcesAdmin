package com.admin.bean;

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

    public ItemTypes getItemTypes() {
        return itemTypes;
    }

    public void setItemTypes(ItemTypes itemTypes) {
        this.itemTypes = itemTypes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
