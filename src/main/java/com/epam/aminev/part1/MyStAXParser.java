package com.epam.aminev.part1;

import lombok.extern.slf4j.Slf4j;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * The {@code MyStAXParser} class is parsing  XML file
 * into logs using StAX API
 *
 * @author Aminev Ramil
 */
@Slf4j
public class MyStAXParser {

    /**
     * Method that trying to open specified file
     * and run serial processing
     *
     * @param fileName of file that need to parse
     */
    public void parse(String fileName) throws FileNotFoundException, XMLStreamException {
        if (fileName == null) throw new NullPointerException("Can't parse null");
        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(fileName));

        while (reader.hasNext()) {
            reader.next();
            switch (reader.getEventType()) {
                case XMLStreamConstants.START_ELEMENT:
                    log.info(String.format("<%s>", reader.getLocalName()));
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String str = reader.getText().trim();
                    if (!str.isEmpty()) log.info(String.format("%s", str));
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    log.info(String.format("</%s>", reader.getLocalName()));
                    break;
            }
        }
    }
}
