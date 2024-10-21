package com.admin.dao;

import com.admin.bean.BorrowReturn;
import com.admin.util.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IBorrowReturnDao {
    int delBorrowReturn(int id);

    int addBorrowReturn(BorrowReturn borrowReturn);

    BorrowReturn getBorrowReturnByID(int id);

    List<BorrowReturn> getBorrowReturn(@Param("borrowReturn") BorrowReturn borrowReturn, @Param("page") Page page);

    int getCount(@Param("borrowReturn") BorrowReturn borrowReturn);

    int editBorrowReturn(BorrowReturn borrowReturn);

    List<BorrowReturn> getUnreturned(@Param("borrowReturn") BorrowReturn borrowReturn, @Param("page") Page page);

    int getCountUnreturned(@Param("borrowReturn") BorrowReturn borrowReturn);

    int getBorrowReturnIdByItemId(Integer id);
}
