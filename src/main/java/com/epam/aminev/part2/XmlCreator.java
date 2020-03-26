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

/**
 * The {@code XmlCreator} class demonstrate how to create, validate
 * and write a XML-file using java APIs
 */
public class XmlCreator {
    /**
     * Method that create XML-file, then validate it and writes it into filesystem
     *
     * @param quantity of books to be generate
     * @throws ParserConfigurationException indicates a serious configuration error
     * @throws TransformerException         specifies an exceptional condition that occurred
     *                                      during the transformation process.
     */
    public void create(int quantity) throws ParserConfigurationException, TransformerException {
        if (quantity <= 0) throw new ParserConfigurationException("Can't create zero or less elements");
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

    /**
     * Method that creates root element and fills it with books
     *
     * @param document that contains empty XML-file
     * @param quantity of books to be generate
     */
    private void createBooks(Document document, int quantity) {
        if (document == null) throw new NullPointerException("Can't fill null file");
        Element rootElement = document.createElementNS("", "Books");
        rootElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        rootElement.setAttribute("xsi:noNamespaceSchemaLocation", "src/main/resources/book.xsd");
        document.appendChild(rootElement);

        for (int i = 0; i < quantity; i++) {
            Element book = document.createElement("book");
            book.appendChild(createAuthor(document));
            book.appendChild(makeField(document, "pages", Integer.toString((int) (Math.random() * 1000))));
            book.appendChild(makeField(document, "title", getRandomString()));
            book.appendChild(makeField(document, "publisher", getRandomString()));
            rootElement.appendChild(book);
        }
    }

    /**
     * Method that generate and insert new complex field in XML-file
     *
     * @param document in which to be insert author field
     * @return instance of Node in document
     */
    private Node createAuthor(Document document) {
        Element author = document.createElement("author");
        author.appendChild(makeField(document, "firstname", getRandomString()));
        author.appendChild(makeField(document, "lastname", getRandomString()));
        author.appendChild(makeField(document, "secondname", getRandomString()));
        return author;
    }

    /**
     * Method that create field in XML-file and fill it with given value
     *
     * @param document  in which field will insert
     * @param fieldName that need to create
     * @param value     which will be inserted
     * @return instance of Node in document
     */
    private Node makeField(Document document, String fieldName, String value) {
        Element node = document.createElement(fieldName);
        node.appendChild(document.createTextNode(value));
        return node;
    }

    /**
     * Simple generator of randoms strings
     *
     * @return generated string
     */
    private String getRandomString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append((char) ('a' + Math.random() * 26));
        }
        return stringBuilder.toString();
    }
}
