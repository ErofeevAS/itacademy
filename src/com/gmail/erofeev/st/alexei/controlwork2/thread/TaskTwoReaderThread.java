package com.gmail.erofeev.st.alexei.controlwork2.thread;

import com.gmail.erofeev.st.alexei.controlwork2.FileService;
import com.gmail.erofeev.st.alexei.controlwork2.impl.FileServiceImpl;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;

public class TaskTwoReaderThread implements Callable<Integer> {
    private File file;
    private FileService fileService = FileServiceImpl.getInstance();
    private final int COUNTER_MAX = 3;

    public TaskTwoReaderThread(File file) {
        this.file = file;
    }

    @Override
    public Integer call() {
        System.out.println("Reader " + Thread.currentThread().getName() + " started");
        int checkingTime = 0;
        int max = 0;
        while (checkingTime <= COUNTER_MAX) {
            List<Integer> list = fileService.readList(file);
            if (list.size() == 0) {
                checkingTime++;
                System.out.println("waiting. Timeout number: " + checkingTime);
            } else {
                max = findMax(list);
                break;
            }
        }
        System.out.println("Reader " + Thread.currentThread().getName() + " stopped");
        return max;

    }

    private int findMax(List<Integer> list) {
        int max = list.get(0);
        for (Integer integer : list) {
            max = Math.max(max, integer);
        }
        return max;
    }
}
