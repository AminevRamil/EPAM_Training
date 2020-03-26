package com.epam.aminev.part2;

import lombok.extern.slf4j.Slf4j;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * The {@code XmlValidator} class is validate specified
 * XML-document by specified XSD-scheme
 */
@Slf4j
public class XmlValidator {
    /**
     *
     * @param xsdPath is XSD-scheme source
     * @param xmlPath is XML-file source
     * @return true if validation is successful and false if not
     * @throws NullPointerException in case of one of the paths (or both) is null
     */
    public boolean validate(String xsdPath, String xmlPath) {
        if (xsdPath == null || xmlPath == null) throw new NullPointerException("Can't validate null file(s)");
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | org.xml.sax.SAXException e) {
            log.error(e.getMessage());
            return false;
        }
        return true;
    }
}
