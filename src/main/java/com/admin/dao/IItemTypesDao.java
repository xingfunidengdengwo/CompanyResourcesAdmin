package com.admin.dao;

import com.admin.bean.ItemTypes;
import com.admin.util.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IItemTypesDao {
    int delItemTypes(int id);

    int addItemTypes(ItemTypes itemTypes);

    ItemTypes getItemTypesByID(int id);

    List<ItemTypes> getItemTypes(@Param("itemTypes") ItemTypes itemTypes, @Param("page") Page page);

    int getCount(@Param("itemTypes") ItemTypes itemTypes);

    int editItemTypes(ItemTypes itemTypes);

    List<ItemTypes> getItemTypesByName(String name);

    int getItemsByItemTypeID(int id);
}
