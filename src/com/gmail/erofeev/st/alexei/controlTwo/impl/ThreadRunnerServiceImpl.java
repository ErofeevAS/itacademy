package com.gmail.erofeev.st.alexei.controlTwo.impl;

import com.gmail.erofeev.st.alexei.controlTwo.ThreadRunnerService;
import com.gmail.erofeev.st.alexei.controlTwo.thread.TaskOneThread;

import java.io.File;

public class ThreadRunnerServiceImpl implements ThreadRunnerService {

    @Override
    public void startThreads(int amount,String fileName, String text) {
        for (int i = 0; i < amount; i++) {
            File fil = new File(fileName + i + ".txt");
            Thread thread = new Thread(new TaskOneThread(fil, text));
            thread.setName("Thread_" + i);
            thread.start();
        }

    }
}
