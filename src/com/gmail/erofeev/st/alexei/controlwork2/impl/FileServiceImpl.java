package com.gmail.erofeev.st.alexei.controlwork2.impl;

import com.gmail.erofeev.st.alexei.controlwork2.FileService;
import com.gmail.erofeev.st.alexei.controlwork2.RandomService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileService {
    private final String separator = ",";
    private static volatile FileService instance = null;

    private FileServiceImpl() {
    }

    public static FileService getInstance() {
        if (instance == null) {
            synchronized (RandomService.class) {
                if (instance == null) {
                    instance = new FileServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public synchronized void write(File file, int[] array, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, append))) {
            for (int i : array) {
                writer.write(i + separator);
            }
        } catch (IOException e) {
            System.out.println("Can't write in file");
            e.printStackTrace();
        }
    }

    @Override
    public void writeList(File file, List<Integer> list, boolean append) {
        synchronized (file) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, append))) {
                for (int i : list) {
                    writer.write(i + separator);
                }
            } catch (IOException e) {
                System.out.println("Can't write in file");
                e.printStackTrace();
            }
            file.notify();
        }
    }

    @Override
    public List<Integer> readList(File file) {

        List<Integer> list = new ArrayList<>();
        String line = null;
        synchronized (file) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                line = reader.readLine();
                if (line == null) {
                    file.wait(100);
                }
                while (line != null) {
                    String[] numbers = line.split(",");
                    for (int i = 0; i < numbers.length; i++) {
                        list.add(Integer.parseInt(numbers[i]));
                    }
                    line = reader.readLine();
                }

            } catch (FileNotFoundException e) {
                System.out.println("Can't find file");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Can't read file");
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
