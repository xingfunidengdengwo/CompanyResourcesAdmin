package com.admin.service.impl;

import com.admin.bean.Items;
import com.admin.dao.IItemsDao;
import com.admin.service.IItemsService;
import com.admin.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsService implements IItemsService {
    @Autowired
    IItemsDao itemsDao;

    @Override
    public Items getItemsByID(int id) {
        return itemsDao.getItemsByID(id);
    }

    @Override
    public List<Items> getItems(Items items, Page page) {
        return itemsDao.getItems(items, page);
    }

    @Override
    public int getCount(Items items) {
        return itemsDao.getCount(items);
    }

    @Override
    public int editItems(Items items) {
        int count = 0;
        if (getItemsByID(items.getId()).getName().equals(items.getName())) {
           return itemsDao.editItems(items);
        } else {
            List<Items> list = itemsDao.getItemsByName(items.getName());
            if (list.size() == 0) {
                count = itemsDao.editItems(items);
                return count;
            } else {
                return 0;
            }
        }
    }

    @Override
    public int delItems(int id) {
        int count = itemsDao.delItems(id);
        return count;
    }


    @Override
    public int addItems(Items items) {
        List<Items> list = itemsDao.getItemsByName(items.getName());
        if (list.size() == 0) {
            itemsDao.addItems(items);
            return 1;
        }else{
            return 0;
        }
    }
}
