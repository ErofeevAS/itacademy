package com.gmail.erofeev.st.alexei.homework17.thread;

import java.util.List;
import java.util.concurrent.Callable;

public class SumCalculatorThread implements Callable<Integer> {
    private List<String> lines;
    private final static String SEPARATOR = ",";

    public SumCalculatorThread(List<String> lines) {
        this.lines = lines;
    }

    @Override
    public Integer call() throws Exception {
        return getSum(lines);
    }

    private int getSum(List<String> lines) {
        int sum = 0;
        for (String line : lines) {
            String[] numbers = line.split(SEPARATOR);
            for (String number : numbers) {
                sum += Integer.parseInt(number);
            }
        }
        return sum;
    }
}
