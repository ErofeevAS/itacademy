package com.gmail.erofeev.st.alexei.homework16.impl;

import com.gmail.erofeev.st.alexei.homework16.ThreadService;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ThreadServiceImpl implements ThreadService {
    @Override
    public synchronized void showCurrentThreadAndTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println(Thread.currentThread().getName() + " " + dateFormat.format(calendar.getTime()));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
