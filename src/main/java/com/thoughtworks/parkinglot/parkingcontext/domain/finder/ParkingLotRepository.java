package com.thoughtworks.parkinglot.parkingcontext.domain.finder;

import java.util.List;
import java.util.Optional;

/**
 * @author gitqh
 */
public interface ParkingLotRepository {

    Optional<ParkingLot> findById(ParkingLotId parkingLotId);

    List<ParkingLot> findByIds(List<ParkingLotId> parkingLotIds);

    void updateParkingLot(ParkingLot parkingLot);
}
