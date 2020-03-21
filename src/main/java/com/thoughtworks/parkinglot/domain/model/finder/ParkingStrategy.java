package com.thoughtworks.parkinglot.domain.model.finder;

import java.util.Collection;
import java.util.Optional;

/**
 * @author gitqh
 */
public interface ParkingStrategy {
    Optional<ParkingLot> findParkingLotToPark(Collection<ParkingLot> parkingLots);
}
