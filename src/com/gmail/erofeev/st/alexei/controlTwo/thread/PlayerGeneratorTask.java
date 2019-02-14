package com.gmail.erofeev.st.alexei.controlTwo.thread;

import com.gmail.erofeev.st.alexei.controlTwo.FileService;
import com.gmail.erofeev.st.alexei.controlTwo.RandomService;
import com.gmail.erofeev.st.alexei.controlTwo.app.Runner;
import com.gmail.erofeev.st.alexei.controlTwo.impl.FileServiceImpl;
import com.gmail.erofeev.st.alexei.controlTwo.impl.RandomServiceImpl;
import com.gmail.erofeev.st.alexei.controlTwo.model.Player;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;

public class PlayerGeneratorTask implements Callable<File> {
    FileService fileService = FileServiceImpl.getInstance();
    RandomService randomService = RandomServiceImpl.getInstance();


    @Override
    public File call() throws Exception {
        List<Player> players = randomService.getPlayers(10, 20, 40);
        Runner.countOfWriterThread++;
        File file = new File("task2_" + Runner.countOfWriterThread + ".txt");
        fileService.writePlayer(file, players);
        return file;
    }
}
