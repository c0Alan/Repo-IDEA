package com.el.filter;

/**
* @ClassName: HtmlFilter
* @Description: html转义处理工具类
* @author: 孤傲苍狼
* @date: 2014-8-27 上午12:09:15
*
*/ 
public class HtmlFilter {

    /**
    * @Method: filter
    * @Description: 静态方法，html标签转义处理
    * @Anthor:孤傲苍狼
    *
    * @param message 要转义的内容
    * @return 转义后的内容
    */ 
    public static String filter(String message) {

        if (message == null)
            return (null);

        char content[] = new char[message.length()];
        message.getChars(0, message.length(), content, 0);
        StringBuffer result = new StringBuffer(content.length + 50);
        for (int i = 0; i < content.length; i++) {
            switch (content[i]) {
            case '<':
                result.append("&lt;");
                break;
            case '>':
                result.append("&gt;");
                break;
            case '&':
                result.append("&amp;");
                break;
            case '"':
                result.append("&quot;");
                break;
            default:
                result.append(content[i]);
            }
        }
        return (result.toString());
    }
}