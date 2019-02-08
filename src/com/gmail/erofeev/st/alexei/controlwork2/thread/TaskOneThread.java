package com.gmail.erofeev.st.alexei.controlwork2.thread;

import com.gmail.erofeev.st.alexei.controlwork2.ArrayService;
import com.gmail.erofeev.st.alexei.controlwork2.FileService;
import com.gmail.erofeev.st.alexei.controlwork2.impl.ArrayServiceImpl;
import com.gmail.erofeev.st.alexei.controlwork2.impl.FileServiceImpl;

import java.io.File;

public class TaskOneThread extends Thread {
    private int arraySize;
    private int startRange;
    private int stopRange;
    private File file;
    private ArrayService arrayService = ArrayServiceImpl.getInstance();
    private FileService fileService = FileServiceImpl.getInstance();

    public TaskOneThread(int arraySize, int startRange, int stopRange, File file) {
        this.arraySize = arraySize;
        this.startRange = startRange;
        this.stopRange = stopRange;
        this.file = file;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        int[] array = arrayService.getArray(arraySize, startRange, stopRange);
        int[] max = new int[1];
        max[0] = arrayService.findMAx(array);
        fileService.write(file, array, true);
        fileService.write(file, max, true);
        System.out.println(Thread.currentThread().getName() + " stopped");
    }
}
