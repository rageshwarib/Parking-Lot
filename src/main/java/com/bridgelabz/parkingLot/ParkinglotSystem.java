package com.bridgelabz.parkingLot;

public class ParkinglotSystem {
    private Car car;

    public boolean parkCar(Car car) {
        if(this.car != null)
            return false;
        this.car = car;
        return true;
    }

    public boolean unParkCar(Car car) {
        if(this.car.equals(car)) {
            this.car = null;
            return true;
        }
        return false;
    }
}
