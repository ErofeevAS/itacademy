package com.gmail.erofeev.st.alexei.homework17.impl;

import com.gmail.erofeev.st.alexei.homework17.RandomService;

import java.util.Random;

public class RandomServiceImpl implements RandomService {
    private Random random = new Random();
    private int size;
    private int start;
    private int stop;

    public RandomServiceImpl(int size, int start, int stop) {
        this.size = size;
        this.start = start;
        this.stop = stop;
    }

    @Override
    public Integer[] getArray() {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = getRandomInt(start, stop);
        }
        return array;
    }

    @Override
    public String getRandomNumbersLine(int length) {
        String line = "";
        for (int i = 0; i < length; i++) {
            line += getRandomInt(start, stop) + ",";
        }
        return line.substring(0, line.length() - 1);
    }

    private Integer getRandomInt(int start, int stop) {
        return random.nextInt(stop - start + 1) + start;
    }
}
