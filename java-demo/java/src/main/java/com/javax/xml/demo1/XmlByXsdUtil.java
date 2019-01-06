package com.javax.xml.demo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class XmlByXsdUtil {

    private final static Logger logger = LoggerFactory.getLogger(XmlByXsdUtil.class);
    private static final String W3C_XML_SCHEMA_NS_URI = "http://www.w3.org/XML/XMLSchema/v1.1";

    public static boolean validate(String xmlFilePath, String xmlSchemaFilePath) {

        try {
            logger.info("parse an [{}] document into a DOM tree", xmlFilePath);
            DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
            dbfactory.setNamespaceAware(true);
            DocumentBuilder parser = dbfactory.newDocumentBuilder();

            Document document = parser.parse(new File(xmlFilePath));

            logger.info("create a SchemaFactory capable of understanding WXS schemas");
            SchemaFactory factory = SchemaFactory.newInstance(W3C_XML_SCHEMA_NS_URI);

            logger.info("load a WXS schema from [{}] file, represented by a Schema instance", xmlSchemaFilePath);
            Source schemaFile = new StreamSource(new File(xmlSchemaFilePath));
            Schema schema = factory.newSchema(schemaFile);

            logger.info("create a Validator instance, which can be used to validate an instance document");
            Validator validator = schema.newValidator();
            logger.info("validation pending...");
            validator.validate(new DOMSource(document));

            logger.info("validation success! File [{}] is valid.", xmlFilePath);

            return true;

        } catch (Exception e) {
            // Catches: SAXException, ParserConfigurationException, and IOException.

            logger.error("[{}] is not valid because... [{}]", xmlFilePath.toString(), e.getMessage());

            return false;
        }
    }
}