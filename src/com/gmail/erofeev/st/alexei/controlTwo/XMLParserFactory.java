package com.gmail.erofeev.st.alexei.controlTwo;


import com.gmail.erofeev.st.alexei.controlTwo.enums.XMLParser;

public interface XMLParserFactory {
    ParserService getXMLParser(XMLParser parser);
}
