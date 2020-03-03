package com.thoughtworks.parkinglot.domain.model.parkinglot;

import java.util.Optional;

/**
 * @author gitqh
 */
public interface ParkingLotRepository {

    Optional<ParkingLot> findById(ParkingLotId parkingLotId);
}
