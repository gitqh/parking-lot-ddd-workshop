package com.thoughtworks.parkinglot.domain.model.parkingboy;

import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingBoyId;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotId;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author gitqh
 */
@Component
public class ParkingBoyFactory {
    public ParkingBoy createParkingBoy(final List<ParkingLotId> parkingLotIds,
            final ParkingStrategyEnum parkingStrategyEnum) {
        switch (parkingStrategyEnum) {
            case MAX_SPACE:
                return ParkingBoy.of(ParkingBoyId.newParkingBoyId(), parkingLotIds,
                        MaxSpaceFirstParkingStrategy.of());
            default:
                return ParkingBoy.of(ParkingBoyId.newParkingBoyId(), parkingLotIds,
                        NaturalParkingStrategy.of());
        }
    }

}
