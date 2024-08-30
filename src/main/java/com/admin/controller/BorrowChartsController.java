package com.admin.controller;

import com.admin.bean.BorrowCharts;
import com.admin.common.CommonResult;
import com.admin.service.IBorrowChartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@RestController
@CrossOrigin
public class BorrowChartsController {
    @Autowired
    IBorrowChartsService borrowChartsService;
    //借出统计
    @GetMapping("borrowcharts")
    public CommonResult getBorrowCharts(BorrowCharts borrowCharts) {
        HashMap map=new HashMap();
        List<BorrowCharts> list = borrowChartsService.getBorrowCharts(borrowCharts);
        String[] names=new String[list.size()];
        int [] counts=new int[list.size()];
        map.put("names",names);
        map.put("counts",counts);
        for (int i = 0; i < list.size(); i++) {
            names[i]=list.get(i).getTypeName();
            counts[i]=list.get(i).getCount();
        }
        return CommonResult.success(map);
    }

}
