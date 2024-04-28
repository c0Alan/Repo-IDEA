package com.demo.java.exercise;

import java.util.UUID;

/**
 * @description 生成不充分的随机八位数字
 * 
 * @author liuxl
 * @date 2018/3/29 16:37
 */
public class EightNum {
    public static String[] CHARS = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };

    public static String[] NUMBERS = new String[] {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9"};

    /**
     * @description 生成随机的UUID
     * 
     * @date 2018/3/29 16:46
     * @param
     * @return java.string.String
     */
    public static String generateShortUuid() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(NUMBERS[x % 10]);
        }
        return shortBuffer.toString();

    }

    public static void main(String[] args) {

        System.out.println(generateShortUuid());
    }
}
