package com.thoughtworks.parkinglot.adapter.repository;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLot;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotId;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 * @author gitqh
 */
@Repository
public class ParkingLotMemRepository implements ParkingLotRepository {

    private List<ParkingLot> parkingLotLists = ImmutableList.of(
            new ParkingLot(new ParkingLotId("LOT001"), 3),
            new ParkingLot(new ParkingLotId("LOT002"), 4)
    );

    @Override
    public Optional<ParkingLot> findById(ParkingLotId parkingLotId) {
        return parkingLotLists.stream()
                .filter(lot -> lot.getId().getValue().equals(parkingLotId.getValue()))
                .findFirst();
    }
}
