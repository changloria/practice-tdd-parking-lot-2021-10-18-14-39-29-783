package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingBoyTest {
    @Test
    void should_return_ticket_when_park_car_given_standard_parking_boy_manage_one_parking_lot_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Ticket ticket = parkingBoy.parkCar(new Car());
        //then
        assertNotNull(ticket);
    }

    @Test
    void should_when_given_() {
        //given

        //when

        //then
    }
}
