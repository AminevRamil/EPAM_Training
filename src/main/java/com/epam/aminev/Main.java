package com.epam.aminev;

import com.epam.aminev.part2.XmlCreator;
import com.epam.aminev.part2.XmlValidator;
import lombok.extern.slf4j.Slf4j;
import com.epam.aminev.part1.MyDomParser;
import com.epam.aminev.part1.MyStAXParser;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;

/**
 * Main class which demonstrate understanding of how XML works
 *
 * @author Aminev Ramil
 */
@Slf4j
public class Main {
    /**
     * Entry point in demo that was did during lesson 6
     *
     * @param args - input arguments. Not used
     */
    public static void main(String[] args) {
        MyDomParser domParser = new MyDomParser();
        domParser.parse("src/main/resources/plant_catalog.xml");
        MyStAXParser stAXParser = new MyStAXParser();
        try {
            stAXParser.parse("src/main/resources/plant_catalog.xml");
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        XmlCreator xmlCreator = new XmlCreator();
        try {
            xmlCreator.create(10);
        } catch (TransformerException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        XmlValidator validator = new XmlValidator();
        boolean result = validator.validate("src/main/resources/book.xsd", "book_catalog.xml");
        if (result) System.out.println("Successful validation");
        else System.out.println("Document doesn't pass validation");
    }
}
