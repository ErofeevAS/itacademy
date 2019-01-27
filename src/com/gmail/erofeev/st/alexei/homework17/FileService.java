package com.gmail.erofeev.st.alexei.homework17;

import java.util.List;

public interface FileService {

    void writeFile(List<String> text, String fileName, boolean append);

    List<String> readFile(String fileName);
}
