package com.gmail.erofeev.st.alexei.controlworkTwo.impl;

import com.gmail.erofeev.st.alexei.controlworkTwo.RandomService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomServiceImpl implements RandomService {
    private Random random = new Random();

    private volatile static RandomService instance = null;

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
    public List<Integer> getRandomList(int size, int start, int stop) {
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(getRandomInt(start, stop));
        }
        return list;
    }

    @Override
    public int getRandomInt(int start, int stop) {
        return getRandomIntFromRange(start, stop);
    }

    private int getRandomIntFromRange(int start, int stop) {
        return random.nextInt(stop - start) + start;
    }
}
