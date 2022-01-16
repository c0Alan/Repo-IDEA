package com.demo.springcloud.service;

import com.demo.springcloud.entity.excel.XzqhExcelEntity;

import java.util.List;

public interface ExcelService {
    List<XzqhExcelEntity> getXzqhDictData();

    String saveXzqhDictData();
}
