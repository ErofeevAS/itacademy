package com.gmail.erofeev.st.alexei.homework13.impl;

import com.gmail.erofeev.st.alexei.homework13.IArrayService;

import java.util.Random;

public class ArrayServiceImpl implements IArrayService {
    private Random random = new Random();

    @Override
    public void showMinElement(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int element : array) {
            min = Math.min(min, element);
        }
        System.out.println("Min element: " + min);
    }

    @Override
    public int[] getArray(String str) {
        String[] elements = str.split(" ");
        int[] array = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            array[i] = Integer.parseInt(elements[i]);
        }
        return array;
    }

    public int[] generateArray(int size, int randomRange) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt() % randomRange;
        }
        return array;
    }

    @Override
    public void showArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    @Override
    public String arrayToString(int[] array) {
        String line = "";
        for (int element : array) {
            line += element + " ";
        }
        return line;
    }

}
