package com.gmail.erofeev.st.alexei.controlTwo.parser;


import com.gmail.erofeev.st.alexei.controlTwo.ParserService;
import com.gmail.erofeev.st.alexei.controlTwo.util.XMLValidatorUtil;
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

public class DomParserServiceImpl implements ParserService {

    @Override
    public String parse(File file, File xsd) {
        float totalPrice = 0;
        StringBuilder response = new StringBuilder("{");
        if (XMLValidatorUtil.validateAgainstXSD(file, xsd)) {
            System.out.println(file + " is valid");
            try {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = factory.newDocumentBuilder();
                Document doc = documentBuilder.parse(file);
                Element root = doc.getDocumentElement();
                root.normalize();
                NodeList list = root.getChildNodes();
                for (int i = 0; i < list.getLength(); i++) {
                    Node node = list.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        if (node.getNodeName().equalsIgnoreCase("item")) {
                            Element element = (Element) node;
                            String productName = element.getElementsByTagName("ProductName").item(0).getTextContent();
                            float price = Float.parseFloat(element.getElementsByTagName("USPrice").item(0).getTextContent());
                            response.append(productName).append("-").append(price);
                            totalPrice += price;
                        }
                        response.append(",");
                    }
                }

            } catch (ParserConfigurationException e) {
                e.getMessage();
                e.printStackTrace();
            } catch (SAXException e) {
                e.getMessage();
                e.printStackTrace();
            } catch (IOException e) {
                e.getMessage();
                e.printStackTrace();
            }
        } else {
            System.out.println(file + " not match with xsd: " + xsd);
        }
        response.substring(0, response.length() - 1);
        return response + ":totalprice is " + totalPrice + "}";
    }


}

