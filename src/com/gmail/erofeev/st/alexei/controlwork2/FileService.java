package com.gmail.erofeev.st.alexei.controlwork2;

import java.io.File;
import java.util.List;

public interface FileService {
    void write(File file, int[] array, boolean append);

    void writeList(File file, List<Integer> list, boolean append);

    List<Integer> readList(File file);
}
