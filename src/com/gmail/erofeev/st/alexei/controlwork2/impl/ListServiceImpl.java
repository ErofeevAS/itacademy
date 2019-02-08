package com.gmail.erofeev.st.alexei.controlwork2.impl;

import com.gmail.erofeev.st.alexei.controlwork2.ArrayService;
import com.gmail.erofeev.st.alexei.controlwork2.ListService;
import com.gmail.erofeev.st.alexei.controlwork2.RandomService;

import java.util.ArrayList;
import java.util.List;

public class ListServiceImpl implements ListService {
    private RandomService randomService = RandomServiceImpl.getInstance();
    private static volatile ListService instance = null;

    private ListServiceImpl() {
    }

    public static ListService getInstance() {
        if (instance == null) {
            synchronized (ArrayService.class) {
                if (instance == null) {
                    instance = new ListServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Integer> getList(int size, int start, int stop) {
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(randomService.getInt(start, stop));
        }
        return list;
    }
}

