package com.thoughtworks.parkinglot.parkingcontext.domain.parking;

import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyId;

public interface ParkingLotFinderFactory {
    ParkingLotFinder newParkingBoy(ParkingBoyId id);

    ParkingLotFinder newParkingManager();
}
