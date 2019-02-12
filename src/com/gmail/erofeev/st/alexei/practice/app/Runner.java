package com.gmail.erofeev.st.alexei.practice.app;

import com.gmail.erofeev.st.alexei.practice.RandomService;
import com.gmail.erofeev.st.alexei.practice.impl.RandomServiceImpl;
import com.gmail.erofeev.st.alexei.practice.thread.FindMaxThread;
import com.gmail.erofeev.st.alexei.practice.thread.RandomTextGeneratorThread;
import com.gmail.erofeev.st.alexei.practice.thread.TaskTwoThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Runner {
    public static volatile int THREAD_COUNTER = 0;

    public static void main(String[] args) {

        RandomService randomService = RandomServiceImpl.getInstance();

        //task1
//        List<Integer> randomList = randomService.getRandomArray(100, -50, 50);
//        for (Integer integer : randomList) {
//            System.out.print(integer + ", ");
//        }
//        System.out.println();
//
//        List<Future<Integer>> futureList = new ArrayList<>();
//        int amountThreads = 10;
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        for (int i = 0; i < amountThreads; i++) {
//            Future<Integer> submit = executorService.submit(new FindMaxThread(randomList.subList(i * amountThreads, (i + 1) * amountThreads)));
//            futureList.add(submit);
//        }
//        executorService.shutdown();
//        System.out.println();
//        int count = 0;
//        int max = Integer.MIN_VALUE;
//        while (count < futureList.size()) {
//            count = 0;
//            for (Future<Integer> future : futureList) {
//                if (future.isDone()) {
//                    try {
//                        max = Math.max(max, future.get());
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } catch (ExecutionException e) {
//                        e.printStackTrace();
//                    }
//                    count++;
//                }
//            }
//        }
//        System.out.println("Max is " + max);

        //task2
//        String massege = "Hello from Thread ";
//        Thread task2 = new Thread(new TaskTwoThread(massege));
//        task2.start();

        //task3
        int amountOfThread = 50;
        ExecutorService executorService = Executors.newFixedThreadPool(amountOfThread);
        List<Future<String>> futures = new ArrayList<Future<String>>();
        for (int i = 0; i < amountOfThread; i++) {
            Callable<String> thread = new RandomTextGeneratorThread(5, 10, "bvx");
            Future<String> future = executorService.submit(thread);
            futures.add(future);
        }
        executorService.shutdown();
        int maxLength = Integer.MIN_VALUE;
        int count = 0;
        while (count < futures.size()) {
            count = 0;
            for (Future<String> future : futures) {
                if (future.isDone()) {
                    count++;
                    try {
                        maxLength = Math.max(maxLength, future.get().length());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("Max length strings:");
        for (Future<String> future : futures) {
            String result = null;
            try {
                result = future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            if (result.length() == maxLength) {
                System.out.println(result);
            }
        }

    }
}
