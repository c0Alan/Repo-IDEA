package com.springmvc.messageconverter;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import com.springmvc.domain.DemoObj;

/**
 * 自定义消息转换器
 *
 * @author liuxilin
 * @date 2018/6/10 23:17
 */
public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj> {//1

    /**
     * 新建一个我们自定义的媒体类型application/x-wisely
     */
    public MyMessageConverter() {
        super(new MediaType("application", "x-wisely", Charset.forName("UTF-8")));//2
    }

    /**
     * 重写readlntenal 方法，处理请求的数据。代码表明我们处理由"-"隔开的数据，
     * 并转成DemoObj 的对象。
     */
    @Override
    protected DemoObj readInternal(Class<? extends DemoObj> clazz,
                                   HttpInputMessage inputMessage) throws IOException,
            HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"));
        String[] tempArr = temp.split("-");
        return new DemoObj(new Long(tempArr[0]), tempArr[1]);
    }

    /**
     * 表明本HttpMessageConverter 只处理DemoObj 这个类。
     */
    @Override
    protected boolean supports(Class<?> clazz) {
        return DemoObj.class.isAssignableFrom(clazz);
    }

    /**
     * 重写 writeInternal ，处理如何输出数据到response。
     * 此例中，我们在原样输出前面加上"hello: "
     */
    @Override
    protected void writeInternal(DemoObj obj, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        String out = "hello:" + obj.getId() + "---" + obj.getName();
        outputMessage.getBody().write(out.getBytes());
    }

}
