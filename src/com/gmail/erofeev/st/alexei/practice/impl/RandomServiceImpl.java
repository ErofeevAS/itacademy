package com.gmail.erofeev.st.alexei.practice.impl;

import com.gmail.erofeev.st.alexei.practice.RandomService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomServiceImpl implements RandomService {
    private Random random = new Random();

    private volatile static RandomServiceImpl instance = null;

    private RandomServiceImpl() {
    }

    public static RandomServiceImpl getInstance() {
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
    public List<Integer> getRandomArray(int size, int rangeStart, int rangeStop) {
        List<Integer> randomList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            randomList.add(getRandom(rangeStart, rangeStop));
        }
        return randomList;
    }

    @Override
    public int getRandomInt(int rangeStart, int rangeStop) {
        return getRandom(rangeStart, rangeStop);
    }

    private int getRandom(int start, int stop) {
        return random.nextInt(stop - start) + start;
    }
}
