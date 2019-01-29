package com.gmail.erofeev.st.alexei.homework19.impl;

import com.gmail.erofeev.st.alexei.homework19.ListFactory;
import com.gmail.erofeev.st.alexei.homework19.RandomService;
import com.gmail.erofeev.st.alexei.homework19.enums.ListType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListFactoryImpl implements ListFactory {
    private RandomService randomService = RandomServiceImpl.getInstance();
    private int size;
    private int start;
    private int stop;

    public ListFactoryImpl(int size, int start, int stop) {
        this.size = size;
        this.start = start;
        this.stop = stop;
    }

    @Override
    public List<Integer> generateList(ListType type) {
        Integer[] randomArray = randomService.getArray(size, start, stop);
        switch (type) {
            case ARRAY_LIST: {
                return new ArrayList<Integer>(Arrays.asList(randomArray));
            }
            case LINKED_LIST: {
                return new LinkedList<>(Arrays.asList(randomArray));
            }
            default: {
                throw new IllegalArgumentException("Unknown type");
            }
        }

    }
}
