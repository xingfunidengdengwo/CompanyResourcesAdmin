package com.admin.service;

import com.admin.bean.BorrowReturn;
import com.admin.util.Page;

import java.util.List;

public interface IBorrowReturnService {

    int addBorrowReturn(BorrowReturn borrowReturn);

    BorrowReturn getBorrowReturnByID(int id);

    List<BorrowReturn> getBorrowReturn(BorrowReturn borrowReturn, Page page);

    int getCount(BorrowReturn borrowReturn);

    int editBorrowReturn(BorrowReturn borrowReturn);

    int delBorrowReturn(int id);

    List<BorrowReturn> getUnreturned(BorrowReturn borrowReturn, Page page);

    int getCountUnreturned(BorrowReturn borrowReturn);
}
