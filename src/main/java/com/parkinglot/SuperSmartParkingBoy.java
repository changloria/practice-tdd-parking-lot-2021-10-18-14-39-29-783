package com.parkinglot;

import java.util.ArrayList;

public class SuperSmartParkingBoy extends SmartParkingBoy{
    public SuperSmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket parkCar(Car car) {
        ParkingLot availableParkingLot = getParkingLots().get(0);
        for (int i = 1; i < getParkingLots().size(); i++) {
            if (availableParkingLot.getAvailabilityRate() < getParkingLots().get(i).getAvailabilityRate()) {
                availableParkingLot = getParkingLots().get(i);
            }
        }
        return availableParkingLot.parkCar(car);
    }
}
