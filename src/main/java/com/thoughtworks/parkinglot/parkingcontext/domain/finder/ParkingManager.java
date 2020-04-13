package com.thoughtworks.parkinglot.parkingcontext.domain.finder;

import com.thoughtworks.parkinglot.common.ddd.annotation.ValueObject;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.ParkingLotFinder;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author gitqh
 */
@AllArgsConstructor(staticName = "of")
@Data
@ValueObject
public class ParkingManager implements ParkingLotFinder {
    private final String name;
    private final List<ParkingBoy> parkingBoys;

    public List<ParkingLotId> listParkingLotIds() {
        return parkingBoys.stream()
                .map(ParkingBoy::findParkingLot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(ParkingLot::getId)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ParkingLot> findParkingLot() {
        return parkingBoys.stream()
                .map(ParkingBoy::findParkingLot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();
    }

}
