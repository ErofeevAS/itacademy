package com.gmail.erofeev.st.alexei.thread.carparking.model;

import com.gmail.erofeev.st.alexei.thread.carparking.RandomService;
import com.gmail.erofeev.st.alexei.thread.carparking.impl.RandomServiceImpl;

public class Car {
    private String name;
    private int waitingTime;
    private int parkingTime;
    private long currentTime;

    public Car(String name, int waitingTime, int parkingTime) {
        this.name = name;
        this.waitingTime = waitingTime;
        this.parkingTime = parkingTime;
    }

    public String getName() {
        return name;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getParkingTime() {
        return parkingTime;
    }

    public void setParkingTime(int parkingTime) {
        this.parkingTime = parkingTime;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", waitingTime=" + waitingTime +
                ", parkingTime=" + parkingTime +
                '}';
    }
}
