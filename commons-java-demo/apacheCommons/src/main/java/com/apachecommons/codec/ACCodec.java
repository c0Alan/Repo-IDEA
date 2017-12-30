package com.apachecommons.codec;

import java.io.File;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.commons.consts.Consts2;

public class ACCodec {

    private static Logger logger = Logger.getLogger(ACCodec.class);

    public void testBase64() throws Exception {
        
        /** encodeBase64: 用于测试 Base64 编码过的字符串内容 */
        String content = Consts2.consts.getContent();
        String outputPath = "H:\\test3.pdf";
        
        /** decodeBase64: Base64 反编码获取字节数组 */
        byte[] bytes = Base64.decodeBase64(content);
        
        File f = new File(outputPath);
        FileUtils.writeByteArrayToFile(f, bytes);
        
        logger.info("test");
    }

}
