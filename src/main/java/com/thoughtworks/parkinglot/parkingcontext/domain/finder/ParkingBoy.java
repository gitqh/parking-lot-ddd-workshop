package com.thoughtworks.parkinglot.parkingcontext.domain.finder;

import com.thoughtworks.parkinglot.annotation.ValueObject;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.ParkingLotFinder;
import java.util.Collection;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author gitqh
 */
@Data
@AllArgsConstructor(staticName = "of")
@ValueObject
public class ParkingBoy implements ParkingLotFinder {
    private final String name;
    private final Collection<ParkingLot> parkingLots;
    private ParkingPolicy parkingPolicy;

    @Override
    public Optional<ParkingLot> findParkingLot() {
        return parkingPolicy.findParkingLotToPark(parkingLots);
    }
}
