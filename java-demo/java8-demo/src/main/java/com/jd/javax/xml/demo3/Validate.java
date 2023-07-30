package com.jd.javax.xml.demo3;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;


public class Validate {
	public static void main(String[] args) {
		String xsdFile, xmlFile = null;
		
		xsdFile = "default.xsd";
		
		if (args.length <= 0) {
			System.err.println("usage: java -jar XMLValidator.jar <xml file> <optional xsd file>");
			System.exit(0);
		} else if (args.length == 1) {
			xmlFile = args[0];
			
			if ("--help".equalsIgnoreCase(args[0])) {
				System.err.println("usage: java -jar XMLValidator.jar <xml file> <optional xsd file>");
				System.exit(0);
			}
		} else if (args.length <= 2) {
			xmlFile = args[0];
			xsdFile = args[1];
		} else {
			System.err.println("error: invalid no. of arguments\n"
					+ "usage: java -jar XMLValidator.jar <xml file> <optional xsd file>");
			
			System.exit(0);
		}
		
		
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = null;
		try {
			schema = factory.newSchema(new File(xsdFile));
		} catch (SAXException e) {
			System.err.println("Invalid XSD: Please provide a valid XSD file or use the default XSD file to validate your XML file.");
		}
		
		if (schema != null) {
			Validator validator = schema.newValidator();
			
			StreamSource source = new StreamSource(new File(xmlFile));
			try {
				validator.validate(source);
				System.out.println("Valid");
			} catch (SAXException e) {
				System.out.println("Invalid: " + e.getMessage());
			} catch (IOException e) {
				System.err.println(xmlFile + ": File not found or unable to access the file.");
			}
		}
	}
}
