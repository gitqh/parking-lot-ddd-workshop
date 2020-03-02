package com.thoughtworks.parkinglot.domain.model.parkinglot;

import com.thoughtworks.parkinglot.common.model.AbstractId;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author gitqh
 */
@Data
@AllArgsConstructor
public class ParkingLotId extends AbstractId {
    public ParkingLotId(String id) { super(id); }

    public static ParkingLotId parkingLotId(String id) { return new ParkingLotId(id); }

}
