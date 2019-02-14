package com.gmail.erofeev.st.alexei.controlTwo.thread;

import com.gmail.erofeev.st.alexei.controlTwo.FileService;
import com.gmail.erofeev.st.alexei.controlTwo.impl.FileServiceImpl;
import com.gmail.erofeev.st.alexei.controlTwo.model.Player;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;

public class PlayerReaderTask implements Callable<List<Player>> {
    private FileService fileService = FileServiceImpl.getInstance();
    private File file;

    public PlayerReaderTask(File file) {
        this.file = file;
    }

    @Override
    public List<Player> call() throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println(name + " start read file: " + file);
        List<Player> players = fileService.readPlayer(file);
        System.out.println(name + " stop read file: " + file);
        return players;
    }
}
