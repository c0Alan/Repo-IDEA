package com.jdk.others;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * Created by DavidCai on 2017/8/31.
 */
public class B {

    static String[] commonStrings(String[] arrA, String[] arrB){
//        Map tmpMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        
//        for(String str : arrA){
//            tmpMap.put(str, true);
//        }
//        int i = 0;
//        for(String str : arrB){
//            if(tmpMap.get(str) != null){
//                if(i == 0)
//                    sb.append(str);
//                else
//                    sb.append("," + str); 
//            }
//        }
        
        if(sb.length() == 0)
            return null;
        
        return sb.toString().split(",");
    }

    public static void main(String[] args) throws IOException{
        InputStream in = args == null || args.length  < 1? System.in :
                new FileInputStream(new File(args[0]));

        Scanner scanner = new Scanner(in);

        int n = scanner.nextInt();
        String[] arrA = new String[n];
        for (int ii = 0; ii < n; ii++){
            arrA[ii] = scanner.next();
        }
        int m = scanner.nextInt();
        String[] arrB = new String[m];
        for (int ii = 0; ii < m; ii++){
            arrB[ii] = scanner.next();
        }
        OutputStream out = args == null || args.length  < 2? System.out :
                new FileOutputStream(new File(args[1]));
//        OutputStream out = System.out;
        String[] arrC = commonStrings(arrA, arrB);
        if (null != arrC){
            for (int ii = 0; ii < arrC.length; ii++){
                out.write(String.valueOf(arrC[ii]+ " ").getBytes());
            }
        }
        out.flush();
        in.close();
        out.close();
    }

}