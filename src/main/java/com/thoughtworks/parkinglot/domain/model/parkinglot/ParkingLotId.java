package com.thoughtworks.parkinglot.domain.model.parkinglot;

import com.thoughtworks.parkinglot.common.model.AbstractId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gitqh
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ParkingLotId extends AbstractId {
    public ParkingLotId(String id) { super(id); }

    public static ParkingLotId parkingLotId(String id) { return new ParkingLotId(id); }

}
