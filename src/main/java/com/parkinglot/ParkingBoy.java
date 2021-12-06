package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;

    public ParkingBoy(ArrayList<ParkingLot> parkingLots){
    this.parkingLots = parkingLots;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void assignParkingLot(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }

    public Ticket parkCar(Car car){
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.getAvailablePositionCount() > 0)
                .findFirst()
                .orElseThrow(NoAvailablePositionException::new)
                .parkCar(car);
    }

    //if there is var, .orElseThrow(()-> new NoAvailableException(NO_AVAILABLE_POSITION))
    public Car takeCar(Ticket ticket) {
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.ticketCarHashMap.containsKey(ticket))
                .findFirst()
                .orElseThrow(UnrecognizedParkingTicketException::new)
                .takeCar(ticket);
    }
}
