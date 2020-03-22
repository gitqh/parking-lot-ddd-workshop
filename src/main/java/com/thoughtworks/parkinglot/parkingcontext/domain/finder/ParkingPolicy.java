package com.thoughtworks.parkinglot.parkingcontext.domain.finder;

import java.util.Collection;
import java.util.Optional;

/**
 * @author gitqh
 */
public interface ParkingPolicy {
    Optional<ParkingLot> findParkingLotToPark(Collection<ParkingLot> parkingLots);
}
