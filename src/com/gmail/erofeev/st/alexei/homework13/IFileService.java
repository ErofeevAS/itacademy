package com.gmail.erofeev.st.alexei.homework13;

import java.io.File;

public interface IFileService {
    String[] readFile(File file);

    void writeFile(File file, String[] text, boolean append);

    void writeFile(File file, String text, boolean append);
}
