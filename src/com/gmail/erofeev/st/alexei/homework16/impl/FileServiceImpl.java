package com.gmail.erofeev.st.alexei.homework16.impl;

import com.gmail.erofeev.st.alexei.homework16.FileService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileServiceImpl implements FileService {
    private String fileName;

    public FileServiceImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void writeFile(List<String> text, boolean append) {
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
    public List<String> readFile() {
        throw new UnsupportedOperationException();
    }
}
