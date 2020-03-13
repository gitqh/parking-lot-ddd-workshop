package com.thoughtworks.parkinglot.domain.model.parkingboy;

import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingBoyId;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotId;
import java.util.List;

/**
 * @author gitqh
 */
public final class ParkingBoyFactory {

    private ParkingBoyFactory() {
    }

    public static ParkingBoy createParkingBoy(final List<ParkingLotId> parkingLotIds,
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
