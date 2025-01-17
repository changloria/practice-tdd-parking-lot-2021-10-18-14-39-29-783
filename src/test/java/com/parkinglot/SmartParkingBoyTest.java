package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SmartParkingBoyTest {
    //Case 1: Given a smart parking boy, who manage two parking lots, both with same number of empty positions,
    //and a car, When park the car, Then the car will be parked to the first parking lot.
    @Test
    void should_park_first_parking_lot_when_park_car_given_smart_parking_boy_two_parking_lots_same_capacity() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
//        smartParkingBoy.assignParkingLot(parkingLot1);
//        smartParkingBoy.assignParkingLot(parkingLot2);
        //when
        smartParkingBoy.parkCar(car);
        //then
        assertTrue(parkingLot1.ticketCarHashMap.containsValue(car));
    }

    //Case 2: Given a smart parking boy, who manage two parking lots, second one has more empty
    //positions, and a car, When park the car, Then the car will be parked to the second parking lot
    @Test
    void should_park_second_parking_lot_when_park_car_given_smart_parking_boy_two_parking_lots_second_more_empty() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(4);
        ParkingLot parkingLot2 = new ParkingLot(10);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        //when
        smartParkingBoy.parkCar(car);
        //then
        assertTrue(parkingLot2.ticketCarHashMap.containsValue(car));
        assertFalse(parkingLot1.ticketCarHashMap.containsValue(car));
    }

    //Case 3: Given a smart parking boy, who manage two parking lots, both with a parked car, and two
    //parking ticket, When fetch the car twice, Then return the right car with each ticket
    @Test
    void should_return_right_car_when_take_car_twice_given_smart_parking_boy_two_parking_lots_one_parked_car_two_ticket() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(8);
        ParkingLot parkingLot2 = new ParkingLot(9);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        Ticket ticket1 = smartParkingBoy.parkCar(car1);
        Ticket ticket2 = smartParkingBoy.parkCar(car2);

        //when
        Car actualCar1 = smartParkingBoy.takeCar(ticket1);
        Car actualCar2 = smartParkingBoy.takeCar(ticket2);

        //then
        assertEquals(car1, actualCar1);
        assertEquals(car2, actualCar2);
    }

    //Case 4: Given a smart parking boy, who manage two parking lots, and an unrecognized ticket,
    //When fetch the car, Then return nothing with error message "Unrecognized parking ticket.
    @Test
    void should_throw_unrecognized_parking_ticket_exception_when_take_car_given_smart_parking_boy_two_parking_lots_and_wrong_ticket() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        //when
        Ticket ticket = new Ticket();
        //then
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, () -> smartParkingBoy.takeCar(ticket));
        assertEquals("Unrecognized parking ticket.", unrecognizedParkingTicketException.getMessage());
    }

    //Case 5: Given a smart parking boy, who manage two parking lots, and a used ticket, When fetch
    //the car, Then return nothing with error message "Unrecognized parking ticket.
    @Test
    void should_throw_unrecognized_parking_ticket_exception_when_take_car_given_smart_parking_boy_two_parking_lots_and_used_ticket() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        //when
        Ticket ticket = smartParkingBoy.parkCar(car);
        smartParkingBoy.takeCar(ticket);
        //then
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, () -> smartParkingBoy.takeCar(ticket));
        assertEquals("Unrecognized parking ticket.", unrecognizedParkingTicketException.getMessage());
    }

    //Case 6: Given a smart parking boy, who manage two parking lots, both without any position, and a
    //car, When park the car, Then return nothing with error message "No available position."
    @Test
    void should_throw_no_available_position_when_park_car_given_smart_parking_boy_two_parking_lots_with_no_capacity() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        //when
        smartParkingBoy.parkCar(new Car());
        smartParkingBoy.parkCar(new Car());
        //then
        NoAvailablePositionException noAvailablePositionException = assertThrows(NoAvailablePositionException.class, () -> smartParkingBoy.parkCar(new Car()));
        assertEquals("No available position.", noAvailablePositionException.getMessage());
    }
}
