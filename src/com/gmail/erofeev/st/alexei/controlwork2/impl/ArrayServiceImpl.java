package com.gmail.erofeev.st.alexei.controlwork2.impl;

import com.gmail.erofeev.st.alexei.controlwork2.ArrayService;
import com.gmail.erofeev.st.alexei.controlwork2.RandomService;

public class ArrayServiceImpl implements ArrayService {
    private RandomService randomService = RandomServiceImpl.getInstance();
    private static volatile ArrayService instance = null;

    private ArrayServiceImpl() {
    }

    public static ArrayService getInstance() {
        if (instance == null) {
            synchronized (ArrayService.class) {
                if (instance == null) {
                    instance = new ArrayServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public int[] getArray(int size, int start, int stop) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = randomService.getInt(start, stop);
        }
        return array;
    }

    @Override
    public int findMAx(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            max = Math.max(i, max);
        }
        return max;
    }
}
