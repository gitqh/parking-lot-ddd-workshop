package com.thoughtworks.parkinglot.adapter.repository.memRepository;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLot;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotId;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

/**
 * @author gitqh
 */
@Component
public class ParkingLotMemRepository {
    private static List<ParkingLot> parkingLots = ImmutableList.of(
            new ParkingLot(new ParkingLotId("LOT001"), 3, Lists.newArrayList()),
            new ParkingLot(new ParkingLotId("LOT002"), 4, Lists.newArrayList()),
            new ParkingLot(new ParkingLotId("LOT003"), 5, Lists.newArrayList())
    );

    public void save(ParkingLot parkingLot) {
        parkingLots.remove(parkingLot);
        parkingLots.add(parkingLot);
    }

    public Optional<ParkingLot> findById(ParkingLotId parkingLotId) {
        return parkingLots.stream()
                .filter(lot -> lot.getId().getValue().equals(parkingLotId.getValue()))
                .findFirst();
    }
}
