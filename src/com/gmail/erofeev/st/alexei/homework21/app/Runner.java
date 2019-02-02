package com.gmail.erofeev.st.alexei.homework21.app;

import com.gmail.erofeev.st.alexei.homework21.BookService;
import com.gmail.erofeev.st.alexei.homework21.ParserService;
import com.gmail.erofeev.st.alexei.homework21.impl.BookServiceImpl;
import com.gmail.erofeev.st.alexei.homework21.parser.DomParserServiceImpl;
import com.gmail.erofeev.st.alexei.homework21.parser.STaXParserServiceImpl;
import com.gmail.erofeev.st.alexei.homework21.model.Book;
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

        BookService bookService =  BookServiceImpl.getInstance();
        File file = new File("src/com/gmail/erofeev/st/alexei/homework21/catalog.xml");

        //DOM
        System.out.println("--------DOM-------");
        ParserService domParserService = new DomParserServiceImpl();
        List<Book> catalog = domParserService.getBooks(file);
        bookService.showBooksInfo(catalog);
        System.out.println("Average = " + bookService.getAveragePriceForBook(catalog));

        //STaX
        System.out.println("--------STaX-------");
        ParserService staxParserService = new STaXParserServiceImpl();
        catalog = domParserService.getBooks(file);
        bookService.showBooksInfo(catalog);
        System.out.println("Average = " + bookService.getAveragePriceForBook(catalog));

        //SAX
        System.out.println("--------SaX-------");
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler bookHandler = new BookHandler();
            saxParser.parse(file,bookHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
