package com.gmail.erofeev.st.alexei.controlTwo.parser;


import com.gmail.erofeev.st.alexei.controlTwo.ParserService;
import com.gmail.erofeev.st.alexei.controlTwo.util.XMLValidatorUtil;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class STaXParserServiceImpl implements ParserService {
    boolean isItem = false;
    boolean isProductName = false;
    boolean isPrice = false;


    @Override
    public String parse(File file, File xsd) {
        float totalPrice = 0;
        StringBuffer response = new StringBuffer("{");
        if (XMLValidatorUtil.validateAgainstXSD(file, xsd)) {
            System.out.println(file.getName() + " is valid");
            try {
                XMLInputFactory factory = XMLInputFactory.newFactory();
                XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(file));
                String productName = "";
                Float price = 0f;

                while (eventReader.hasNext()) {
                    XMLEvent event = eventReader.nextEvent();
                    switch (event.getEventType()) {
                        case XMLStreamConstants.START_ELEMENT: {
                            StartElement startElement = event.asStartElement();
                            String name = startElement.getName().getLocalPart();

                            if (name.equalsIgnoreCase("item")) {
                                isItem = true;
                            } else if (name.equalsIgnoreCase("productname")) {
                                isProductName = true;
                            } else if (name.equalsIgnoreCase("usprice")) {
                                isPrice = true;
                            }
                            break;
                        }
                        case XMLStreamConstants.CHARACTERS: {
                            Characters characters = event.asCharacters();
                            if (isItem) {
                                isItem = false;
                            }
                            if (isProductName) {
                                productName = characters.getData();
                                isProductName = false;
                            }
                            if (isPrice) {
                                price = Float.parseFloat(characters.getData());
                                isPrice = false;
                            }

                            break;
                        }
                        case XMLStreamConstants.END_ELEMENT: {
                            EndElement endElement = event.asEndElement();
                            if (endElement.getName().getLocalPart().equalsIgnoreCase("item")) {
                                response.append(productName).append("-").append(price);
                                totalPrice += price;
                            }
                            break;
                        }
                        default: {
                           // System.out.println(event.getEventType());
                        }
                    }
                }
            } catch (
                    FileNotFoundException e) {
                e.printStackTrace();
            } catch (
                    XMLStreamException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(file + " not match with xsd: " + xsd);
        }
        response.substring(0, response.length() - 1);
        return response + ":totalprice is " + totalPrice + "}";

    }
}

