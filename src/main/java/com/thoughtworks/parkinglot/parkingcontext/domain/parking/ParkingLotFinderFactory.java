package com.thoughtworks.parkinglot.parkingcontext.domain.parking;

public interface ParkingLotFinderFactory {
    ParkingLotFinder newParkingBoy(String id);

    ParkingLotFinder newParkingManager();
}
