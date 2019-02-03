package com.gmail.erofeev.st.alexei.homework21.parser;

import com.gmail.erofeev.st.alexei.homework21.ParserService;
import com.gmail.erofeev.st.alexei.homework21.model.Book;
import com.gmail.erofeev.st.alexei.homework21.parser.handler.BookHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SAXParserServiceImpl implements ParserService {

    private List<Book> parse(File file) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser saxParser = factory.newSAXParser();
            DefaultHandler bookHandler = new BookHandler();
            saxParser.parse(file, bookHandler);
            return ((BookHandler) bookHandler).getBooks();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<Book> getBooks(File file) {
        return parse(file);
    }
}
