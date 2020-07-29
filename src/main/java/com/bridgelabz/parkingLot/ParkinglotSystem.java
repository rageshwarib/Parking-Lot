package com.bridgelabz.parkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkinglotSystem {
    private Car car;
    private int capacity;
    private int spaceAvailable;
    private Owner owner;
    private AirportSecurity airportSecurity;

    List<Car> carsList = new ArrayList<>();

    public void ParkingLotSystem(int capacity) {
        this.capacity = capacity;
        this.spaceAvailable = capacity;
    }
    public void ParkingLotSystem(int capacity, Owner owner) {
        this.capacity = capacity;
        this.spaceAvailable = capacity;
        this.owner = owner;
    }
    public void ParkingLotSystem(int capacity, AirportSecurity airportSecurity) {
        this.capacity = capacity;
        this.spaceAvailable = capacity;
        this.airportSecurity = airportSecurity;
    }

    public boolean parkCar(Car car) throws ParkingLotException {
        if(spaceAvailable > 0) {
            if (this.car != null) {
                throw new ParkingLotException("Parking is full", ParkingLotException.ExceptionType.PARKING_FULL);
            }
            carsList.add(car);
            if (carsList.size() == capacity) {
                if (owner != null) {
                    owner.setMessage("Parking lot is full");
                } if(airportSecurity != null) {
                    airportSecurity.setMessage("Parking lot is full");
                }
            }
            spaceAvailable--;
            return true;
        }
            throw new ParkingLotException("Parking lot is full", ParkingLotException.ExceptionType.PARKING_FULL);
    }


    public Car unParkCar(Car car)throws ParkingLotException {
        if (carsList.contains(car)) {
            return carsList.remove(carsList.indexOf(car));
        }
        throw new ParkingLotException("The car is not parked here", ParkingLotException.ExceptionType.NO_VEHICLE);
    }
}
