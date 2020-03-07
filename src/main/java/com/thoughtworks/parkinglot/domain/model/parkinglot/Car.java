package com.thoughtworks.parkinglot.domain.model.parkinglot;

import lombok.Value;

/**
 * @author gitqh
 */
@Value(staticConstructor = "of")
public class Car {
    private String LicensePlate;
}
