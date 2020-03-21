package com.thoughtworks.parkinglot.domain.model.parkinglot;

import java.util.Collection;
import java.util.Optional;

/**
 * @author gitqh
 */
public interface ParkingStrategy {
    Optional<ParkingLot> findParkingLotToPark(Collection<ParkingLot> parkingLots);
}
