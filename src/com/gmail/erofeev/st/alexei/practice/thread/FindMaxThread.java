package com.gmail.erofeev.st.alexei.practice.thread;

import java.util.List;
import java.util.concurrent.Callable;

public class FindMaxThread implements Callable<Integer> {
    private List<Integer> dataPart;

    public FindMaxThread(List<Integer> dataPart) {
        this.dataPart = dataPart;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " started");
        return findMax(dataPart);
    }
    private int findMax(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (Integer integer : list) {
            max = Math.max(max, integer);
        }
        return max;
    }
}
