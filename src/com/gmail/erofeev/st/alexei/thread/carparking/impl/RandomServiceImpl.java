package com.gmail.erofeev.st.alexei.thread.carparking.impl;

import com.gmail.erofeev.st.alexei.thread.carparking.RandomService;

import java.util.Random;

public class RandomServiceImpl implements RandomService {
    private Random random = new Random();
    private static volatile RandomService instance = null;

    private RandomServiceImpl() {
    }

    public static RandomService getInstance() {
        if (instance == null) {
            synchronized (RandomService.class) {
                if (instance == null) {
                    instance = new RandomServiceImpl();
                }
            }
        }
        return instance;
    }


    @Override
    public int getRandom(int start, int stop) {
        return random.nextInt(stop - start) + start;
    }
}
