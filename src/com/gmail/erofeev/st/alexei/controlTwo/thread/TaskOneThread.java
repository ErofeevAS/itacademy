package com.gmail.erofeev.st.alexei.controlTwo.thread;

import com.gmail.erofeev.st.alexei.controlTwo.FileService;
import com.gmail.erofeev.st.alexei.controlTwo.RandomService;
import com.gmail.erofeev.st.alexei.controlTwo.impl.FileServiceImpl;
import com.gmail.erofeev.st.alexei.controlTwo.impl.RandomServiceImpl;

import java.io.File;

public class TaskOneThread implements Runnable {
    private int amountOfWords = 4;
    private String text;
    private File file;
    private RandomService randomService = RandomServiceImpl.getInstance();
    private FileService fileService = FileServiceImpl.getInstance();


    public TaskOneThread(File file, String text) {
        this.file = file;
        this.text = text;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " start write");
        String[] randomWords = getRandomWords(text);
        showArray(randomWords);
        fileService.write(file,randomWords,true);
        System.out.println(name + " stop write");
    }

    private String[] getRandomWords(String text) {
        String[] words = text.split(" ");
        String[] randomWords = new String[amountOfWords];
        for (int i = 0; i < amountOfWords; i++) {
            int randomIndex = randomService.getRandomInt(0, words.length);
            randomWords[i] = words[randomIndex];
        }
        return randomWords;
    }

    private void showArray(String[] array) {
        for (String s : array) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
