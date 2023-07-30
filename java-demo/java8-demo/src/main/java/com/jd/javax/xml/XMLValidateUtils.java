package com.jd.javax.xml;

import javax.xml.XMLConstants;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;


public class XMLValidateUtils {

    /**
     * @param xmlFile     xml字符串
     * @param xsdFilePath xsd 文件的全路径
     * @return
     */
    public static String validateXMLWithXSD(String xmlFile, String xsdFilePath) {
        XMLErrorHandler errHandler = null;
        try {
            Reader xmlReader = new BufferedReader(new StringReader(xmlFile));
            Reader xsdReader = new BufferedReader(new FileReader(xsdFilePath));
            Source xmlSource = new StreamSource(xmlReader);
            Source xsdSource = new StreamSource(xsdReader);
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(xsdSource);
            XMLStreamReader reader = XMLInputFactory.newFactory().createXMLStreamReader(xmlSource);
            Validator validator = schema.newValidator();
            errHandler = new XMLErrorHandler(reader);
            validator.setErrorHandler(errHandler);
            validator.validate(new StAXSource(reader));
            return errHandler.getErrorElement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
