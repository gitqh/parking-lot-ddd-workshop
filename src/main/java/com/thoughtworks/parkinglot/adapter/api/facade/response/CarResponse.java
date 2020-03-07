package com.thoughtworks.parkinglot.adapter.api.facade.response;

import lombok.Value;

/**
 * @author gitqh
 */
@Value(staticConstructor = "of")
public class CarResponse {

    private final String carLicensePlate;

}
