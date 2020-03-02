package com.thoughtworks.parkinglot.domain.model.parkinglot;

import java.util.Optional;

/**
 * @author gitqh
 */
public interface ParkingLotRepository {

    void save(ParkingLot parkingLot);

    Optional<ParkingLot> findById(ParkingLotId parkingLotId);
}
