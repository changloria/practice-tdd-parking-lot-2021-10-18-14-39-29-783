package com.parkinglot;

import java.util.ArrayList;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }


    public Ticket parkCar(Car car, ArrayList<ParkingLot> parkingLots) {
        ParkingLot availableParkingLot = parkingLots.get(0);
        for (int i = 1; i < parkingLots.size(); i++) {
            if (availableParkingLot.getAvailablePosition() < parkingLots.get(i).getAvailablePosition()) {
                availableParkingLot = parkingLots.get(i);
            }
        }
        return availableParkingLot.parkCar(car);
    }
}
