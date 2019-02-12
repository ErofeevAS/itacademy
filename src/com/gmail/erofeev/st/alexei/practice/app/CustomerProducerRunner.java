package com.gmail.erofeev.st.alexei.practice.app;

import com.gmail.erofeev.st.alexei.practice.queue.IntegerDeque;
import com.gmail.erofeev.st.alexei.practice.thread.ConsumerInteger;
import com.gmail.erofeev.st.alexei.practice.thread.ProducerInteger;

public class CustomerProducerRunner {
    public static void main(String[] args) {
        IntegerDeque deque = new IntegerDeque();
        Thread producer1 = new Thread(new ProducerInteger(deque));
        Thread producer2 = new Thread(new ProducerInteger(deque));

        Thread customer1 = new Thread(new ConsumerInteger(deque));
        Thread customer2 = new Thread(new ConsumerInteger(deque));

        producer1.start();
        producer2.start();
        customer1.start();
        customer2.start();

    }
}
