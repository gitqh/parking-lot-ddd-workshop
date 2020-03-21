package com.thoughtworks.parkinglot.domain.model.parkingconfig;

import com.thoughtworks.parkinglot.common.model.AbstractId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gitqh
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ParkingBoyId extends AbstractId {
    public ParkingBoyId(final String value) {
        super(value);
    }
}
