package com.thoughtworks.parkinglot.parkingcontext.domain.finder;

import com.thoughtworks.parkinglot.annotation.ValueObject;
import com.thoughtworks.parkinglot.parkingcontext.domain.exception.NoEnoughCapacityException;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.ParkingLotFinder;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.ParkingLotFinderFactory;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.ParkingLotFinderSpecification;
import lombok.AllArgsConstructor;

/**
 * @author gitqh
 */
@ValueObject
@AllArgsConstructor
public class ParkingManagerSpecification implements ParkingLotFinderSpecification {
    private final ParkingLotFinderFactory parkingLotFinderFactory;

    @Override
    public ParkingLot findParkingLot() {
        ParkingLotFinder parkingManager = parkingLotFinderFactory.newParkingManager();
        return parkingManager.findParkingLot().orElseThrow(NoEnoughCapacityException::new);
    }
}
