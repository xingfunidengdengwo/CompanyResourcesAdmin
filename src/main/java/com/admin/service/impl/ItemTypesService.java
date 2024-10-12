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
        return itemTypesDao.getItemTypes(itemTypes, page);
    }

    @Override
    public int getCount(ItemTypes itemTypes) {
        return itemTypesDao.getCount(itemTypes);
    }

    @Override
    public int editItemTypes(ItemTypes itemTypes) {
        if (getItemTypesByID(itemTypes.getId()).getName().equals(itemTypes.getName())) {
            return itemTypesDao.editItemTypes(itemTypes);
        } else {
            List<ItemTypes> list = itemTypesDao.getItemTypesByName(itemTypes.getName());
            if (list.size() == 0) {
                int count = 0;
                count = itemTypesDao.editItemTypes(itemTypes);
                return count;
            } else {
                return 0;
            }
        }
    }

    @Override
    public int delItemTypes(int id) {
        int count = itemTypesDao.delItemTypes(id);
        return count;
    }

    @Override
    public int getItemsByItemTypeID(int id) {
        int result= itemTypesDao.getItemsByItemTypeID(id);
        System.out.println("当前分类物品数"+result);
        return result;
    }


    @Override
    public int addItemTypes(ItemTypes itemTypes) {
        List<ItemTypes> list = itemTypesDao.getItemTypesByName(itemTypes.getName());
        if (list.size() == 0) {
            itemTypesDao.addItemTypes(itemTypes);
            return 1;
        } else {
            return 0;
        }
    }
}
