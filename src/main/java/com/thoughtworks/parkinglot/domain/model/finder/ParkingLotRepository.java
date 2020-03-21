package com.thoughtworks.parkinglot.domain.model.finder;

import java.util.List;
import java.util.Optional;

/**
 * @author gitqh
 */
public interface ParkingLotRepository {

    Optional<ParkingLot> findById(ParkingLotId parkingLotId);

    List<ParkingLot> findByIds(List<ParkingLotId> parkingLotIds);
}
