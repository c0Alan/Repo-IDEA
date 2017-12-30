package com.jdk.others;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class A {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        InputStream in = args == null || args.length < 1 ? System.in : new FileInputStream(new File(args[0]));

        Scanner scanner = new Scanner(in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        OutputStream out = args == null || args.length < 2 ? System.out : new FileOutputStream(new File(args[1]));

        out.write(String.valueOf(isIntersection(a, b, c, d)).getBytes());

        out.flush();
        in.close();
        out.close();
        
    }

    public static int isIntersection(int num1, int num2, int num3, int num4) {
        if (num1 >= num4 || num3 >= num2) {
            return 0;
        }

        return 1;
    }

}
