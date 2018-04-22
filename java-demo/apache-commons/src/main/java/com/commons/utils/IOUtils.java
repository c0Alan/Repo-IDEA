package com.commons.utils;

public class IOUtils {

    /**
     * 延迟打印一条内容
     * @param content
     * @param speed 速度, 毫秒
     * @author liuxl
     * @date @time 2017-10-11 下午3:03:52
     */
    public static void delayPrint(String content, int speed) {
        for (int i = 0; i < content.length(); i++) {
            System.out.print(content.charAt(i));
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        delayPrint("hello\nworld", 300);
    }
}
