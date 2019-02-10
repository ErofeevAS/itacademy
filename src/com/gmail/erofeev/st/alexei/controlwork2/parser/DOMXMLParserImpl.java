package com.gmail.erofeev.st.alexei.controlwork2.parser;

import com.gmail.erofeev.st.alexei.controlwork2.XMLParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMXMLParserImpl implements XMLParser {
    @Override
    public void showTitleAndPriceForItem(File file) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            Element root = doc.getDocumentElement();
            NodeList nodes = root.getElementsByTagName("item");
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                Element element = (Element) node;
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    String title = element.getElementsByTagName("title").item(0).getTextContent();
                    String price = element.getElementsByTagName("price").item(0).getTextContent();
                    System.out.println(title + "price: " + price);
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }
}
