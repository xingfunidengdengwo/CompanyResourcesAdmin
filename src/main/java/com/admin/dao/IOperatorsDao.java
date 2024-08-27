package com.admin.dao;

import com.admin.bean.Operators;
import com.admin.util.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IOperatorsDao {
    int delOperators(int id) ;

    int addOperators(Operators operators);

    Operators getOperatorsByID(int id);

    List<Operators> getOperators(@Param("operators") Operators operators, @Param("page") Page page);

    int getCount(@Param("operators") Operators operators);

    int editOperators(Operators operators);

    List<Operators> getOperatorsByName(String name);

    void updatePassword(Operators operators);
}
