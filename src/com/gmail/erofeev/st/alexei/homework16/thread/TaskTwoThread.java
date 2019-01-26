package com.gmail.erofeev.st.alexei.homework16.thread;

import com.gmail.erofeev.st.alexei.homework16.FileService;
import com.gmail.erofeev.st.alexei.homework16.RandomService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskTwoThread extends Thread {
    private RandomService randomService;
    private FileService fileService;


    public TaskTwoThread(RandomService randomService, FileService fileService) {
        this.randomService = randomService;
        this.fileService = fileService;

    }

    private String arrayToString(Integer[] array) {
        String line = "";
        for (Integer integer : array) {
            line += integer + " ";
        }
        return line.trim();
    }

    @Override
    public void run() {
        Integer[] array = randomService.getArray();
        List<String> text = new ArrayList<>();
        text.add(arrayToString(array));
        // synchronized (fileService) {
        fileService.writeFile(text, true);
        //}

    }


}
