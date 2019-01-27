package com.gmail.erofeev.st.alexei.homework17.thread;

import com.gmail.erofeev.st.alexei.homework17.FileService;
import com.gmail.erofeev.st.alexei.homework17.RandomService;

import java.util.ArrayList;
import java.util.List;

public class FileCreatorThread  implements  Runnable{
    private FileService fileService;
    private RandomService randomService;
    private String fileName;
    private int length;
    private int amountLines;

    public FileCreatorThread(FileService fileService, RandomService randomService, String fileName, int length, int amountLines) {
        this.fileService = fileService;
        this.randomService = randomService;
        this.fileName = fileName;
        this.length = length;
        this.amountLines = amountLines;
    }

    @Override
    public void run() {
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < amountLines; i++) {
            String line = randomService.getRandomNumbersLine(length);
            numbers.add(line);
        }
        fileService.writeFile(numbers,fileName,false);


    }
}
