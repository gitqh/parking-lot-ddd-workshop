package com.thoughtworks.parkinglot.domain.model.parkinglot;

import java.util.Collection;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author gitqh
 */
@Data
@AllArgsConstructor(staticName = "of")
public class ParkingBoy {
    private final String name;
    private final Collection<ParkingLot> parkingLots;
    private ParkingStrategy parkingStrategy;

    public Optional<ParkingLot> find() {
        return parkingStrategy.findParkingLotToPark(parkingLots);
    }
}
