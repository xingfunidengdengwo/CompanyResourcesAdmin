package com.admin.service.impl;

import com.admin.bean.BorrowReturn;
import com.admin.bean.Items;
import com.admin.dao.IBorrowReturnDao;
import com.admin.dao.IItemsDao;
import com.admin.service.IBorrowReturnService;
import com.admin.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class BorrowReturnService implements IBorrowReturnService {
    @Autowired
    IBorrowReturnDao borrowReturnDao;
    @Autowired
    IItemsDao itemsDao;
    @Override
    public BorrowReturn getBorrowReturnByID(int id) {
        return borrowReturnDao.getBorrowReturnByID(id);
    }

    @Override
    public List<BorrowReturn> getBorrowReturn(BorrowReturn borrowReturn, Page page) {
        return borrowReturnDao.getBorrowReturn(borrowReturn,page);
    }

    @Override
    public int getCount(BorrowReturn borrowReturn) {
        return borrowReturnDao.getCount(borrowReturn);
    }

    @Override
    @Transactional
    public int editBorrowReturn(BorrowReturn borrowReturn) {
        Items item = new Items();
        item.setId(borrowReturn.getItemId());
        item.setStatus("空闲");
        System.out.println(item);
        int result=itemsDao.editItems(item);
        int borrowReturnId=borrowReturnDao.getBorrowReturnIdByItemId(item.getId());
        borrowReturn.setId(borrowReturnId);
        System.out.println(borrowReturn);
        return borrowReturnDao.editBorrowReturn(borrowReturn);
    }

    @Override
    public int delBorrowReturn(int id) {
        int count = borrowReturnDao.delBorrowReturn(id);
        return count;
    }

    @Override
    public List<BorrowReturn> getUnreturned(BorrowReturn borrowReturn,Page page) {
        return borrowReturnDao.getUnreturned(borrowReturn,page);
    }

    @Override
    public int getCountUnreturned(BorrowReturn borrowReturn) {
        return borrowReturnDao.getCountUnreturned(borrowReturn);
    }

    @Override
    @Transactional
    public int addBorrowReturn(BorrowReturn borrowReturn) {
        Items item = new Items();
        item.setId(borrowReturn.getItemId());
        item.setStatus("借出");
        System.out.println(item.getId());
        int result=itemsDao.editItems(item);
        return borrowReturnDao.addBorrowReturn(borrowReturn);
    }
}
