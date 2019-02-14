package com.gmail.erofeev.st.alexei.controlTwo;

import java.io.File;
import java.util.List;

public interface WriteReadFileService {
    List<File> startWrite(int amount);

    List<String> startRead(List<File> files, int amount);

}
