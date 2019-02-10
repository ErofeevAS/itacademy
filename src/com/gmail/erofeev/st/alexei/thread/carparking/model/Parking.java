package com.gmail.erofeev.st.alexei.thread.carparking.model;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Parking {
    private final int parkingSize = 5;
    private long currentTime;
    Deque<Car> parking = new LinkedList<Car>();


    public boolean setCarInParking(Car car) throws InterruptedException {
        boolean flag = false;
        synchronized (parking) {
            if (!parking.contains(car)) {
                if (parking.size() == parkingSize) {
                    System.out.println("parking is busy plz wait");
                    parking.wait(car.getWaitingTime());
                } else {
                    car.setCurrentTime(System.currentTimeMillis());
                    parking.add(car);
                    flag = true;
                    System.out.println(car.getName() + " parked");
                }
            }
        }
        return flag;
    }

    public void getCarFromParking() {
        System.out.println("checking vacant seats");
        synchronized (parking) {
            if (parking.size() > 0) {
                System.out.println("empty seats: " + (5 - parking.size()));
                for (Car car : parking) {
                    long time = System.currentTimeMillis();
                    long currentParkingTime = time - car.getCurrentTime();
                    if (currentParkingTime >= car.getParkingTime()) {
                        System.out.println(car.getName() + " left parking");
                        parking.remove(car);
                        parking.notify();
                        break;
                    }
                }
            }
        }
    }
}
