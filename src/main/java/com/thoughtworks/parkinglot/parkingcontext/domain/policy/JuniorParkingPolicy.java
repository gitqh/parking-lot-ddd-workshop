package com.thoughtworks.parkinglot.parkingcontext.domain.policy;

import com.thoughtworks.parkinglot.annotation.ValueObject;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLot;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingPolicy;
import java.util.Collection;
import java.util.Optional;
import lombok.Value;

/**
 * @author gitqh
 */
@Value(staticConstructor = "of")
@ValueObject
public class JuniorParkingPolicy implements ParkingPolicy {

    @Override
    public Optional<ParkingLot> findParkingLotToPark(final Collection<ParkingLot> parkingLots) {
        return parkingLots.stream()
                .filter(ParkingLot::isAvailable)
                .findFirst();
    }
}
