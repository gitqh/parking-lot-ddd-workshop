package com.thoughtworks.parkinglot.adapter.api.facade.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author gitqh
 */
@Getter
@AllArgsConstructor
@Builder
public class CarResponse {

    private final String carLicensePlate;

}
