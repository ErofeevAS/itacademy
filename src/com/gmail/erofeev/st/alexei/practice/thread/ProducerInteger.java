package com.gmail.erofeev.st.alexei.practice.thread;

import com.gmail.erofeev.st.alexei.practice.RandomService;
import com.gmail.erofeev.st.alexei.practice.impl.RandomServiceImpl;
import com.gmail.erofeev.st.alexei.practice.queue.IntegerDeque;


public class ProducerInteger implements Runnable {
    private IntegerDeque deque;
    private final int MAX_ATTEMPTS = 5;
    private RandomService randomService = RandomServiceImpl.getInstance();

    public ProducerInteger(IntegerDeque deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        while (true) {
            String name = Thread.currentThread().getName();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int counter = 0;
            Integer element = randomService.getRandomInt(0, 1000);
            System.out.println(name + " create new random number: " + element);
            while (counter != MAX_ATTEMPTS) {
                counter++;
                if (deque.addElement(element)) {
                    break;
                }
            }
        }

    }
}
