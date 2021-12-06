package com.parkinglot;

import java.util.ArrayList;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket parkCar(Car car) {
        ParkingLot availableParkingLot = getParkingLots().get(0);
        for (int i = 1; i < getParkingLots().size(); i++) {
            if (availableParkingLot.getAvailablePositionCount() < getParkingLots().get(i).getAvailablePositionCount()) {
                availableParkingLot = getParkingLots().get(i);
            }
        }
        return availableParkingLot.parkCar(car);
    }
}
