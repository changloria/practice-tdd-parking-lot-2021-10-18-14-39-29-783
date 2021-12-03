package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;

    public ParkingBoy(ArrayList<ParkingLot> parkingLots){
    this.parkingLots = parkingLots;
    }

    public void assignParkingLot(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }

    public Ticket parkCar(Car car){
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.getAvailablePosition() > 0)
                .findFirst()
                .get()
                .parkCar(car);
    }

    public Car takeCar(Ticket ticket) {
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.ticketCarHashMap.containsKey(ticket))
                .findFirst()
                .orElseThrow(UnrecognizedParkingTicketException::new)
                .takeCar(ticket);
    }
}
