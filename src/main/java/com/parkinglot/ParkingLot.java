package com.parkinglot;

import java.util.HashMap;

public class ParkingLot {

    public ParkingLot(){

    }

    public Ticket parkCar(Car car) {
        HashMap<Ticket, Car> ticketCarHashMap = new HashMap<>();
        Ticket ticket = new Ticket();
        ticketCarHashMap.put(ticket, car);
        return ticket;
    }
}
