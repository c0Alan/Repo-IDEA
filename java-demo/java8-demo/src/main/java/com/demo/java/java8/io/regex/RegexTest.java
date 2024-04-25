package com.demo.java.java8.io.regex;

import java.util.*;
import java.util.regex.*;

/**
 * 正则表达式示例,将匹配的内容用括号括起来
 *
 * @author liuxilin
 * @date 2022/8/7 10:45
 */
public class RegexTest {
    public static void main(String[] args) throws PatternSyntaxException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter pattern: ");
        String patternString = in.nextLine();

        Pattern pattern = Pattern.compile(patternString);

        while (true) {
            System.out.println("Enter string to match: ");
            String input = in.nextLine();
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
}
