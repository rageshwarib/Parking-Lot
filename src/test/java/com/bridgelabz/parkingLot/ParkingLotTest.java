package com.bridgelabz.parkingLot;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {
    Car car = new Car();

    @Test
    public void givenCar_whenParked_shouldReturnTrue()  {
        ParkinglotSystem parkingLotSystem = new ParkinglotSystem();
        boolean isParked = parkingLotSystem.parkCar(car);
        Assert.assertTrue(isParked);
    }
    @Test
    public void givenCar_WhenAlreadyParked_shouldReturnFalse() {
        ParkinglotSystem parkingLotSystem = new ParkinglotSystem();
        parkingLotSystem.parkCar(car);
        boolean isParked = parkingLotSystem.parkCar(car);
        Assert.assertFalse(isParked);
    }
}
