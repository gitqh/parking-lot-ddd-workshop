package com.thoughtworks.parkinglot.domain.model.parkingboy;

import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLot;
import java.util.List;
import java.util.Optional;

/**
 * @author gitqh
 */
public class GeneralParkingStrategy implements ParkingStrategy {

    @Override
    public ParkingLot find(List<ParkingLot> parkingLots) {
        return parkingLots.stream()
                .filter(lot -> lot.isAvailable())
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
