package com.gmail.erofeev.st.alexei.homework21.parser;

import com.gmail.erofeev.st.alexei.homework21.ParserService;
import com.gmail.erofeev.st.alexei.homework21.model.Book;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParserServiceImpl implements ParserService {

    @Override
    public List<Book> getBooks(File file) {
        List<Book> books = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document doc = documentBuilder.parse(file);
            Element root = doc.getDocumentElement();
            root.normalize();
            NodeList list = root.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    if (node.getNodeName().equalsIgnoreCase("book")) {
                        Element element = (Element) node;
                        String id = element.getAttribute("id");
                        String author = element.getElementsByTagName("author").item(0).getTextContent();
                        String title = element.getElementsByTagName("title").item(0).getTextContent();
                        String genre = element.getElementsByTagName("genre").item(0).getTextContent();
                        Float price = Float.parseFloat(element.getElementsByTagName("price").item(0).getTextContent());
                        String publishDate = element.getElementsByTagName("publish_date").item(0).getTextContent();
                        String description = element.getElementsByTagName("description").item(0).getTextContent();
                        Book book = Book.newBuilder().id(id).
                                author(author).title(title).
                                genre(genre).price(price).
                                date(publishDate).description(description).build();
                        books.add(book);
                    }
                }
            }


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;
    }

}

