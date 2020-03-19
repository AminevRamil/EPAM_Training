package com.epam.aminev.part1;

import lombok.extern.slf4j.Slf4j;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Slf4j
public class MyStAXParser {

    public void parse(String path) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(path));

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
