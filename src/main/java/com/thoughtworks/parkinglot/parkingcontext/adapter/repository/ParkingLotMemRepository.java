package com.thoughtworks.parkinglot.parkingcontext.adapter.repository;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLot;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLotId;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLotRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

/**
 * @author gitqh
 */
@Repository
@SuppressWarnings("checkstyle:magicnumber")
public class ParkingLotMemRepository implements ParkingLotRepository {

    private List<ParkingLot> parkingLotLists = ImmutableList.of(
            new ParkingLot(new ParkingLotId("LOT001"), 3),
            new ParkingLot(new ParkingLotId("LOT002"), 4)
    );

    @Override
    public Optional<ParkingLot> findById(final ParkingLotId parkingLotId) {
        return parkingLotLists.stream()
                .filter(lot -> lot.getId().getValue().equals(parkingLotId.getValue()))
                .findFirst();
    }

    @Override
    public List<ParkingLot> findByIds(final List<ParkingLotId> parkingLotIds) {
        return parkingLotLists.stream()
                .filter(ele -> parkingLotIds.contains(ele.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void save(ParkingLot parkingLot) {
    }

}
