package com.gmail.erofeev.st.alexei.controlwork2.parser;

import com.gmail.erofeev.st.alexei.controlwork2.XMLParser;
import com.gmail.erofeev.st.alexei.controlwork2.enums.XMLParserEnum;

public class XMLParserFactory {

    public XMLParser getXMLParser(XMLParserEnum parser) {
        switch (parser) {
            case DOM:
                return new DOMXMLParserImpl();
            case STAX:
                return new STAXXMLParserImpl();
            case SAX:
                return new SAXXMLParserImpl();
            case JAXB:
                return new JAXBXMLParserImpl();
            default:
                throw new IllegalArgumentException("WRONG TYPE");
        }
    }
}
