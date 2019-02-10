package com.gmail.erofeev.st.alexei.controlwork2.parser;

import com.gmail.erofeev.st.alexei.controlwork2.XMLParser;
import com.gmail.erofeev.st.alexei.homework21.model.Book;

import javax.xml.stream.*;
import javax.xml.stream.events.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

public class STAXXMLParserImpl implements XMLParser {
    private boolean isItem;
    private boolean isTitle;
    private boolean isPrice;

    @Override
    public void showTitleAndPriceForItem(File file) {
        try {
            XMLInputFactory factory = XMLInputFactory.newFactory();
            XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(file));
            String title = "";
            String price = "";

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT: {
                        StartElement startElement = event.asStartElement();
                        String name = startElement.getName().getLocalPart();

                        if (name.equalsIgnoreCase("item")) {

                            isItem = true;
                        } else if (name.equalsIgnoreCase("title")) {
                            isTitle = true;
                        } else if (name.equalsIgnoreCase("price")) {
                            isPrice = true;
                        }
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS: {
                        Characters characters = event.asCharacters();
                        if (isItem) {
                            isItem = false;
                        }
                        if (isTitle) {
                            title = characters.getData();
                            isTitle = false;
                        }
                        if (isPrice) {
                            price = characters.getData();
                            isPrice = false;
                        }
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        EndElement endElement = event.asEndElement();
                        if (endElement.getName().getLocalPart().equalsIgnoreCase("item")) {
                            System.out.println("STAX PARSER:");
                            System.out.println(title + "price: " + price);
                        }
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}