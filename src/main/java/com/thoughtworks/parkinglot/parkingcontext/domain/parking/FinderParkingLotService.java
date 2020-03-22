package com.thoughtworks.parkinglot.parkingcontext.domain.parking;

import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLot;

public interface FinderParkingLotService {
    default ParkingLot findParkingLot(ParkingLotFinderSpecification parkingLotFinderSpecification) {
        return parkingLotFinderSpecification.findParkingLot();
    }
}
