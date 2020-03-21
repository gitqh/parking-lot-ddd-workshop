package com.thoughtworks.parkinglot.domain.model.finder;

import com.thoughtworks.parkinglot.domain.model.parking.ParkingLotFinder;
import java.util.Collection;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author gitqh
 */
@Data
@AllArgsConstructor(staticName = "of")
public class ParkingBoy implements ParkingLotFinder {
    private final String name;
    private final Collection<ParkingLot> parkingLots;
    private ParkingStrategy parkingStrategy;

    @Override
    public Optional<ParkingLot> findParkingLot() {
        return parkingStrategy.findParkingLotToPark(parkingLots);
    }
}
