package com.gmail.erofeev.st.alexei.homework16.thread;

import com.gmail.erofeev.st.alexei.homework16.ArrayService;
import com.gmail.erofeev.st.alexei.homework16.RandomService;

public class TaskOneThread extends  Thread{
    private RandomService randomService;
    private ArrayService arrayService;
    private int size;
    private int start;
    private int stop;

    public TaskOneThread(RandomService randomService, ArrayService arrayService, int size, int start, int stop) {
        this.randomService = randomService;
        this.arrayService = arrayService;
        this.size = size;
        this.start = start;
        this.stop = stop;
    }

    @Override
    public void run() {
        synchronized (this) {
            Integer[] array = randomService.getArray();
            int max = arrayService.findMax(array);
            System.out.println(Thread.currentThread().getName() + ": " + max);
        }
    }
}
