package com.admin.service.impl;

import com.admin.bean.ItemTypes;
import com.admin.dao.IItemTypesDao;
import com.admin.service.IItemTypesService;
import com.admin.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemTypesService implements IItemTypesService {
    @Autowired
    IItemTypesDao itemTypesDao;
    @Override
    public ItemTypes getItemTypesByID(int id) {
        return itemTypesDao.getItemTypesByID(id);
    }

    @Override
    public List<ItemTypes> getItemTypes(ItemTypes itemTypes, Page page) {
        return itemTypesDao.getItemTypes(itemTypes,page);
    }

    @Override
    public int getCount(ItemTypes itemTypes) {
        return itemTypesDao.getCount(itemTypes);
    }

    @Override
    public int editItemTypes(ItemTypes itemTypes) {
        int count = itemTypesDao.editItemTypes(itemTypes);
        return count;
    }

    @Override
    public int delItemTypes(int id) {
        int count = itemTypesDao.delItemTypes(id);
        return count;
    }



    @Override
    public int addItemTypes(ItemTypes itemTypes) {
        return itemTypesDao.addItemTypes(itemTypes);
    }
}
