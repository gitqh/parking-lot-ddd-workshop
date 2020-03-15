package com.thoughtworks.parkinglot.domain.model.parkinglot;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import lombok.Value;

/**
 * @author gitqh
 */
@Value(staticConstructor = "of")
public class MaxSpaceFirstParkingStrategy implements ParkingStrategy {

    @Override
    public Optional<ParkingLot> find(final List<ParkingLot> parkingLots) {
        return parkingLots.stream()
                .filter(ParkingLot::isAvailable)
                .max(Comparator.comparingInt(ParkingLot::getSpace));
    }
}
