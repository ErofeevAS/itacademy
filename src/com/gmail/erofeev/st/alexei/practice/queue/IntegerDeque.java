package com.gmail.erofeev.st.alexei.practice.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class IntegerDeque {
    private final int SIZE = 5;
    private Deque<Integer> deque = new ArrayDeque<>(SIZE);

    public boolean addElement(Integer number) {
        boolean isSuccessful = false;
        synchronized (deque) {
            if (deque.size() < SIZE) {
                deque.push(number);
                System.out.println(number + " was added to deque");
                isSuccessful = true;
            } else {
                System.out.println("deque is full. plz wait");
                isSuccessful = false;
            }
            deque.notify();
            return isSuccessful;
        }
    }

    public Integer getElement() {
        Integer element = null;
        synchronized (deque) {
            if (deque.size() != 0) {
                element = deque.pollLast();
            } else {
                System.out.println("deque is empty. Plz wait");
            }
            try {
                deque.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return element;
        }
    }

}
