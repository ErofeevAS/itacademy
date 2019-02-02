package com.gmail.erofeev.st.alexei.homework21.impl;

import com.gmail.erofeev.st.alexei.homework19.RandomService;
import com.gmail.erofeev.st.alexei.homework19.impl.RandomServiceImpl;
import com.gmail.erofeev.st.alexei.homework21.BookService;
import com.gmail.erofeev.st.alexei.homework21.model.Book;

import java.util.List;

public class BookServiceImpl implements BookService {
    private static volatile BookService instance = null;

    private BookServiceImpl() {
    }

    public static BookService getInstance() {
        if (instance == null) {
            synchronized (RandomService.class) {
                if (instance == null) {
                    instance = new BookServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public void showBooksInfo(List<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Override
    public float getAveragePriceForBook(List<Book> books) {
        float totalPrice = 0;
        for (Book book : books) {
            totalPrice += book.getPrice();
        }
        return totalPrice / books.size();
    }
}
