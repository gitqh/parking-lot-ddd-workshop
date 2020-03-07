package com.thoughtworks.parkinglot.domain.model.parkingboy;

import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingBoyId;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLot;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotId;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author gitqh
 */
@Data
@AllArgsConstructor(staticName = "of")
public class ParkingBoy {
    private ParkingBoyId parkingBoyId;
    private List<ParkingLotId> parkingLotIds;
    private ParkingStrategy parkingStrategy;

    public Optional<ParkingLot> find(final List<ParkingLot> parkingLots) {
        return parkingStrategy.find(parkingLots);
    }
}
