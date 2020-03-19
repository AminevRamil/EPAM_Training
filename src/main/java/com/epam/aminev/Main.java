package com.epam.aminev;

import lombok.extern.slf4j.Slf4j;
import com.epam.aminev.part1.MyDOMParser;
import com.epam.aminev.part1.MyStAXParser;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;

@Slf4j
public class Main {
    public static void main(String[] args) {
        MyDOMParser domParser = new MyDOMParser();
        domParser.parse("src/main/resources/plant_catalog.xml");
        MyStAXParser stAXParser = new MyStAXParser();
        try {
            stAXParser.parse("src/main/resources/plant_catalog.xml");
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
