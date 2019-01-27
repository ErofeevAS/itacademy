package com.gmail.erofeev.st.alexei.homework17.thread;

import com.gmail.erofeev.st.alexei.homework17.RandomService;
import com.gmail.erofeev.st.alexei.homework17.impl.RandomServiceImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FileReaderThread implements Runnable {
    private final static int COUNT_FOR_NEW_THREAD = 10;
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private String fileName;

    public FileReaderThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        readFile(fileName);
    }


    private void readFile(String fileName) {
        List<Future<Integer>> futureList = new ArrayList<>();
        File file = new File(fileName);
        List<String> text = new ArrayList<>();
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                if (count != COUNT_FOR_NEW_THREAD) {
                    text.add(line);
                    line = reader.readLine();
                    count++;
                } else {
                    count = 0;
                    List<String> newText = new ArrayList<>(text);
                    Callable<Integer> sumCalculatorThread = new SumCalculatorThread(newText);
                    text.clear();
                    Future<Integer> submit = executorService.submit(sumCalculatorThread);
                    futureList.add(submit);
                }
            }
            System.out.println("MAX is " + getMaxSum(futureList));
            executorService.shutdown();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getMaxSum(List<Future<Integer>> futureList) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        while (count < futureList.size()) {
            max = 0;
            count = 0;
            for (Future<Integer> future : futureList) {
                if (future.isDone()) {
                    try {
                        max = Math.max(max,future.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    count++;
                }
            }
        }
        return max;
    }
}
