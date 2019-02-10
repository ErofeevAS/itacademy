package com.gmail.erofeev.st.alexei.thread.carparking.thread;

import com.gmail.erofeev.st.alexei.thread.carparking.RandomService;
import com.gmail.erofeev.st.alexei.thread.carparking.impl.RandomServiceImpl;
import com.gmail.erofeev.st.alexei.thread.carparking.model.Car;
import com.gmail.erofeev.st.alexei.thread.carparking.model.Parking;

public class CarThread implements Runnable {
    private RandomService randomService = RandomServiceImpl.getInstance();
    private Parking parking;
    private final int MAX_AMOUNT_ATTEMPTS = 4;

    public CarThread(Parking parking) {
        this.parking = parking;
    }

    @Override
    public void run() {
        int counter_attempt = 0;
        String name = Thread.currentThread().getName().replaceAll("Thread", "car");
        int waitingTime = randomService.getRandom(10, 50);
        int parkingTime = randomService.getRandom(10, 500);
        Car car = new Car(name, waitingTime, parkingTime);
        System.out.println("Parking car:" + name);
        try {
            while (counter_attempt < MAX_AMOUNT_ATTEMPTS) {
                System.out.println(car.getName() + " Trying parking... attempt number:" + counter_attempt);
                counter_attempt++;
                if (parking.setCarInParking(car)) {
                    break;
                }


            }
            System.out.println(counter_attempt);
            if (counter_attempt == MAX_AMOUNT_ATTEMPTS) {
                System.out.println(name + " going to find other parking");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
