package com.thoughtworks.parkinglot.adapter.repository.memRepository;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.parkinglot.domain.model.parkingboy.GeneralParkingStrategy;
import com.thoughtworks.parkinglot.domain.model.parkingboy.ParkingBoy;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingBoyId;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotId;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author gitqh
 */
@Component
public class ParkingBoyMemRepository {
    private static List<ParkingBoy> parkingBoys = ImmutableList.of(
            new ParkingBoy(new ParkingBoyId("BOY001"), new GeneralParkingStrategy(),
                    ImmutableList.of(new ParkingLotId("LOT001"), new ParkingLotId("002")))
    );

    public ParkingBoy find(ParkingBoyId parkingBoyId) {
        return parkingBoys.stream()
                .filter(boy -> boy.getParkingBoyId().getId().equals(parkingBoyId.getId()))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public void save(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
    }

    public List<ParkingBoy> findAll() {
        return parkingBoys;
    }
}
