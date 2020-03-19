package com.epam.aminev.part2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XmlCreator {
    public void create(int quantity) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult file = new StreamResult(new File("book_catalog.xml"));

        createBooks(document, quantity);

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(document);
        transformer.transform(source, file);
    }

    private Document createBooks(Document document, int quantity) {
        Element rootElement = document.createElementNS("", "Books");
        rootElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        rootElement.setAttribute("xsi:noNamespaceSchemaLocation", "src/main/resources/book.xsd");
        document.appendChild(rootElement);

        for (int i = 0; i < quantity; i++) {
            Element book = document.createElement("book");
            book.appendChild((document));
            book.appendChild(makeField(document, "pages", Integer.toString((int) (Math.random() * 1000))));
            book.appendChild(makeField(document, "title", getRandomString()));
            book.appendChild(makeField(document, "publisher", getRandomString()));
            rootElement.appendChild(book);
        }
        return document;
    }

    private Node createAuthor(Document document) {
        Element author = document.createElement("author");
        author.appendChild(makeField(document, "firstname", getRandomString()));
        author.appendChild(makeField(document, "lastname", getRandomString()));
        author.appendChild(makeField(document, "secondname", getRandomString()));
        return author;
    }

    private Node makeField(Document document, String field, String value) {
        Element node = document.createElement(field);
        node.appendChild(document.createTextNode(value));
        return node;
    }

    private String getRandomString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append((char) ('a' + Math.random() * 26));
        }
        return stringBuilder.toString();
    }
}
