package com.admin.dao;

import com.admin.bean.Items;
import com.admin.util.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IItemsDao {
    int delItems(int id);

    int addItems(Items items);

    Items getItemsByID(int id);

    List<Items> getItems(@Param("items") Items items, @Param("page") Page page);

    int getCount(@Param("items") Items items);

    int editItems(Items items);

    List<Items> getItemsByName(String name);
}
