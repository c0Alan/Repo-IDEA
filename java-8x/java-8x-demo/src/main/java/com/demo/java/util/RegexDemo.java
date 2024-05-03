package com.demo.java.util;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @author liuxilin
 * @date 2022/8/7 10:45
 */
public class RegexDemo {


    public static void main(String[] args) throws PatternSyntaxException {

    }

    /**
     * 正则表达式示例,将匹配的内容用括号括起来
     */
    @Test
    public void test01() {
        String patternString = ".*(da).*";

        Pattern pattern = Pattern.compile(patternString);

        String input = "adafd2ggf312dafa";
        if (input == null || input.equals("")) {
            return;
        }
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            System.out.println("Match");
            int g = matcher.groupCount();
            if (g > 0) {
                for (int i = 0; i < input.length(); i++) {
                    // Print any empty groups
                    for (int j = 1; j <= g; j++) {
                        if (i == matcher.start(j) && i == matcher.end(j)) {
                            System.out.print("()");
                        }
                    }
                    // Print ( for non-empty groups starting here
                    for (int j = 1; j <= g; j++) {
                        if (i == matcher.start(j) && i != matcher.end(j)) {
                            System.out.print('(');
                        }
                    }
                    System.out.print(input.charAt(i));
                    // Print ) for non-empty groups ending here
                    for (int j = 1; j <= g; j++) {
                        if (i + 1 != matcher.start(j) && i + 1 == matcher.end(j)) {
                            System.out.print(')');
                        }
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("No match");
        }
    }
}
