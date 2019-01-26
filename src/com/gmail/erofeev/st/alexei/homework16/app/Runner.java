package com.gmail.erofeev.st.alexei.homework16.app;

import com.gmail.erofeev.st.alexei.homework16.ArrayService;
import com.gmail.erofeev.st.alexei.homework16.FileService;
import com.gmail.erofeev.st.alexei.homework16.RandomService;
import com.gmail.erofeev.st.alexei.homework16.ThreadService;
import com.gmail.erofeev.st.alexei.homework16.impl.ArrayServiceImpl;
import com.gmail.erofeev.st.alexei.homework16.impl.FileServiceImpl;
import com.gmail.erofeev.st.alexei.homework16.impl.RandomServiceImpl;
import com.gmail.erofeev.st.alexei.homework16.impl.ThreadServiceImpl;
import com.gmail.erofeev.st.alexei.homework16.thread.TaskOneThread;
import com.gmail.erofeev.st.alexei.homework16.thread.TaskThreeTread;
import com.gmail.erofeev.st.alexei.homework16.thread.TaskTwoThread;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        RandomService randomService = new RandomServiceImpl(10, 0, 100);
        ArrayService arrayService = new ArrayServiceImpl();

        //task1
        for (int i = 0; i < 10; i++) {
            Thread thread = new TaskOneThread(randomService,arrayService,10,0,100);
            thread.setName("Thread " + i);
            thread.start();
        }

        //task2
        FileService fileService = new FileServiceImpl("src\\com\\gmail\\erofeev\\st\\alexei\\homework16\\files\\task2.txt");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            TaskTwoThread thread2 = new TaskTwoThread(randomService, fileService);
            thread2.start();
        }

        //task3
        ThreadService threadService = new ThreadServiceImpl();
        for (int i = 0; i < 10; i++) {
            Thread t3 = new TaskThreeTread(threadService);
            t3.start();
        }
    }
}
