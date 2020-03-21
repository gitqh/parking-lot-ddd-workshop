package com.thoughtworks.parkinglot.domain.model.finder;

import lombok.Value;

/**
 * @author gitqh
 */
@Value(staticConstructor = "of")
public class Car {
    private String licensePlate;
}
