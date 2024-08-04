package com.demo.java.mytool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * 根据书签提取学习清单
 * @author liuxl
 * @date 2024/7/27
 */
public class GenerateBook {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        generateBook();
    }

    public static void generateBook() throws IOException, ParserConfigurationException, SAXException {
        BufferedReader br = new BufferedReader(new FileReader("bookmarks.html"));
        // 创建DocumentBuilderFactory和DocumentBuilder实例
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        String line = null;
        while ((line = br.readLine()) != null) {
            if (line.contains(">*")) {
//                System.out.println(line);
                // 将XML行字符串转换为InputSource
                InputSource is = new InputSource(new StringReader(line.replaceFirst("<DT>", "").trim()));

                // 使用DocumentBuilder解析InputSource
                Document doc = builder.parse(is);

                // 获取所有<book>元素
                NodeList node = doc.getElementsByTagName("A");
                Element element = (Element) node.item(0);
                System.out.println(String.format("[%s](%s)\n", element.getTextContent(), element.getAttribute("HREF")));

            }
        }

    }


}

