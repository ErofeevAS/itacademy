package com.gmail.erofeev.st.alexei.controlworkTwo.impl;

import com.gmail.erofeev.st.alexei.controlworkTwo.FileService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileService {
    private volatile static FileService instance = null;

    private FileServiceImpl() {
    }

    public static FileService getInstance() {
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
    public List<Integer> readFile(File file) {
        if (file.exists()) {
            synchronized (file) {
                List<Integer> list = new ArrayList<>();
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line = reader.readLine();
                    if (line == null) {
                        return null;
                    }
                    while (line != null) {
                        list.add(Integer.parseInt(line));
                        line = reader.readLine();
                    }
                } catch (FileNotFoundException e) {
                    System.out.println(file + " not found");
                    e.printStackTrace();
                } catch (IOException e) {
                    System.out.println("Cant read file: " + file);
                    e.printStackTrace();
                }
                try {
                    file.wait(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return list;
            }
        }
        return null;
    }

    @Override
    public void writeFile(File file, List<Integer> list, boolean append) {
        synchronized (file) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, append))) {
                for (Integer integer : list) {
                    writer.write(integer.toString());
                    writer.write(System.lineSeparator());
                }
                file.notify();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
