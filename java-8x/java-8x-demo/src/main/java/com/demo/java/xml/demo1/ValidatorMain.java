package com.demo.java.xml.demo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ValidatorMain {

    private final static Logger logger = LoggerFactory.getLogger(ValidatorMain.class);

    private static String XML_FILE_PATH = "java/src/main/resources/demo1/Test.xml";
    private static String XSD_FILE_PATH = "java/src/main/resources/demo1/Test.xsd";

    public static void main(String[] args) {

        if (XmlByXsdUtil.validate(XML_FILE_PATH, XSD_FILE_PATH)) {
            saveFileOnUserHomeFolder(XML_FILE_PATH);
        }
    }

    public static void saveFileOnUserHomeFolder(String filePath) {

        InputStream inStream = null;
        OutputStream outStream = null;

        try {
            String userHomeFolder = System.getProperty("user.home");
            String filenameWithPath = filePath;
            String[] tokens = filenameWithPath.split("[\\\\|/]");
            String filename = tokens[tokens.length - 1];

            File sFile = new File(filePath);
            File dFile = new File(userHomeFolder, filename);

            inStream = new FileInputStream(sFile);
            outStream = new FileOutputStream(dFile);

            byte[] buffer = new byte[1024];

            int length;
            //copy the file content in bytes
            while ((length = inStream.read(buffer)) > 0) {

                outStream.write(buffer, 0, length);
            }

            inStream.close();
            outStream.close();

            //delete the original file
            sFile.delete();

            logger.info("File [{}] is saved successful! File location -> [{}]", filename, userHomeFolder);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
