package com.gmail.erofeev.st.alexei.controlwork2.parser;

import com.gmail.erofeev.st.alexei.controlwork2.XMLParser;
import com.gmail.erofeev.st.alexei.controlwork2.parser.handler.ItemHandler;
import com.gmail.erofeev.st.alexei.homework21.parser.handler.BookHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAXXMLParserImpl implements XMLParser {
    @Override
    public void showTitleAndPriceForItem(File file) {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser saxParser = factory.newSAXParser();
            DefaultHandler itemHandler = new ItemHandler();
            saxParser.parse(file, itemHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
