package com.thoughtworks.parkinglot.domain.model.parkinglot;

import java.util.List;
import java.util.Optional;

/**
 * @author gitqh
 */
public interface ParkingStrategy {
    Optional<ParkingLot> find(List<ParkingLot> parkingLots);
}
