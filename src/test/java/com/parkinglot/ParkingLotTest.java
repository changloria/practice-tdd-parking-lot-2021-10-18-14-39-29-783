package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void should_return_no_available_position_exception_when_park_car_given_parking_lot_full_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(0);
        Car car = new Car();
        //when
        NoAvailablePositionException noAvailablePositionException = assertThrows(NoAvailablePositionException.class, () -> {parkingLot.parkCar(car);});
        //then
        assertEquals("No available position.", noAvailablePositionException.getMessage());
    }

    @Test
    void should_return_car_when_take_car_given_right_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.parkCar(car);
        //when
        Car result = parkingLot.takeCar(ticket);
        //then
        assertEquals(car, result);
    }

    @Test
    //Unrecognized parking ticket when take car given ParkingLot not full + wrong ticket
    void should_throw_unrecognized_parking_ticket_when_take_car_given_wrong_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Ticket ticket1 = parkingLot.parkCar(new Car());
        //when
        Ticket ticket2 = new Ticket();

        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, () -> {parkingLot.takeCar(ticket2);});
        //then
        assertEquals("Unrecognized parking ticket.", unrecognizedParkingTicketException.getMessage());
    }

    @Test
    void should_throw_unrecognized_parking_ticket_when_take_car_given_used_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Ticket ticket1 = parkingLot.parkCar(new Car());
        Car car1 = parkingLot.takeCar(ticket1);

        //when
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, () -> {parkingLot.takeCar(ticket1);});
        //then
        assertEquals("Unrecognized parking ticket.", unrecognizedParkingTicketException.getMessage());
    }

    @Test
    //should return correct car while there are two parked cars + two corresponding tickets
    void should_correct_car_when_take_car_given_two_parked_cars() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parkingLot.parkCar(car1);
        Ticket ticket2 = parkingLot.parkCar(car2);
        //when
        Car takeCar1 = parkingLot.takeCar(ticket1);
        Car takeCar2 = parkingLot.takeCar(ticket2);
        //then
        assertEquals(car1, takeCar1);
        assertEquals(car2, takeCar2);
    }

    @Test
    void should_throw_no_available_position_when_park_car_given_parking_lot_full_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.parkCar(new Car());  //Parked one car, now no more parking lots available.

        Car car = new Car();
        //when
        NoAvailablePositionException noAvailablePositionException = assertThrows(NoAvailablePositionException.class, () -> {
            parkingLot.parkCar(car);
        });
        //then
        assertEquals("No available position.", noAvailablePositionException.getMessage());
    }
}
