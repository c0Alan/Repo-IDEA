package com.jdk.others;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by DavidCai on 2017/8/31.
 */
public class C {

    static String maxNumber(int[] arr){
        
        if(null == arr || arr.length == 0){
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        TreeSet<Num> ts = new TreeSet<C.Num>(new Comparator<C.Num>() {

            @Override
            public int compare(Num arg0, Num arg1) {
                
                StringBuffer sb1 = new StringBuffer();
                StringBuffer sb2 = new StringBuffer();
                
                sb1.append(arg0.getValue()).append(arg1.getValue());
                sb2.append(arg1.getValue()).append(arg0.getValue());
                
                if(Integer.valueOf(sb2.toString()) - Integer.valueOf(sb1.toString()) == 0)
                {
                    return 1;
                }
                
                return Integer.valueOf(sb2.toString()) - Integer.valueOf(sb1.toString());
                
            }
           
        });
        
        for(int n : arr){
            C.Num num = new C().new Num(String.valueOf(n));
            ts.add(num);
        }
        
        for(C.Num num : ts){
            sb.append(num.getValue());
        }
        
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        InputStream in = args == null || args.length < 1 ? System.in : new FileInputStream(new File(args[0]));

        Scanner scanner = new Scanner(in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int ii = 0; ii < n; ii++) {
            arr[ii] = scanner.nextInt();
        }
        OutputStream out = args == null || args.length < 2 ? System.out : new FileOutputStream(new File(args[1]));
        out.write(String.valueOf(maxNumber(arr)).getBytes());
        out.flush();
        in.close();
        out.close();
    }

    class Num {
        String value;

        public Num(String value) {
            super();
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }

}
