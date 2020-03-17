package aminev;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

@Slf4j
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        DOMParser domParser = new DOMParser();
        try {
            // TODO Сделать ресурс-лоадер?
            domParser.parse("src/main/resources/plant_catalog.xml");
        } catch (IOException | SAXException e) {
            log.error(e.getMessage());
            System.exit(-1);
        }
        Document document = domParser.getDocument();

        Element root = document.getDocumentElement();
        System.out.println(root.getTagName());
        NodeList nodes = root.getChildNodes();
        printXML(nodes);
    }

    static void printXML(NodeList nodes) {
        for (int i = 0; i < nodes.getLength(); i++)
            if (nodes.item(i).hasChildNodes()) {
                printXML(nodes.item(i).getChildNodes());
            } else {
                System.out.println(nodes.item(i).getNodeName() + " " + nodes.item(i).getNodeValue());
            }
    }

}
