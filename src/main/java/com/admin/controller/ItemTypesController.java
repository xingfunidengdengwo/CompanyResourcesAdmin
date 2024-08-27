package com.admin.controller;

import com.admin.bean.ItemTypes;
import com.admin.common.CommonResult;
import com.admin.service.IItemTypesService;
import com.admin.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class ItemTypesController {
    @Autowired
    IItemTypesService itemTypesService;
    //增加
    @PostMapping("itemtypes")
    public CommonResult addItemTypes(@RequestBody ItemTypes itemTypes) {
        itemTypesService.addItemTypes(itemTypes);
        itemTypes = itemTypesService.getItemTypesByID(itemTypes.getId());
        return CommonResult.success(itemTypes);
    }

    //分页模糊查询
    @GetMapping("itemtypes")
    public CommonResult getItemTypes(ItemTypes itemTypes, Page page) {
        List<ItemTypes> list = itemTypesService.getItemTypes(itemTypes, page);
        int count = itemTypesService.getCount(itemTypes);
        HashMap map = new HashMap();
        map.put("list", list);
        map.put("count", count);
        return CommonResult.success(map);
    }


    //修改
    @PutMapping("itemtypes")
    public CommonResult editItemTypes(@RequestBody ItemTypes itemTypes) {
        int count = itemTypesService.editItemTypes(itemTypes);
        itemTypes = itemTypesService.getItemTypesByID(itemTypes.getId());
        return CommonResult.success(itemTypes);
    }

    //删除
    @DeleteMapping("itemtypes/{id}")
    public CommonResult delItemTypes(@PathVariable int id) {
        int count = itemTypesService.delItemTypes(id);
        if (count > 0) {
            return CommonResult.success();
        } else {
            return CommonResult.fail();
        }
    }
}
