package com.gmail.erofeev.st.alexei.homework17.thread;

import com.gmail.erofeev.st.alexei.homework17.RandomService;

import java.util.List;
import java.util.concurrent.Callable;

public class TaskTwoThread implements Callable<Integer> {
    private RandomService randomService;


    public TaskTwoThread(RandomService randomService) {
        this.randomService = randomService;
    }

    private Integer findMax(Integer[] array) {
        Integer max = array[0];
        for (Integer integer : array) {
            max = Math.max(max, integer);
        }
        return max;
    }


    @Override
    public Integer call() throws Exception {
        Integer[] randomArray = randomService.getArray();
        Integer max = findMax(randomArray);
        return max;
    }
}
