package com.demo.java.tools.poi;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xslf.usermodel.*;
import org.junit.Test;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author liuxl
 * @date 2024/10/15
 */
@Slf4j
public class PptDemo {

    /**
     * 根据模板生成ppt
     */
    @Test
    public void test02() throws IOException {
        InputStream is = this.getClass().getResourceAsStream("/template/ppt_template.pptx");
        XMLSlideShow ppt = new XMLSlideShow(is);
        XSLFSlideMaster master = ppt.getSlideMasters().get(0);
        XSLFSlideLayout layout = master.getLayout("TITLE_AND_CONTENT");
        XSLFSlide slide = ppt.createSlide(layout);
        for (XSLFTextShape textShape : slide.getPlaceholders()){
            textShape.setText("hello world");
        }

        // 保存PPT文件
        try (FileOutputStream out = new FileOutputStream("D:\\tmp\\example.pptx")) {
            ppt.write(out);
        }

        log.info("PPT文件生成成功！");
    }


    /**
     * ppt 生成
     */
    @Test
    public void test01() throws IOException {
        // 创建一个新的PPT演示文稿
        XMLSlideShow ppt = new XMLSlideShow();

        // 创建一张幻灯片
        XSLFSlide slide = ppt.createSlide();

        // 向幻灯片添加文本框
        XSLFTextShape textBox = slide.createTextBox();
        textBox.setText("Hello, Java PPT!");
        textBox.setAnchor(new Rectangle(200, 200, 500, 50));

        // 保存PPT文件
        try (FileOutputStream out = new FileOutputStream("D:\\tmp\\example.pptx")) {
            ppt.write(out);
        }

        log.info("PPT文件生成成功！");
    }
}
