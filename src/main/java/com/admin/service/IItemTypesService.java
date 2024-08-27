package com.admin.service;

import com.admin.bean.ItemTypes;
import com.admin.util.Page;

import java.util.List;

public interface IItemTypesService {
    int addItemTypes(ItemTypes itemTypes);

    ItemTypes getItemTypesByID(int id);

    List<ItemTypes> getItemTypes(ItemTypes itemTypes, Page page);

    int getCount(ItemTypes itemTypes);

    int editItemTypes(ItemTypes itemTypes);

    int delItemTypes(int id);


}
