package com.thoughtworks.parkinglot.parkingcontext.domain.finder;

import com.thoughtworks.parkinglot.common.ddd.annotation.ValueObject;
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

    @Override
    public ParkingLotFinder findParkingLotFinder(final ParkingLotFinderFactory parkingLotFinderFactory) {
        return parkingLotFinderFactory.newParkingBoy(parkingBoyId);
    }
}
