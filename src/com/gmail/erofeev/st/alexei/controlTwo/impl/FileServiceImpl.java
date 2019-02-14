package com.gmail.erofeev.st.alexei.controlTwo.impl;

import com.gmail.erofeev.st.alexei.controlTwo.FileService;
import com.gmail.erofeev.st.alexei.controlTwo.model.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileService {
    private final String SEPARATOR = " ";

    private volatile static FileServiceImpl instance = null;

    private FileServiceImpl() {
    }

    public static FileServiceImpl getInstance() {
        if (instance == null) {
            synchronized (FileService.class) {
                if (instance == null) {
                    instance = new FileServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public void write(File file, String[] words, boolean append) {
        String name = Thread.currentThread().getName();
        synchronized (file) {
            System.out.println(name + "start write to file: " + file);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, append))) {
                for (String word : words) {
                    writer.write(word + SEPARATOR);
                }
                writer.write(System.lineSeparator());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(name + "stop write to file: " + file);
        }
    }

    @Override
    public void writePlayer(File file, List<Player> players) {

        synchronized (file) {
            String name = Thread.currentThread().getName();
            System.out.println(name + "start write to file: " + file);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (Player player : players) {
                    writer.write(player.toString());
                    writer.write(System.lineSeparator());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(name + "stop write to file: " + file);
        }
    }

    @Override
    public List<Player> readPlayer(File file) {
        synchronized (file) {
            List<Player> players = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line = reader.readLine();
                while (line != null) {
                    String[] parameters = line.split(",");
                    for (int i = 0; i < parameters.length; i++) {
                        String name = parameters[0];
                        Integer age = Integer.parseInt(parameters[1]);
                        boolean isActive = Boolean.parseBoolean(parameters[2]);
                        Player player = new Player(name, age, isActive);
                        players.add(player);
                    }
                    line = reader.readLine();
                }

                return players;
            } catch (FileNotFoundException e) {
                e.getMessage();
                e.printStackTrace();
            } catch (IOException e) {
                e.getMessage();
                e.printStackTrace();
            }
        }
        return null;
    }
}
