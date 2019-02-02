package com.gmail.erofeev.st.alexei.homework21.parser;

import com.gmail.erofeev.st.alexei.homework21.ParserService;
import com.gmail.erofeev.st.alexei.homework21.model.Book;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class STaXParserServiceImpl implements ParserService {
    boolean isBook = false;
    boolean isAuthor = false;
    boolean isTitle = false;
    boolean isGenre = false;
    boolean isPrice = false;
    boolean isPublishDate = false;
    boolean isDescription = false;

    @Override
    public List<Book> getBooks(File file) {
        List<Book> books = new ArrayList<>();
        try {
            XMLInputFactory factory = XMLInputFactory.newFactory();
            XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(file));
            String id = "";
            String author = "";
            String title = "";
            String genre = "";
            Float price = 0f;
            String publishDate = "";
            String description = "";

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT: {
                        StartElement startElement = event.asStartElement();
                        String name = startElement.getName().getLocalPart();

                        if (name.equalsIgnoreCase("book")) {
                            isBook = true;
                        } else if (name.equalsIgnoreCase("author")) {
                            Iterator<Attribute> attributes = startElement.getAttributes();
                            Attribute nextAttribute = attributes.next();
                            if (nextAttribute.getName().equals("id")) {
                                id = nextAttribute.getValue();
                            }
                            isAuthor = true;
                        } else if (name.equalsIgnoreCase("title")) {
                            isTitle = true;
                        } else if (name.equalsIgnoreCase("genre")) {
                            isGenre = true;
                        } else if (name.equalsIgnoreCase("price")) {
                            isPrice = true;
                        } else if (name.equalsIgnoreCase("publish_date")) {
                            isPublishDate = true;
                        } else if (name.equalsIgnoreCase("description")) {
                            isDescription = true;
                        }
                        break;
                    }

                    case XMLStreamConstants.CHARACTERS: {
                        Characters characters = event.asCharacters();
                        if (isBook) {
//                            info = characters.getData();
                            isBook = false;
                        }
                        if (isAuthor) {
                            author = characters.getData();
                            isAuthor = false;
                        }
                        if (isTitle) {
                            title = characters.getData();
                            isTitle = false;
                        }
                        if (isGenre) {
                            genre = characters.getData();
                            isGenre = false;
                        }
                        if (isPrice) {
                            price = Float.parseFloat(characters.getData());
                            isPrice = false;
                        }
                        if (isPublishDate) {
                            publishDate = characters.getData();
                            isPublishDate = false;
                        }
                        if (isDescription) {
                            description = characters.getData();
                            isDescription = false;
                        }
                        break;
                    }

                    case XMLStreamConstants.END_ELEMENT: {
                        EndElement endElement = event.asEndElement();
                        if (endElement.getName().getLocalPart().equalsIgnoreCase("book")) {
                            Book book = Book.newBuilder().id(id).
                                    author(author).title(title).
                                    genre(genre).price(price).
                                    date(publishDate).description(description).build();
                            books.add(book);
                        }
                        break;
                    }

                }


            }

        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                XMLStreamException e) {
            e.printStackTrace();
        }
        return books;
    }
}

