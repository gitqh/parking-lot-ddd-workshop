package com.thoughtworks.parkinglot.domain.model.parkingboy;

import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLot;
import java.util.List;
import java.util.Optional;

/**
 * @author gitqh
 */
public interface ParkingStrategy {
    Optional<ParkingLot> find(List<ParkingLot> parkingLots);
}
