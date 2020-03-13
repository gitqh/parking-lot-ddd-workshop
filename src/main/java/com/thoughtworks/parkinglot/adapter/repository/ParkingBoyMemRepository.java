package com.thoughtworks.parkinglot.adapter.repository;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.parkinglot.domain.model.parkingboy.ParkingBoy;
import com.thoughtworks.parkinglot.domain.model.parkingboy.ParkingBoyFactory;
import com.thoughtworks.parkinglot.domain.model.parkingboy.ParkingBoyRepository;
import com.thoughtworks.parkinglot.domain.model.parkingboy.ParkingStrategyEnum;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotId;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author gitqh
 */
@Repository
public class ParkingBoyMemRepository implements ParkingBoyRepository {

    private List<ParkingBoy> parkingBoys;

    {
        List<ParkingLotId> parkingLotIds = ImmutableList.of(new ParkingLotId("LOT001"), new ParkingLotId("LOT002"));
        parkingBoys = ImmutableList.of(
                ParkingBoyFactory.createParkingBoy(parkingLotIds, ParkingStrategyEnum.MAX_SPACE)
        );
    }

    @Override
    public List<ParkingBoy> findAll() {
        return parkingBoys;
    }
}
