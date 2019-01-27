package com.gmail.erofeev.st.alexei.homework17.impl;

import com.gmail.erofeev.st.alexei.homework17.FileService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileService {


    @Override
    public void writeFile(List<String> text,String fileName, boolean append) {
        File file = new File(fileName);
        File folders = file.getParentFile();
        if (!folders.exists()) {
            if (folders != null) {
                folders.mkdirs();
                System.out.println(folders + " was created");
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, append))) {
            for (String line : text) {
                writer.write(line);
                writer.write(System.lineSeparator());
            }
            System.out.println("File was modify");
        } catch (IOException e) {
            System.out.println("Cant write in file!");
            e.printStackTrace();
        }
    }

    @Override
    public List<String> readFile(String fileName) {
        File file = new File(fileName);
        List<String> text = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                text.add(line);
                line = reader.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Can't found file");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Can'y read file");
            e.printStackTrace();
        }
        return text;
    }
}
