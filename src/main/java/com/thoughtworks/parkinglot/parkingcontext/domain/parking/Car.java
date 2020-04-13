package com.thoughtworks.parkinglot.parkingcontext.domain.parking;

import com.thoughtworks.parkinglot.common.ddd.annotation.ValueObject;
import lombok.Value;

/**
 * @author gitqh
 */
@Value(staticConstructor = "of")
@ValueObject
public class Car {
    private String licensePlate;
}
