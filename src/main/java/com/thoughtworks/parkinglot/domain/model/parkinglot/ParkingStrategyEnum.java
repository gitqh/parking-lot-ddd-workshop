package com.thoughtworks.parkinglot.domain.model.parkinglot;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @author gitqh
 */
@Getter
@AllArgsConstructor
public enum  ParkingStrategyEnum {
    GENERAL(0), MAX_SPACE(1);

    @EqualsAndHashCode.Include
    private int value;

}
