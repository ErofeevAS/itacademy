package com.gmail.erofeev.st.alexei.controlwork2.impl;

import com.gmail.erofeev.st.alexei.controlwork2.ThreadService;
import com.gmail.erofeev.st.alexei.controlwork2.thread.TaskOneThread;

import java.io.File;

public class ThreadServiceImpl implements ThreadService {
    private static volatile ThreadService instance = null;

    private ThreadServiceImpl() {
    }

    public static ThreadService getInstance(){
        if(instance==null){
            synchronized (ThreadService.class){
                if(instance==null){
                    instance = new ThreadServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public void startThreads(int amount,File file) {
        for (int i = 0; i < amount; i++) {
            Thread thread = new TaskOneThread(10,-10,50,file);
            thread.setName("Thread - " + i);
            thread.start();
        }

    }
}
