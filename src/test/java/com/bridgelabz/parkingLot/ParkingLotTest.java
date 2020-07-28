package com.bridgelabz.parkingLot;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {
    Car car = new Car();

    @Test
    public void givenCar_whenParked_shouldReturnTrue() throws ParkingLotException {
        ParkinglotSystem parkingLotSystem = new ParkinglotSystem();
        parkingLotSystem.ParkingLotSystem(1);
        boolean isParked = parkingLotSystem.parkCar(car);
        Assert.assertTrue(isParked);
    }
    @Test
    public void givenCar_WhenAlreadyParked_shouldReturnFalse() throws ParkingLotException {
        ParkinglotSystem parkingLotSystem = new ParkinglotSystem();
        parkingLotSystem.ParkingLotSystem(2);
        try {
            parkingLotSystem.parkCar(car);
            boolean isParked = parkingLotSystem.parkCar(car);
        } catch (ParkingLotException e) {
            Assert.assertEquals("Parking is full", e.getMessage());
        }
    }
    @Test
    public void givenCar_WhenUnParked_ShouldReturnTrue() throws ParkingLotException {
        ParkinglotSystem parkingLotSystem = new ParkinglotSystem();
        parkingLotSystem.ParkingLotSystem(1);
        parkingLotSystem.parkCar(car);
        Object isUnParked = parkingLotSystem.unParkCar(car);
        Assert.assertEquals(car, isUnParked);
    }
    @Test
    public void givenCar_WhenAlreadyUnParked_ShouldReturnFalse() throws ParkingLotException {
        ParkinglotSystem parkingLotSystem = new ParkinglotSystem();
        parkingLotSystem.ParkingLotSystem(1);
        try {
            parkingLotSystem.parkCar(new Car());
            Object isUnParked = parkingLotSystem.unParkCar(car);
        } catch (ParkingLotException e) {
            Assert.assertEquals("The car is not parked here", e.getMessage());
        }
    }
}
