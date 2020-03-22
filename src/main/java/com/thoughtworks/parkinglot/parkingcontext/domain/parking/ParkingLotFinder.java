package com.thoughtworks.parkinglot.parkingcontext.domain.parking;

import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLot;
import java.util.Optional;

/**
 * @author gitqh
 */
public interface ParkingLotFinder {
    Optional<ParkingLot> findParkingLot();
}
