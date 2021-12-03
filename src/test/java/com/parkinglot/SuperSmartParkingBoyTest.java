package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuperSmartParkingBoyTest {
    //Case 1: Given a super smart parking boy, who manage two parking lots, both with same available
    //position rate, and a car, When park the car, Then the car will be parked to the first parking lot
    @Test
    void should_park_first_parking_lot_when_park_car_given_super_smart_parking_boy_two_parking_lots_same_capacity() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        Car car = new Car();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        //when
        superSmartParkingBoy.parkCar(car);
        //then
        assertTrue(parkingLot1.ticketCarHashMap.containsValue(car));
    }

    //Case 2: Given a super smart parking boy, who manage two parking lots, second one has larger
    //available position rate, and a car, When park the car, Then the car will be parked to the second parking lot
    @Test
    void should_park_second_parking_lot_when_park_car_given_super_smart_parking_boy_two_parking_lots_second_more_empty() {
        //given

        //when

        //then
    }
}
