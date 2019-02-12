package com.gmail.erofeev.st.alexei.practice.thread;

import com.gmail.erofeev.st.alexei.practice.app.Runner;

import java.util.Random;

public class TaskTwoThread implements Runnable {
    private final String massege;

    public TaskTwoThread(String massege) {
        this.massege = massege;
    }

    @Override
    public void run() {
        Thread thread;
        synchronized (massege) {
            if (Runner.THREAD_COUNTER != 50) {
                Runner.THREAD_COUNTER++;
                thread = new Thread(new TaskTwoThread(massege));
                thread.setName("Thread-" + Runner.THREAD_COUNTER);
                thread.start();
                try {
                    massege.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(massege + Thread.currentThread().getName());
            } else {
                massege.notifyAll();
            }
        }

    }
}
