package com.gmail.erofeev.st.alexei.homework21;

import com.gmail.erofeev.st.alexei.homework21.model.Book;

import java.io.File;
import java.util.List;

public interface ParserService {

    List<Book> getBooks(File file);

}
