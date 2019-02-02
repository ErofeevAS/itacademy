package com.gmail.erofeev.st.alexei.homework21;

import com.gmail.erofeev.st.alexei.homework21.model.Book;

import java.util.List;

public interface BookService {

    void showBooksInfo(List<Book> books);

    float getAveragePriceForBook(List<Book> books);

}
