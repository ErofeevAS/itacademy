package com.gmail.erofeev.st.alexei.homework21;

import com.gmail.erofeev.st.alexei.homework21.enums.XMLParser;

public interface XMLParserFactory {
    ParserService getXMLParser(XMLParser parser);
}
