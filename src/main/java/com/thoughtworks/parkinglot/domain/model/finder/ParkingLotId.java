package com.thoughtworks.parkinglot.domain.model.finder;

import com.thoughtworks.parkinglot.common.model.AbstractId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gitqh
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ParkingLotId extends AbstractId {
    public ParkingLotId(final String value) {
        super(value);
    }
}
