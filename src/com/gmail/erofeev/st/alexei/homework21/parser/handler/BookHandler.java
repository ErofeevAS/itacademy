package com.gmail.erofeev.st.alexei.homework21.parser.handler;

import com.gmail.erofeev.st.alexei.homework21.BookService;
import com.gmail.erofeev.st.alexei.homework21.impl.BookServiceImpl;
import com.gmail.erofeev.st.alexei.homework21.model.Book;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class BookHandler extends DefaultHandler {
    BookService bookService = BookServiceImpl.getInstance();
    boolean isBook = false;
    boolean isAuthor = false;
    boolean isTitle = false;
    boolean isGenre = false;
    boolean isPrice = false;
    boolean isPublishDate = false;
    boolean isDescription = false;
    private String id = "";
    private String author = "";
    private String title = "";
    private String genre = "";
    private Float price = 0f;
    private String publishDate = "";
    private String description = "";
    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            String id = attributes.getValue("id");
        } else if (qName.equalsIgnoreCase("title")) {
            isTitle = true;
        } else if (qName.equalsIgnoreCase("genre")) {
            isGenre = true;
        } else if (qName.equalsIgnoreCase("price")) {
            isPrice = true;
        } else if (qName.equalsIgnoreCase("publish_date")) {
            isPublishDate = true;
        } else if (qName.equalsIgnoreCase("description")) {
            isDescription = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("catalog")) {
           // bookService.showBooksInfo(books);
           // System.out.println("SAX Average = " + bookService.getAveragePriceForBook(books));
        }
        if (qName.equalsIgnoreCase("book")) {
            Book book = Book.newBuilder().id(id).
                    author(author).title(title).
                    genre(genre).price(price).
                    date(publishDate).description(description).build();
            books.add(book);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isBook) {
            isBook = false;
        } else if (isAuthor) {
            author = new String(ch, start, length);
            isAuthor = false;
        } else if (isTitle) {
            title = new String(ch, start, length);
            isTitle = false;
        } else if (isGenre) {
            genre = new String(ch, start, length);
            isGenre = false;
        } else if (isPrice) {
            price = Float.parseFloat(new String(ch, start, length));
            isPrice = false;
        } else if (isPublishDate) {
            publishDate = new String(ch, start, length);
            isPublishDate = false;
        } else if (isDescription) {
            description = new String(ch, start, length);
            isDescription = false;
        }
    }


}
