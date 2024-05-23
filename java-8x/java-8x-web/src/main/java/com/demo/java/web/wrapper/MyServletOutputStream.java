package com.demo.java.web.wrapper;

import javax.servlet.ServletOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class MyServletOutputStream extends ServletOutputStream {

    private ByteArrayOutputStream bout;
    public MyServletOutputStream(ByteArrayOutputStream bout){
        this.bout = bout;
    }
    
    @Override
    public void write(int b) throws IOException {
        this.bout.write(b);
    }
}