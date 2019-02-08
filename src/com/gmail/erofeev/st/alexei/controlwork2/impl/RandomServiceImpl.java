package com.gmail.erofeev.st.alexei.controlwork2.impl;

import com.gmail.erofeev.st.alexei.controlwork2.RandomService;

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

    public int getInt(int start, int stop) {
        return random.nextInt(stop - start + 1) + start;
    }
}
