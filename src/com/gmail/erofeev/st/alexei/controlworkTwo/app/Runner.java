package com.gmail.erofeev.st.alexei.controlworkTwo.app;

import com.gmail.erofeev.st.alexei.controlworkTwo.FileService;
import com.gmail.erofeev.st.alexei.controlworkTwo.RandomService;
import com.gmail.erofeev.st.alexei.controlworkTwo.impl.FileServiceImpl;
import com.gmail.erofeev.st.alexei.controlworkTwo.impl.RandomServiceImpl;
import com.gmail.erofeev.st.alexei.controlworkTwo.thread.CreateFileThread;
import com.gmail.erofeev.st.alexei.controlworkTwo.thread.FindMaxFromFileThread;
import com.gmail.erofeev.st.alexei.homework17.thread.FileReaderThread;
import com.gmail.erofeev.st.alexei.practice.thread.FindMaxThread;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Runner {
    public static void main(String[] args) {

        //task1

        int amountOfThread = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(amountOfThread);
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < amountOfThread; i++) {
            File file = new File("file_" + i + ".txt");
            List<Integer> list = RandomServiceImpl.getInstance().getRandomList(10, 0, 10);
            Thread writerThread = new Thread(new CreateFileThread(file, list));
            writerThread.start();
            Future<Integer> future = executorService.submit(new FindMaxFromFileThread(file));
            futures.add(future);
        }
        executorService.shutdown();
        int count = 0;
        int average = 0;
        while (count < futures.size()) {
            average = 0;
            count = 0;
            for (Future<Integer> future : futures) {
                if (future.isDone()) {
                    count++;
                    try {
                        average += future.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        System.out.println("average of max: " + average / futures.size());


    }
}
