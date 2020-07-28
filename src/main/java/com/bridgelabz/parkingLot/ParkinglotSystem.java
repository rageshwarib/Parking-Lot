package com.bridgelabz.parkingLot;

public class ParkinglotSystem {
    private Car car;

    public boolean parkCar(Car car) {
        if(this.car != null)
            return false;
        this.car = car;
        return true;
    }
}
