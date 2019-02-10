package com.gmail.erofeev.st.alexei.thread.carparking.app;

import com.gmail.erofeev.st.alexei.thread.carparking.model.Parking;
import com.gmail.erofeev.st.alexei.thread.carparking.thread.CarThread;
import com.gmail.erofeev.st.alexei.thread.carparking.thread.ParkingHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.lang.Runnable;

public class Runner {
    public static void main(String[] args) {
        Parking parking = new Parking();
        Thread parkingHandler = new Thread(new ParkingHandler(parking));

        List<Runnable> cars = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Runnable car = new CarThread(parking);
            cars.add(car);
            Thread carThread = new Thread(car);
            carThread.start();
        }
        parkingHandler.start();
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        executorService.submit(cars,false);
    }
}
