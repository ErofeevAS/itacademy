package com.gmail.erofeev.st.alexei.homework21.parser;

import com.gmail.erofeev.st.alexei.homework21.ParserService;
import com.gmail.erofeev.st.alexei.homework21.XMLParserFactory;
import com.gmail.erofeev.st.alexei.homework21.enums.XMLParser;

public class XMLParserFactoryImpl implements XMLParserFactory {

    public ParserService getXMLParser(XMLParser parser) {
        switch (parser) {
            case DOM:
                return new DomParserServiceImpl();
            case STAX:
                return new STaXParserServiceImpl();
            case SAX:
                return new SAXParserServiceImpl();
            default:
                throw new IllegalArgumentException();
        }
    }
}
