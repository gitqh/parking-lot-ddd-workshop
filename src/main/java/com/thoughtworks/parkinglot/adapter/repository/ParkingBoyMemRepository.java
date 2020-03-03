package com.thoughtworks.parkinglot.adapter.repository;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.parkinglot.domain.model.parkingboy.GeneralParkingStrategy;
import com.thoughtworks.parkinglot.domain.model.parkingboy.ParkingBoy;
import com.thoughtworks.parkinglot.domain.model.parkingboy.ParkingBoyRepository;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingBoyId;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotId;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author gitqh
 */
@Repository
public class ParkingBoyMemRepository implements ParkingBoyRepository {

    private List<ParkingBoy> parkingBoys = ImmutableList.of(
            new ParkingBoy(new ParkingBoyId("BOY001"), new GeneralParkingStrategy(),
                    ImmutableList.of(new ParkingLotId("LOT001"), new ParkingLotId("LOT002")))
    );

    @Override
    public List<ParkingBoy> findAll() {
        return parkingBoys;
    }
}
