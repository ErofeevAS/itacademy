package com.gmail.erofeev.st.alexei.controlTwo;

import com.gmail.erofeev.st.alexei.controlTwo.model.Player;

import java.io.File;
import java.util.List;

public interface FileService {
    void write(File file, String[] words, boolean append);

    void writePlayer(File file, List<Player> players);

    List<Player> readPlayer(File file);

}
