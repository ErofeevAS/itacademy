package com.gmail.erofeev.st.alexei.controlworkTwo;

import java.io.File;
import java.util.List;

public interface FileService {
    List<Integer> readFile(File file);

    void writeFile(File file, List<Integer> list, boolean append);

}
