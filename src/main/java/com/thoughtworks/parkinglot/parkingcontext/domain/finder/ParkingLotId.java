package com.thoughtworks.parkinglot.parkingcontext.domain.finder;

import com.thoughtworks.parkinglot.common.ddd.annotation.ValueObject;
import com.thoughtworks.parkinglot.common.ddd.domain.core.AbstractId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gitqh
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ValueObject
public class ParkingLotId extends AbstractId {
    public ParkingLotId(final String value) {
        super(value);
    }
}
