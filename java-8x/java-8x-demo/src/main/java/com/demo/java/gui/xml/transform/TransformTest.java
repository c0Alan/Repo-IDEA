package com.demo.java.gui.xml.transform;

import org.xml.sax.InputSource;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This program demonstrates XSL transformations. It applies a transformation to a set of employee
 * records. The records are stored in the file employee.dat and turned into XML format. Specify the
 * stylesheet on the command line, e.g.
 * java transform.TransformTest transform/makeprop.xsl
 *
 * @author Cay Horstmann
 * @version 1.03 2016-04-27
 */
public class TransformTest {
    public static void main(String[] args) throws Exception {
        Path path;
        if (args.length > 0) {
            path = Paths.get(args[0]);
        } else {
            path = Paths.get("data", "makehtml.xsl");
        }
        try (InputStream styleIn = Files.newInputStream(path)) {
            StreamSource styleSource = new StreamSource(styleIn);

            Transformer t = TransformerFactory.newInstance().newTransformer(styleSource);
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.setOutputProperty(OutputKeys.METHOD, "xml");
            t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            try (InputStream docIn = Files.newInputStream(Paths.get("data", "employee.dat"))) {
                t.transform(new SAXSource(new EmployeeReader(), new InputSource(docIn)),
                        new StreamResult(System.out));
            }
        }
    }
}


