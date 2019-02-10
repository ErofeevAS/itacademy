package com.gmail.erofeev.st.alexei.thread.carparking.thread;

import com.gmail.erofeev.st.alexei.thread.carparking.model.Parking;

public class ParkingHandler implements Runnable {
    private Parking parking;

    public ParkingHandler(Parking parking) {
        this.parking = parking;
    }

    @Override
    public void run() {
        while (true) {
            parking.getCarFromParking();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
