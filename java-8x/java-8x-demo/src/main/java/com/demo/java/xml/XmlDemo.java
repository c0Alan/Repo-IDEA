package com.demo.java.xml;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

/**
 * xml 解析示例
 *
 * @author liuxl
 * @date 2024/7/27
 */
public class XmlDemo {


    /**
     * 解析一行Xml语句
     */
    @Test
    public void test01() {
        try {
            // XML行字符串
            String xmlLine = "<book id='1'><title>Java Programming</title><author>John Doe</author></book>";

            // 创建DocumentBuilderFactory和DocumentBuilder实例
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // 将XML行字符串转换为InputSource
            InputSource is = new InputSource(new StringReader(xmlLine));

            // 使用DocumentBuilder解析InputSource
            Document doc = builder.parse(is);

            // 获取所有<book>元素
            NodeList bookList = doc.getElementsByTagName("book");

            // 遍历所有<book>元素
            for (int i = 0; i < bookList.getLength(); i++) {
                Node bookNode = bookList.item(i);
                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) bookNode;
                    // 获取id属性
                    String id = bookElement.getAttribute("id");
                    // 获取<title>元素的文本内容
                    String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                    // 获取<author>元素的文本内容
                    String author = bookElement.getElementsByTagName("author").item(0).getTextContent();

                    System.out.println("Book ID: " + id);
                    System.out.println("Title: " + title);
                    System.out.println("Author: " + author);
                }
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
