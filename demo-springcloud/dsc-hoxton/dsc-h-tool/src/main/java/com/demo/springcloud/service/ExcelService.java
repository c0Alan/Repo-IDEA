package com.demo.springcloud.service;

import com.demo.springcloud.entity.Dict;
import com.demo.springcloud.entity.excel.XzqhExcelEntity;

import java.util.List;

public interface ExcelService {
    List<Dict> getXzqhDictDataV2();

    List<XzqhExcelEntity> getXzqhDictData();

    String importXzqhDictData();

    String saveXzqhDictData();
}
