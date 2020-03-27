package com.thoughtworks.parkinglot.parkingcontext.domain.finder;

import com.thoughtworks.parkinglot.annotation.ValueObject;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.ParkingLotFinder;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.ParkingLotFinderFactory;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.ParkingLotFinderSpecification;
import lombok.AllArgsConstructor;

/**
 * @author gitqh
 */
@AllArgsConstructor
@ValueObject
public class ParkingBoySpecification implements ParkingLotFinderSpecification {
    private final String parkingBoyId;
    private final ParkingLotFinderFactory parkingLotFinderFactory;

    @Override
    public ParkingLotFinder findParkingLotFinder() {
        return parkingLotFinderFactory.newParkingBoy(parkingBoyId);
    }
}
