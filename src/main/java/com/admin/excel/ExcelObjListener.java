package com.admin.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;

import java.util.ArrayList;
import java.util.List;

public class ExcelObjListener<E> implements ReadListener<E> {
    public List<E> list =new ArrayList<E>();

//    读取到每一个对象都要调用invoke方法
    @Override
    public void invoke(E data, AnalysisContext analysisContext) {
        System.out.println(data);
        list.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("读取完毕");
    }

    public static void main(String[] args) {
        EasyExcel.read("D:\\testexcel.xlsx",ExcelObj.class, new ExcelObjListener()).sheet(0).doRead();
    }
}
