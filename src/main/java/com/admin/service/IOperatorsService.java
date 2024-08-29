package com.admin.service;

import com.admin.bean.Operators;
import com.admin.util.Page;

import java.util.List;
import java.util.Map;

public interface IOperatorsService {
    int addOperators(Operators operators);

    Operators getOperatorsByID(int id);

    List<Operators> getOperators(Operators operators, Page page);

    int getCount(Operators operators);

    int editOperators(Operators operators);

    int delOperators(int id);

    Map<String, Object> doLogin(Operators operators);

    Operators getOperatorsByName(String name);

    boolean updatePassword(Operators operators);

    int operatorsImg(Operators operators);

    Operators getOperatorsByEmail(String email);
}
