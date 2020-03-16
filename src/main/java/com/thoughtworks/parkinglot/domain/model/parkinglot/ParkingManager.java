package com.thoughtworks.parkinglot.domain.model.parkinglot;

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
public class ParkingManager {
    private final String name;
    private final List<ParkingBoy> parkingBoys;

    public List<ParkingLotId> listParkingLotIds() {
        return parkingBoys.stream()
                .map(ParkingBoy::find)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(ParkingLot::getId)
                .collect(Collectors.toList());
    }

    public Optional<ParkingLot> findParkingLot() {
        return parkingBoys.stream()
                .map(ParkingBoy::find)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();
    }

}
