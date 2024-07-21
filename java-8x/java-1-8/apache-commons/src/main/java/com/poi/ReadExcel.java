package com.demo.java.apachecommons.poi;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * 使用poi解析excel文件
 * @Author liuxilin
 * @Date 2019-01-29 8:53
 */
public class ReadExcel {
    
    public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
        
        InputStream inputStream = new FileInputStream("C:/Users/H__D/Desktop/workbook.xls");
        //InputStream inp = new FileInputStream("C:/Users/H__D/Desktop/workbook.xls");

        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        DataFormatter formatter = new DataFormatter();
        for (Row row : sheet) {
            for (Cell cell : row) {
                CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                //单元格名称
                System.out.print(cellRef.formatAsString());
                System.out.print(" - ");

                //通过获取单元格值并应用任何数据格式（Date，0.00，1.23e9，$ 1.23等），获取单元格中显示的文本
                String text = formatter.formatCellValue(cell);
                System.out.println(text);

                 //获取值并自己格式化
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:// 字符串型
                        System.out.println(cell.getRichStringCellValue().getString());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:// 数值型
                        if (DateUtil.isCellDateFormatted(cell)) { // 如果是date类型则 ，获取该cell的date值
                            System.out.println(cell.getDateCellValue());
                        } else {// 纯数字
                            System.out.println(cell.getNumericCellValue());
                        }
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:// 布尔
                        System.out.println(cell.getBooleanCellValue());
                        break;
                    case Cell.CELL_TYPE_FORMULA:// 公式型
                        System.out.println(cell.getCellFormula());
                        break;
                    case Cell.CELL_TYPE_BLANK:// 空值
                        System.out.println();
                        break;
                    case Cell.CELL_TYPE_ERROR: // 故障
                        System.out.println();
                        break;
                    default:
                        System.out.println();
                }
            }
        }
        
    }
    
}