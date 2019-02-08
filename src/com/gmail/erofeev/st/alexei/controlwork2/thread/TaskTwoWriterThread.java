package com.gmail.erofeev.st.alexei.controlwork2.thread;

import com.gmail.erofeev.st.alexei.controlwork2.FileService;
import com.gmail.erofeev.st.alexei.controlwork2.ListService;
import com.gmail.erofeev.st.alexei.controlwork2.impl.FileServiceImpl;
import com.gmail.erofeev.st.alexei.controlwork2.impl.ListServiceImpl;

import java.io.File;
import java.util.List;

public class TaskTwoWriterThread implements Runnable {
    private File file;
    private FileService fileService = FileServiceImpl.getInstance();
    private ListService listService = ListServiceImpl.getInstance();
    private int size;
    private int start;
    private int stop;

    public TaskTwoWriterThread(File file, int size, int start, int stop) {
        this.file = file;
        this.size = size;
        this.start = start;
        this.stop = stop;
    }

    @Override
    public void run() {
//        synchronized (file) {
            System.out.println("Writer " + Thread.currentThread().getName() + " started");
            List<Integer> numbers = listService.getList(size, start, stop);
            fileService.writeList(file, numbers, true);
            System.out.println("Writer " + Thread.currentThread().getName() + " stopped");
//            file.notify();
//        }
    }
}
