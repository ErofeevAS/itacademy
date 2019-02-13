package com.gmail.erofeev.st.alexei.controlworkTwo.thread;

import com.gmail.erofeev.st.alexei.controlworkTwo.FileService;
import com.gmail.erofeev.st.alexei.controlworkTwo.impl.FileServiceImpl;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;

public class FindMaxFromFileThread implements Callable<Integer> {
    private File file;
    private FileService fileService = FileServiceImpl.getInstance();
    private final int MAX_ATTEMPTS = 10;

    public FindMaxFromFileThread(File file) {
        this.file = file;
    }

    @Override
    public Integer call() throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println(name + " start read " + file);
        int count = 0;
        List<Integer> list = null;
        while (count < MAX_ATTEMPTS) {
            list = fileService.readFile(file);
            if (list == null) {
                count++;
                System.out.println(file + " not exist or empty. plz wait" + " Attempt number: " + count);
            } else {
                break;
            }
        }
        if (list == null) {
            throw new RuntimeException("Time out on reading file: " + file);
        }
        System.out.println(name + " stop read " + file);
        return findMax(list);
    }

    private Integer findMax(List<Integer> list) {
        Integer max = null;
        if (list != null) {
            max = list.get(0);
            for (Integer integer : list) {
                max = Math.max(max, integer);
            }
        }
        return max;
    }
}
