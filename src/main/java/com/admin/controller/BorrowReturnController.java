package com.admin.controller;

import com.admin.bean.BorrowReturn;
import com.admin.common.CommonResult;
import com.admin.service.IBorrowReturnService;
import com.admin.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class BorrowReturnController {

    @Autowired
    IBorrowReturnService borrowReturnService;

    //增加
    @PostMapping("borrowreturn")
    public CommonResult addBorrowReturn(@RequestBody BorrowReturn borrowReturn) {
        borrowReturnService.addBorrowReturn(borrowReturn);
        borrowReturn = borrowReturnService.getBorrowReturnByID(borrowReturn.getId());
        return CommonResult.success(borrowReturn);
    }

    //分页模糊查询
    @GetMapping("borrowreturn")
    public CommonResult getBorrowReturn(BorrowReturn borrowReturn, Page page) {
        List<BorrowReturn> list = borrowReturnService.getBorrowReturn(borrowReturn, page);
        int count = borrowReturnService.getCount(borrowReturn);
        HashMap map = new HashMap();
        map.put("list", list);
        System.out.println(list);
        map.put("count", count);
        return CommonResult.success(map);
    }

    //查询所有未归还的记录
    @GetMapping("unreturned")
    public CommonResult getUnreturned(BorrowReturn borrowReturn,Page page) {
            List<BorrowReturn> list = borrowReturnService.getUnreturned(borrowReturn, page);
        int count = borrowReturnService.getCountUnreturned(borrowReturn);
        HashMap map = new HashMap();
        map.put("list", list);
        System.out.println(list);
        map.put("count", count);
        return CommonResult.success(map);
    }

    //修改
    @PutMapping("borrowreturn")
    public CommonResult editBorrowReturn(@RequestBody BorrowReturn borrowReturn) {
        int count = borrowReturnService.editBorrowReturn(borrowReturn);
        borrowReturn = borrowReturnService.getBorrowReturnByID(borrowReturn.getId());
        return CommonResult.success(borrowReturn);
    }

    //删除
    @DeleteMapping("borrowreturn/{id}")
    public CommonResult delBorrowReturn(@PathVariable int id) {
        int count = borrowReturnService.delBorrowReturn(id);
        if (count > 0) {
            return CommonResult.success();
        } else {
            return CommonResult.fail();
        }
    }

}
