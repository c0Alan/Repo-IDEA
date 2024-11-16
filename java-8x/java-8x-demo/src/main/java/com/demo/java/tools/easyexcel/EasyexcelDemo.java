package com.demo.java.tools.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * easyexcel 示例
 * @author liuxl
 * @date 2024/11/10
 */
public class EasyexcelDemo {

    String destFile = "C:\\Users\\Administrator\\Desktop\\easyexcel_write.xlsx";
    String templateFile = "C:\\Users\\Administrator\\Desktop\\easyexcel_template.xlsx";
    String templateFileList = "C:\\Users\\Administrator\\Desktop\\easyexcel_template_list.xlsx";

    /**
     * 模板填充, 多条数据
     * 参考：https://blog.csdn.net/weixin_42001592/article/details/128402350
     */
    @Test
    public void test04(){
        List<ExcelTemplateVo> templateVos = new ArrayList<>();
        templateVos.add(new ExcelTemplateVo("小明", 18));
        templateVos.add(new ExcelTemplateVo("小红", 19));
        templateVos.add(new ExcelTemplateVo("小刚", 20));
        EasyExcel.write(destFile).withTemplate(templateFileList).sheet(0).doFill(templateVos);
    }

    /**
     * 模板填充, 一条数据
     * 参考：https://blog.csdn.net/weixin_42001592/article/details/128402350
     */
    @Test
    public void test03(){
        List<ExcelTemplateVo> templateVos = new ArrayList<>();
        templateVos.add(new ExcelTemplateVo("小明", 18));
        templateVos.add(new ExcelTemplateVo("小红", 19));
        templateVos.add(new ExcelTemplateVo("小刚", 20));
        EasyExcel.write(destFile).withTemplate(templateFile).sheet(0).doFill(templateVos.get(0));
    }

    /**
     * 复杂头写入
     * 参考：https://blog.csdn.net/weixin_42001592/article/details/128402350
     */
    @Test
    public void test01(){
        List<UserVO> userVOList = new ArrayList<>();
        userVOList.add(new UserVO(1, "小明", 18, "男", "北京市朝阳区", LocalDateTime.now(), 1000.00));
        userVOList.add(new UserVO(2, "小红", 19, "女", "北京市海淀区", LocalDateTime.now(), 2000.00));
        userVOList.add(new UserVO(3, "小刚", 20, "男", "北京市昌平区", LocalDateTime.now(), 3000.00));

        // 输出文件路径
        // 指定使用类 UserVO 去写到第一个sheet，sheet命名为 数据列表，写完文件流会自动关闭
        EasyExcel.write(destFile, UserVO.class).sheet("数据列表").doWrite(userVOList);
    }

    /**
     * jsonobject 写入
     */
    @Test
    public void test02(){

        List<JSONObject> jsonObjectList = new ArrayList<>();
        JSONObject obj1 = new JSONObject();
        obj1.put("name", "小明");
        obj1.put("age", 18);
        jsonObjectList.add(obj1);
        JSONObject obj2 = new JSONObject();
        obj2.put("name", "小红");
        obj2.put("age", 19);
        jsonObjectList.add(obj2);
        EasyExcel.write(destFile).withTemplate(templateFileList).sheet().doFill(jsonObjectList);
    }

}
