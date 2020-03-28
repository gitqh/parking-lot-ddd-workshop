package com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gitqh
 */
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Data
public class CarResponse {
    private String carLicensePlate;
}
