package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    //Case 1
    @Test
    void should_return_ticket_when_park_car_given_standard_parking_boy_manage_one_parking_lot_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when
        Ticket ticket = parkingBoy.parkCar(new Car());
        //then
        assertNotNull(ticket);
    }
    //Case 2
    @Test
    void should_park_to_first_parking_lot_when_park_car_given_parking_boy_manage_two_parking_lots_both_available() {
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when
        Ticket ticket = parkingBoy.parkCar(new Car());
        //then
        assertNotNull(ticket);
        assertEquals(9, parkingLot1.getAvailablePosition());
        assertEquals(10, parkingLot2.getAvailablePosition());
    }
    //Case 3
    @Test
    void should_park_to_second_parking_lot_when_park_car_given_parking_boy_manage_two_parking_lots_first_parking_lot_full() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(10);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when
        Ticket ticket = parkingBoy.parkCar(new Car());
        //then
        assertNotNull(ticket);
        assertEquals(0, parkingLot1.getAvailablePosition());
        assertEquals(9, parkingLot2.getAvailablePosition());
    }
    //Case 4
    @Test
    void should_return_right_car_when_take_car_twice_given_parking_boy_manage_two_parking_lots_and_car_and_two_tickets() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.assignParkingLot(parkingLot1);
        parkingBoy.assignParkingLot(parkingLot2);

        Car expectedCar1 = new Car();
        Car expectedCar2 = new Car();
        Ticket ticket1 = parkingBoy.parkCar(expectedCar1);
        Ticket ticket2 = parkingBoy.parkCar(expectedCar2);

        //when
        Car actualCar1 = parkingBoy.takeCar(ticket1);
        Car actualCar2 = parkingBoy.takeCar(ticket2);

        //then
        assertEquals(expectedCar1, actualCar1);
        assertEquals(expectedCar2, actualCar2);
    }

    @Test
    void should_throw_unrecognized_parking_ticket_when_take_car_given_parking_boy_manage_two_parking_lots_and_unrecognized_ticket() {
        //given
        Car car = new Car();
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.assignParkingLot(parkingLot1);
        parkingBoy.assignParkingLot(parkingLot2);
        parkingBoy.parkCar(car);

        Ticket wrongTicket = new Ticket();

        //when
        //then
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingBoy.takeCar(wrongTicket));
        assertEquals("Unrecognized parking ticket.", unrecognizedParkingTicketException.getMessage());
    }
}
