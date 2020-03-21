package com.thoughtworks.parkinglot.domain.model.strategy;

import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLot;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingStrategy;
import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import lombok.Value;

/**
 * @author gitqh
 */
@Value(staticConstructor = "of")
public class SeniorParkingParkingStrategy implements ParkingStrategy {

    @Override
    public Optional<ParkingLot> findParkingLotToPark(final Collection<ParkingLot> parkingLots) {
        return parkingLots.stream()
                .filter(ParkingLot::isAvailable)
                .max(Comparator.comparingInt(ParkingLot::getSpace));
    }
}
