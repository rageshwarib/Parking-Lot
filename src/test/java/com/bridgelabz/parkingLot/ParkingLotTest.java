package com.bridgelabz.parkingLot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {
    ParkinglotSystem parkingLotSystem = null;
    Car car = null;

    @Before
    public void setUp() throws Exception{
        car = new Car();
        parkingLotSystem = new ParkinglotSystem();
    }

    @Test
    public void givenCar_whenParked_shouldReturnTrue() throws ParkingLotException {
        parkingLotSystem.ParkingLotSystem(1);
        boolean isParked = parkingLotSystem.parkCar(car);
        Assert.assertTrue(isParked);
    }
    @Test
    public void givenCar_WhenAlreadyParked_shouldNotBeParked() throws ParkingLotException {
        parkingLotSystem.ParkingLotSystem(2);
        try {
            parkingLotSystem.parkCar(car);
            boolean isParked = parkingLotSystem.parkCar(car);
        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.ExceptionType.PARKING_FULL, e.type);
        }
    }
    @Test
    public void givenCar_WhenUnParked_ShouldReturnTrue() throws ParkingLotException {
        parkingLotSystem.ParkingLotSystem(1);
        parkingLotSystem.parkCar(car);
        Car isUnParked = parkingLotSystem.unParkCar(car);
        Assert.assertEquals(car, isUnParked);
    }
    @Test
    public void givenCar_WhenAlreadyUnParked_ShouldReturnFalse() throws ParkingLotException {
        parkingLotSystem.ParkingLotSystem(1);
        try {
            parkingLotSystem.parkCar(new Car());
            Car isUnParked = parkingLotSystem.unParkCar(car);
        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.ExceptionType.NO_VEHICLE, e.type);
        }
    }
    @Test
    public void givenParkingLot_WhenParkingLotIsFull_thenShouldNotifyToOwner() throws ParkingLotException {
        Owner owner = new Owner();
        parkingLotSystem.ParkingLotSystem(2, owner);
        Car carOne = new Car();
        Car carTwo = new Car();
        parkingLotSystem.parkCar(carOne);
        parkingLotSystem.parkCar(carTwo);
        Assert.assertEquals("Parking lot is full", owner.getMessage());
    }
    @Test
    public void givenParkingLot_WhenParkingLotIsFull_thenShouldNotifyToAirportSecurity() throws ParkingLotException {
        AirportSecurity airportSecurity = new AirportSecurity();
        parkingLotSystem.ParkingLotSystem(2, airportSecurity);
        Car carOne = new Car();
        Car carTwo = new Car();
        parkingLotSystem.parkCar(carOne);
        parkingLotSystem.parkCar(carTwo);
        Assert.assertEquals("Parking lot is full", airportSecurity.getMessage());
    }
}
