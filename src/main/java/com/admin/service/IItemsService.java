package com.admin.service;

import com.admin.bean.Items;
import com.admin.util.Page;

import java.util.List;

public interface IItemsService {
    int addItems(Items items);

    Items getItemsByID(int id);

    List<Items> getItems(Items items, Page page);

    int getCount(Items items);

    int editItems(Items items);

    int delItems(int id);


}
