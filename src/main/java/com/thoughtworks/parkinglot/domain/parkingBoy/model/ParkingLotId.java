package com.thoughtworks.parkinglot.domain.parkingBoy.model;

import com.thoughtworks.parkinglot.common.model.AbstractId;
import java.util.UUID;

/**
 * @author gitqh
 */
public class ParkingLotId extends AbstractId {
    private ParkingLotId() {}

    private ParkingLotId(String id) { super(id); }

    public static ParkingLotId parkingLotId(String id) { return new ParkingLotId(id); }

    public static ParkingLotId newParkingLotId() {
        return parkingLotId(UUID.randomUUID().toString().replace("-", ""));
    }
}
