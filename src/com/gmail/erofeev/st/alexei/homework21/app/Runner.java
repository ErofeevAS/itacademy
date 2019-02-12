package com.gmail.erofeev.st.alexei.homework21.app;

import com.gmail.erofeev.st.alexei.homework21.BookService;
import com.gmail.erofeev.st.alexei.homework21.ParserService;
import com.gmail.erofeev.st.alexei.homework21.XMLParserFactory;
import com.gmail.erofeev.st.alexei.homework21.enums.XMLParser;
import com.gmail.erofeev.st.alexei.homework21.impl.BookServiceImpl;
import com.gmail.erofeev.st.alexei.homework21.parser.DomParserServiceImpl;
import com.gmail.erofeev.st.alexei.homework21.parser.SAXParserServiceImpl;
import com.gmail.erofeev.st.alexei.homework21.parser.STaXParserServiceImpl;
import com.gmail.erofeev.st.alexei.homework21.model.Book;
import com.gmail.erofeev.st.alexei.homework21.parser.XMLParserFactoryImpl;
import com.gmail.erofeev.st.alexei.homework21.parser.handler.BookHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        BookService bookService = BookServiceImpl.getInstance();
        File file = new File("src/com/gmail/erofeev/st/alexei/homework21/catalog.xml");
        File xsd = new File("src/com/gmail/erofeev/st/alexei/homework21/catalog.xsd");
        XMLParserFactory xmlParserFactory = new XMLParserFactoryImpl();

        //DOM
        System.out.println("--------DOM-------");
        ParserService domParserService = xmlParserFactory.getXMLParser(XMLParser.DOM);
        List<Book> catalog = domParserService.getBooks(file,xsd);
        bookService.showBooksInfo(catalog);
        System.out.println("Average = " + bookService.getAveragePriceForBook(catalog));

        //STaX
        System.out.println("--------STaX-------");
        ParserService staxParserService = xmlParserFactory.getXMLParser(XMLParser.STAX);
        catalog = staxParserService.getBooks(file,xsd);
        bookService.showBooksInfo(catalog);
        System.out.println("Average = " + bookService.getAveragePriceForBook(catalog));

        //SAX
        System.out.println("--------SAX-------");
        ParserService saxParserService = xmlParserFactory.getXMLParser(XMLParser.SAX);
        catalog = saxParserService.getBooks(file,xsd);
        bookService.showBooksInfo(catalog);
        System.out.println("Average = " + bookService.getAveragePriceForBook(catalog));


    }
}
