package com.thoughtworks.parkinglot.configcontext.domain;

import com.thoughtworks.parkinglot.common.ddd.annotation.ValueObject;
import com.thoughtworks.parkinglot.common.ddd.domain.core.AbstractId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gitqh
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ValueObject
public class ParkingBoyConfigId extends AbstractId {
    public ParkingBoyConfigId(final String value) {
        super(value);
    }
}
