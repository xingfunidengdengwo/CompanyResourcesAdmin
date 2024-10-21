package com.admin.controller;

import com.admin.bean.Items;
import com.admin.common.CommonResult;
import com.admin.service.IItemsService;
import com.admin.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class ItemsController {
    @Autowired
    IItemsService itemsService;

    //增加
    @PostMapping("items")
    public CommonResult addItems(@RequestBody Items items) {
        int result = itemsService.addItems(items);
        if (result == 1) {
            items = itemsService.getItemsByID(items.getId());
            return CommonResult.success(items);
        } else {
            return CommonResult.fail(400, "物品已存在");
        }
    }

    //分页模糊查询
    @GetMapping("items")
    public CommonResult getItems(Items items, Page page) {
        List<Items> list = itemsService.getItems(items, page);
        int count = itemsService.getCount(items);
        HashMap map = new HashMap();
        map.put("list", list);
        map.put("count", count);
        return CommonResult.success(map);
    }


    //修改
    @PutMapping("items")
    public CommonResult editItems(@RequestBody Items items) {
        int count = itemsService.editItems(items);
        if (count == 1) {
            items = itemsService.getItemsByID(items.getId());
            return CommonResult.success(items);
        } else {
            return CommonResult.fail(400, "物品已存在");
        }
    }

    //删除
    @DeleteMapping("items/{id}")
    public CommonResult delItems(@PathVariable int id) {
        int count = itemsService.delItems(id);
        if (count > 0) {
            return CommonResult.success();
        } else {
            return CommonResult.fail();
        }
    }
}
