package com.gmail.erofeev.st.alexei.practice.thread;

import com.gmail.erofeev.st.alexei.practice.RandomService;
import com.gmail.erofeev.st.alexei.practice.impl.RandomServiceImpl;

import java.util.concurrent.Callable;

public class RandomTextGeneratorThread implements Callable<String> {
    private RandomService randomService = RandomServiceImpl.getInstance();
    private int minLength;
    private int maxLength;
    private String randomChars;

    public RandomTextGeneratorThread(int minLength, int maxLength, String randomChars) {
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.randomChars = randomChars;
    }

    @Override
    public String call() {
        System.out.println(Thread.currentThread().getName() + " started");
        char[] chars = randomChars.toCharArray();
        int size = randomService.getRandomInt(minLength, maxLength);
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < size; i++) {
            int randomIndex = randomService.getRandomInt(0, chars.length);
            char randomSymbol = chars[randomIndex];
            randomString.append(randomSymbol);
        }
        System.out.println(randomString.toString());
        System.out.println(Thread.currentThread().getName() + " stopped");
        return randomString.toString();
    }
}
