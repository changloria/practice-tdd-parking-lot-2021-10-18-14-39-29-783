package com.parkinglot;

import java.util.HashMap;

public class ParkingLot {
    private final int DEFAULT_CAPACITY = 10;
    HashMap<Ticket, Car> ticketCarHashMap = new HashMap<>();
    private int capacity;

    public ParkingLot(int capacity){
        this.capacity = capacity;
    }

    public ParkingLot(){
        this.capacity = DEFAULT_CAPACITY;
    }

    public Ticket parkCar(Car car) {
        if (!isParkingLotFull()) {
            Ticket ticket = new Ticket();
            ticketCarHashMap.put(ticket, car);
            return ticket;
        }
        return null;
    }

    private Boolean isParkingLotFull(){
        return ticketCarHashMap.size()>=capacity;
    }

    public Car takeCar(Ticket ticket) {
        return null;
    }
}
