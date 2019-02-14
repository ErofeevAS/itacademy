package com.gmail.erofeev.st.alexei.controlTwo.parser;


import com.gmail.erofeev.st.alexei.controlTwo.ParserService;
import com.gmail.erofeev.st.alexei.controlTwo.XMLParserFactory;
import com.gmail.erofeev.st.alexei.controlTwo.enums.XMLParser;


public class XMLParserFactoryImpl implements XMLParserFactory {

    public ParserService getXMLParser(XMLParser parser) {
        switch (parser) {
            case DOM:
                return new DomParserServiceImpl();
            case STAX:
                return new STaXParserServiceImpl();
            case JAXB:
               return new JAXBXMLParserImpl();
            default:
                throw new IllegalArgumentException();
        }
    }


}
