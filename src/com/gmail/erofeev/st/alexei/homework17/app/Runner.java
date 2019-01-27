package com.gmail.erofeev.st.alexei.homework17.app;

import com.gmail.erofeev.st.alexei.homework17.FileService;
import com.gmail.erofeev.st.alexei.homework17.RandomService;
import com.gmail.erofeev.st.alexei.homework17.impl.FileServiceImpl;
import com.gmail.erofeev.st.alexei.homework17.impl.RandomServiceImpl;
import com.gmail.erofeev.st.alexei.homework17.thread.FileCreatorThread;
import com.gmail.erofeev.st.alexei.homework17.thread.FileReaderThread;
import com.gmail.erofeev.st.alexei.homework17.thread.TaskOneThread;
import com.gmail.erofeev.st.alexei.homework17.thread.TaskTwoThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Runner {

    public static void main(String[] args) {
        //task1
        FileService fileService = new FileServiceImpl();
        String fileName = "src/com/gmail/erofeev/st/alexei/homework17/files/task1.txt";
        String newFileName = "src/com/gmail/erofeev/st/alexei/homework17/files/newTask1.txt";
        Thread t1 = new Thread(new TaskOneThread(fileService, fileName, newFileName));
        t1.start();

        //task2
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        RandomService randomService = new RandomServiceImpl(10, 0, 100);
        List<Future<Integer>> futureList = new ArrayList<>();
        int amountThreads = 10;
        for (int i = 0; i < amountThreads; i++) {
            Callable<Integer> taskTwoThread = new TaskTwoThread(randomService);
            Future<Integer> submit = executorService.submit(taskTwoThread);
            futureList.add(submit);
        }
        executorService.shutdown();

        System.out.println();
        int average = 0;
        int count = 0;
        while (count < futureList.size()) {
            average = 0;
            count = 0;
            for (Future<Integer> future : futureList) {
                if (future.isDone()) {
                    try {
                        average += future.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    count++;
                }
            }
            average = average / amountThreads;
        }
        System.out.println("Average is " + average);

        //task3
        System.out.println();
        String fileNameTaskThree = "src/com/gmail/erofeev/st/alexei/homework17/files/task3.txt";
        Thread t3 = new Thread(new FileCreatorThread(fileService,randomService,fileNameTaskThree,4,1000));
        t3.start();
        try {
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread fileReaderThread = new Thread(new FileReaderThread(fileNameTaskThree));
        fileReaderThread.start();


    }
}
