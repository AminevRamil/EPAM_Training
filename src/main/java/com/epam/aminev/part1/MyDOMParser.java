package com.epam.aminev.part1;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

@Slf4j
public class MyDOMParser {

    public void parse(String path) {
        DOMParser domParser = new DOMParser();
        try {
            domParser.parse(path);
        } catch (IOException | SAXException e) {
            log.error(e.getMessage());
            System.exit(-1);
        }
        Document document = domParser.getDocument();

        Element root = document.getDocumentElement();
        printXML(root);
    }

    private void printXML(Element root) {
        log.info("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        String tagName = root.getTagName();
        log.info(String.format("<%s>", tagName));
        print_recursive(root.getChildNodes());
        log.info(String.format("</%s>", tagName));
    }

    private void print_recursive(NodeList nodes) {
        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i) instanceof Element && nodes.item(i).getChildNodes().getLength() == 1) {
                String tagName = ((Element) nodes.item(i)).getTagName();
                String text = nodes.item(i).getTextContent();
                log.info(String.format("<%s>%s</%s>", tagName, text, tagName));
            }
            if (nodes.item(i).hasChildNodes() && nodes.item(i).getChildNodes().getLength() > 1) {
                String tagName = nodes.item(i).getNodeName();
                log.info(String.format("<%s>",tagName));
                print_recursive(nodes.item(i).getChildNodes());
                log.info(String.format("</%s>",tagName));
            }
        }
    }
}
