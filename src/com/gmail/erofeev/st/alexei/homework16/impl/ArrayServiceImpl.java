package com.gmail.erofeev.st.alexei.homework16.impl;

import com.gmail.erofeev.st.alexei.homework16.ArrayService;

public class ArrayServiceImpl implements ArrayService {
    @Override
    public Integer findMax(Integer[] array) {
        Integer max = 0;
        if (array.length != 0) {
            max = array[0];
            for (int number : array) {
                max = Math.max(max, number);
            }
        }
        return max;


    }

    @Override
    public void showArray(Integer[] array) {
        synchronized (this) {
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
