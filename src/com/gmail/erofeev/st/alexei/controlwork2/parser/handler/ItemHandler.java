package com.gmail.erofeev.st.alexei.controlwork2.parser.handler;

import com.gmail.erofeev.st.alexei.homework21.model.Book;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ItemHandler extends DefaultHandler {
    boolean isItem = false;
    boolean isTitle = false;
    boolean isPrice = false;
    private String title;
    private String price;

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("SAX parser:");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("item")) {
            isItem = true;
        } else if (qName.equalsIgnoreCase("title")) {
            isTitle = true;
        } else if (qName.equalsIgnoreCase("price")) {
            isPrice = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("item")) {
            System.out.println(title + "price: " + price);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isItem) {
            isItem = false;
        } else if (isTitle) {
            title = new String(ch, start, length);
            isTitle = false;
        } else if (isPrice) {
            price = new String(ch, start, length);
            isPrice = false;
        }
    }
}
