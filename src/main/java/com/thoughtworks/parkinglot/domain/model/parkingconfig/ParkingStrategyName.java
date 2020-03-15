package com.thoughtworks.parkinglot.domain.model.parkingconfig;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gitqh
 */
@AllArgsConstructor(staticName = "of")
@Getter
public class ParkingStrategyName {
    private String name;
}
