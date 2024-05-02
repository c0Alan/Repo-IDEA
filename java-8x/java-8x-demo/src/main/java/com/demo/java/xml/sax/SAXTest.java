package com.demo.java.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.net.URL;

/**
 * 使用 SAX 解析HTML中 a.href 标签内容
 *
 * @author liuxilin
 * @date 2022/8/7 21:14
 */
public class SAXTest {
    public static void main(String[] args) throws Exception {
        String url;
        if (args.length == 0) {
            // url = "http://www.w3c.org"; // 校验不通过
            url = "https://www.cnblogs.com/";
            System.out.println("Using " + url);
        } else {
           url = args[0];
        }

        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startElement(String namespaceURI, String lname, String qname,
                                     Attributes attrs) {
                if (lname.equals("a") && attrs != null) {
                    for (int i = 0; i < attrs.getLength(); i++) {
                        String aname = attrs.getLocalName(i);
                        if (aname.equals("href")) {
                           System.out.println(attrs.getValue(i));
                        }
                    }
                }
            }
        };

        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        SAXParser saxParser = factory.newSAXParser();
        InputStream in = new URL(url).openStream();
        saxParser.parse(in, handler);
    }
}
