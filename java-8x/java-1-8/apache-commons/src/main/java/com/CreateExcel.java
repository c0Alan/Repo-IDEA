package com.demo.java.apachecommons.poi;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

/**
 * 使用poi创建execl文件
 *
 * @Author liuxilin
 * @Date 2019-01-28 10:39
 */
public class CreateExcel {

    public static String reportDir = "D:\\01_JdProjTask\\20190118_flume各agent数据统计\\report";

    public static void main(String[] args) throws IOException {
        Map data = getStatisticMap();
        createReport(data);
    }

    public static Map getStatisticMap() throws IOException {
        File reportDirFile = new File(reportDir);
        File[] dirs = reportDirFile.listFiles();

        Map reportMap = new HashMap<>();
        for (File dir : dirs) {
            if (dir.isDirectory()) {
                File[] logs = dir.listFiles(new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        return pathname.getName().endsWith(".log") && pathname.getName().split("-").length > 1;
                    }
                });
                for (File log : logs) {
                    String key = log.getName().split("-")[1];
                    String key2 = dir.getName() + "-" + log.getName().split("-")[1];
                    try (FileInputStream fis = new FileInputStream(log)) {
                        Map reportMap2 = (Map) reportMap.get(key);
                        if (reportMap2 == null) {
                            reportMap2 = new HashMap<>();
                        }
                        List<String> lines = IOUtils.readLines(fis, "UTF-8");
                        if (CollectionUtils.isNotEmpty(lines)) {
                            String lastLine = lines.get(lines.size() - 1);
                            JSONObject latestStatisticMap = (JSONObject) JSONObject.parse(lastLine);
                            List<Map.Entry<String, Object>> entryList = new ArrayList<>(
                                    ((Map) latestStatisticMap.get("statistic")).entrySet());
                            Collections.sort(entryList, Comparator.comparing(Map.Entry::getKey));
                            Collections.reverse(entryList);
                            reportMap2.put(key2, entryList);
                            reportMap.put(key, reportMap2);
                        }
                    }
                }
            }
        }
        return reportMap;
    }

    public static void createReport(Map data) throws IOException {
        String reportPath = reportDir + File.separator + "report.xls";
        File reportFile = new File(reportPath);
        if (reportFile.exists()) {
            reportFile.delete();
        }
        reportFile.createNewFile();

        HSSFWorkbook workbook = new HSSFWorkbook();

        for (Object obj : data.entrySet()) {
            Map.Entry entry = (Map.Entry) obj;
            String sheetName = (String) entry.getKey();
            Map sheetData = (Map) entry.getValue();
            createSheet(workbook, sheetData, sheetName);
        }

        try (FileOutputStream fos = new FileOutputStream(reportFile)) {
            workbook.write(fos);
        }
    }

    public static void createSheet(HSSFWorkbook workbook, Map data, String sheetName) {
        HSSFSheet sheet = workbook.createSheet(sheetName);
        int cellOffet = 0;
        int rowOffet = 0;
        for (Object obj : data.entrySet()) {
            Map.Entry entry = (Map.Entry) obj;
            String key = (String) entry.getKey();
            List<Map.Entry> statisticMapList = (List<Map.Entry>) entry.getValue();

            // 创建表头
            HSSFRow headerRow = sheet.getRow(rowOffet);
            if (headerRow == null) {
                headerRow = sheet.createRow(rowOffet);
            }
            rowOffet++;
            HSSFCell header1 = headerRow.createCell(cellOffet);
            header1.setCellValue("时间");
            HSSFCell header2 = headerRow.createCell(cellOffet + 1);
            header2.setCellValue(key);

            for (Map.Entry statisticMapEntry : statisticMapList) {
                String time = (String) statisticMapEntry.getKey();
                Integer count = (Integer) ((Map) statisticMapEntry.getValue()).get("count");
                Integer maxDelaySecond = (Integer) ((Map) statisticMapEntry.getValue()).get("max_delay_second");

                // 创建表头
                HSSFRow row = sheet.getRow(rowOffet);
                if (row == null) {
                    row = sheet.createRow(rowOffet);
                }
                rowOffet++;
                HSSFCell cell1 = row.createCell(cellOffet);
                cell1.setCellValue(time);
                HSSFCell cell2 = row.createCell(cellOffet + 1);
                cell2.setCellValue(count);
            }
            rowOffet = 0;
            cellOffet = cellOffet + 3;
        }
    }

    public static void createWorkbook() throws IOException {
        Workbook[] wbs = new Workbook[]{new HSSFWorkbook(), new XSSFWorkbook()};
        for (int i = 0; i < wbs.length; i++) {
            Workbook workbook = wbs[i];
            // 得到一个POI的工具类
            CreationHelper createHelper = workbook.getCreationHelper();

            // 在Excel工作簿中建一工作表，其名为缺省值, 也可以指定Sheet名称
            Sheet sheet = workbook.createSheet();
            // Sheet sheet = workbook.createSheet("SheetName");

            // 用于格式化单元格的数据
            DataFormat format = workbook.createDataFormat();

            // 设置字体
            Font font = workbook.createFont();
            // 字体高度
            font.setFontHeightInPoints((short) 20);
            // 字体颜色
            font.setColor(Font.COLOR_RED);
            // 字体
            font.setFontName("黑体");
            // 宽度
            font.setBoldweight(Font.BOLDWEIGHT_BOLD);
            // 是否使用斜体
            font.setItalic(true);
            // font.setStrikeout(true); //是否使用划线

            // 设置单元格类型
            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setFont(font);
            // 水平布局：居中
            cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
            cellStyle.setWrapText(true);

            CellStyle cellStyle2 = workbook.createCellStyle();
            cellStyle2.setDataFormat(format.getFormat("＃, ## 0.0"));

            CellStyle cellStyle3 = workbook.createCellStyle();
            cellStyle3.setDataFormat(format.getFormat("yyyy-MM-dd HH:mm:ss"));

            // 添加单元格注释
            // 创建Drawing对象,Drawing是所有注释的容器.
            Drawing drawing = sheet.createDrawingPatriarch();
            // ClientAnchor是附属在WorkSheet上的一个对象， 其固定在一个单元格的左上角和右下角.
            ClientAnchor anchor = createHelper.createClientAnchor();
            // 设置注释位子
            anchor.setRow1(0);
            anchor.setRow2(2);
            anchor.setCol1(0);
            anchor.setCol2(2);
            // 定义注释的大小和位置,详见文档
            Comment comment = drawing.createCellComment(anchor);
            // 设置注释内容
            RichTextString str = createHelper.createRichTextString("Hello, World!");
            comment.setString(str);
            // 设置注释作者. 当鼠标移动到单元格上是可以在状态栏中看到该内容.
            comment.setAuthor("H__D");

            // 定义几行
            for (int rownum = 0; rownum < 30; rownum++) {
                // 创建行
                Row row = sheet.createRow(rownum);
                // 创建单元格
                Cell cell = row.createCell((short) 1);
                // 设置单元格内容
                cell.setCellValue(createHelper.createRichTextString("Hello！" + rownum));
                // 设置单元格样式
                cell.setCellStyle(cellStyle);
                // 指定单元格格式：数值、公式或字符串
                cell.setCellType(Cell.CELL_TYPE_STRING);
                // 添加注释
                cell.setCellComment(comment);

                // 格式化数据
                Cell cell2 = row.createCell((short) 2);
                cell2.setCellValue(11111.25);
                cell2.setCellStyle(cellStyle2);

                Cell cell3 = row.createCell((short) 3);
                cell3.setCellValue(new Date());
                cell3.setCellStyle(cellStyle3);

                // 调整第一列宽度
                sheet.autoSizeColumn((short) 0);
                // 调整第二列宽度
                sheet.autoSizeColumn((short) 1);
                // 调整第三列宽度
                sheet.autoSizeColumn((short) 2);
                // 调整第四列宽度
                sheet.autoSizeColumn((short) 3);

            }

            // 合并单元格
            // 第一行（0）
            // last row（0-based）
            // 第一列（基于0）
            // 最后一列（基于0）
            sheet.addMergedRegion(new CellRangeAddress(1,
                    2,
                    1,
                    2
            ));

            // 保存
            String filename = "C:/Users/H__D/Desktop/workbook.xls";
            if (workbook instanceof XSSFWorkbook) {
                filename = filename + "x";
            }

            FileOutputStream out = new FileOutputStream(filename);
            workbook.write(out);
            out.close();
        }
    }

}