package com.thoughtworks.parkinglot.domain.model.parkingboy;

import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingBoyId;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLot;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotId;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gitqh
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParkingBoy {
    private ParkingBoyId parkingBoyId;
    private GeneralParkingStrategy parkingStrategy;
    private List<ParkingLotId> parkingLotIds;

    public Optional<ParkingLot> find(List<ParkingLot> parkingLots) {
        return parkingStrategy.find(parkingLots);
    }
}
