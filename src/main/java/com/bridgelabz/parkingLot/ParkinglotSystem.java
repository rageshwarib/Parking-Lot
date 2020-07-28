package com.bridgelabz.parkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkinglotSystem {
    private Car car;
    private int capacity;
    private int spaceAvailable;
    private Owner owner;

    List<Object> carsList = new ArrayList<>();

    public void ParkingLotSystem(int capacity) {
        this.capacity = capacity;
        this.spaceAvailable = capacity;
        this.owner = owner;
    }
    public void ParkingLotSystem(int capacity, Owner owner) {
        this.capacity = capacity;
        this.spaceAvailable = capacity;
        this.owner = owner;
    }

    public boolean parkCar(Car car) throws ParkingLotException {
        if(spaceAvailable > 0) {
            if (this.car != null) {
                throw new ParkingLotException("Parking is full");
            }
            carsList.add(car);
            if (carsList.size() == capacity) {
                if (owner != null) {
                    owner.setMessage("Parking lot is full");
                }
            }
            spaceAvailable--;
            return true;
        }
            throw new ParkingLotException("Parking lot is full");
    }


    public Object unParkCar(Car car)throws ParkingLotException {
        if (carsList.contains(car)) {
            return carsList.remove(carsList.indexOf(car));
        }
        throw new ParkingLotException("The car is not parked here");
    }
}
