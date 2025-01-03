package com.admin.service.impl;

import com.admin.bean.Operators;
import com.admin.dao.IOperatorsDao;
import com.admin.service.IOperatorsService;
import com.admin.util.JWTUtil;
import com.admin.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OperatorsService implements IOperatorsService {
    @Autowired
    IOperatorsDao operatorsDao;

    @Override
    public Operators getOperatorsByID(int id) {
        return operatorsDao.getOperatorsByID(id);
    }

    @Override
    public List<Operators> getOperators(Operators operators, Page page) {
        return operatorsDao.getOperators(operators, page);
    }

    @Override
    public int getCount(Operators operators) {
        return operatorsDao.getCount(operators);
    }

    @Override
    public int editOperators(Operators operators) {
        int count = 0;
        System.out.println("原密码是" + operators.getOriginalPassword());
        if (getOperatorsByID(operators.getId()).getPassword().equals(operators.getOriginalPassword())) {
            if (getOperatorsByID(operators.getId()).getName().equals(operators.getName())) {
                return operatorsDao.editOperators(operators);
            } else {
                List<Operators> list = operatorsDao.getOperatorsByName(operators.getName());
                if (list.isEmpty()) {
                    count = operatorsDao.editOperators(operators);
                    return count;
                } else {
                    return count;
                }
            }
        } else {
            return count;
        }
    }


    @Override
    public int delOperators(int id) {
        int count = operatorsDao.delOperators(id);
        return count;
    }

    @Override
    public Map<String, Object> doLogin(Operators operators) {
        // 1.获取数据库中的数据 byname
        List<Operators> list = operatorsDao.getOperatorsByName(operators.getName());
        Map<String, Object> map = new HashMap<String, Object>();
        if (list.size() == 1) {
            Operators operators_data = list.get(0);
            // 2.比较密码
            boolean bool = eqPassword(operators.getPassword(), operators_data.getPassword());
            System.out.println("密码是否匹配" + bool);
            if (bool) {
                // 3.生成token
                String token = JWTUtil.createToken(null);
                map.put("token", token);
                map.put("operators", operators_data);
                System.out.println(operators_data);
                return map;
            }
        }
        return map;
    }

    @Override
    public Operators getOperatorsByName(String name) {
        int size = operatorsDao.getOperatorsByName(name).size();
        if (size > 0) {
            return operatorsDao.getOperatorsByName(name).get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean updatePassword(Operators operators) {
        List<Operators> list = operatorsDao.getOperatorsByName(operators.getName());
        Operators operators1 = list.get(0);
        if (operators1 == null) {
            return false;
        }
        operators.setPassword(operators.getNewPassword());
        operatorsDao.updatePassword(operators);
        return true;
    }

    @Override
    public int operatorsImg(Operators operators) {
        return operatorsDao.editOperators(operators);
    }

    @Override
    public Operators getOperatorsByEmail(String email) {
        int size = operatorsDao.getOperatorsByEmail(email).size();
        if (size > 0) {
            return operatorsDao.getOperatorsByEmail(email).get(0);
        } else {
            return null;
        }
    }

    private boolean eqPassword(String password, String password_data) {
        return password.equals(password_data);
    }

    @Override
    public int addOperators(Operators operators) {
        List<Operators> list = operatorsDao.getOperatorsByName(operators.getName());
        if (list.size() == 0) {
            operatorsDao.addOperators(operators);
            return 1;
        } else {
            return 0;
        }
    }
}
