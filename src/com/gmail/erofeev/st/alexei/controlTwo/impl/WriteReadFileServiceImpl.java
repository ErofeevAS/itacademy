package com.gmail.erofeev.st.alexei.controlTwo.impl;

import com.gmail.erofeev.st.alexei.controlTwo.ConsoleService;
import com.gmail.erofeev.st.alexei.controlTwo.WriteReadFileService;
import com.gmail.erofeev.st.alexei.controlTwo.model.Player;
import com.gmail.erofeev.st.alexei.controlTwo.thread.PlayerGeneratorTask;
import com.gmail.erofeev.st.alexei.controlTwo.thread.PlayerReaderTask;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WriteReadFileServiceImpl implements WriteReadFileService {

    private static volatile WriteReadFileService instance = null;

    private WriteReadFileServiceImpl() {
    }

    public static WriteReadFileService getInstance() {
        if (instance == null) {
            synchronized (WriteReadFileService.class) {
                if (instance == null) {
                    instance = new WriteReadFileServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<File> startWrite(int amount) {
        List<File> files = new ArrayList<>();
        List<Future<File>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(amount);
        for (int i = 0; i < amount; i++) {
            Future<File> future = executorService.submit(new PlayerGeneratorTask());
            futures.add(future);
        }
        executorService.shutdown();
        files.clear();
        for (Future<File> future : futures) {
            try {
                files.add(future.get());
            } catch (InterruptedException e) {
                e.getMessage();
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.getMessage();
                e.printStackTrace();
            }
        }
        return files;
    }

    @Override
    public List<String> startRead(List<File> files, int amount) {
        List<Future<List<Player>>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(files.size());
        for (int i = 0; i < files.size(); i++) {
            Future<List<Player>> future = executorService.submit(new PlayerReaderTask(files.get(i)));
            futures.add(future);
        }
        executorService.shutdown();

        List<List<Player>> allPlayer = new ArrayList<>();
        List<Player> players = new ArrayList<>();
        allPlayer = new ArrayList<>();
        for (Future<List<Player>> future : futures) {
            try {
                players = future.get();
                allPlayer.add(players);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return showPlayer(allPlayer);
    }

    private List<String> showPlayer(List<List<Player>> allPlayer) {
        List<String> names = new ArrayList<>();
        int counter = 0;
        for (List<Player> allplayer : allPlayer) {
            for (Player player : allplayer) {
                int age = player.getAge();
                if ((age > 25) && (age < 30) && (player.isActive())) {
                    System.out.println(player);
                    System.out.println(counter++);
                    names.add(player.getName());
                }
            }
        }
        return names;

    }
}
