package com.demo.java.web.wrapper;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class BufferResponse extends HttpServletResponseWrapper {

    private ByteArrayOutputStream bout = new ByteArrayOutputStream();
    private PrintWriter pw;
    private HttpServletResponse response;

    public BufferResponse(HttpServletResponse response) {
        super(response);
        this.response = response;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return new MyServletOutputStream(bout);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        pw = new PrintWriter(new OutputStreamWriter(bout, this.response.getCharacterEncoding()));
        return pw;
    }

    public byte[] getBuffer() {
        try {
            if (pw != null) {
                pw.close();
            }
            if (bout != null) {
                bout.flush();
                return bout.toByteArray();
            }


            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}