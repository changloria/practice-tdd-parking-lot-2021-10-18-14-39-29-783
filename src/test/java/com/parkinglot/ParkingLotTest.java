package com.parkinglot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_car_given_parking_lot_not_full_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        //when
        Ticket ticket = parkingLot.parkCar(car);
        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_null_when_park_car_given_parking_lot_full_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(0);
        Car car = new Car();
        //when
        Ticket ticket = parkingLot.parkCar(car);
        //then
        assertNull(ticket);
    }

    @Test
    void should_return_null_when_take_car_given_used_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Ticket ticket = parkingLot.parkCar(new Car());
        //when
        Car car = parkingLot.takeCar(ticket);
        //then
        assertNotNull(car);
    }
}
