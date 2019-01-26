package com.gmail.erofeev.st.alexei.homework16;

import java.io.File;
import java.util.List;

public interface FileService {

    void writeFile( List<String> text, boolean append);

    List<String>readFile();
}
