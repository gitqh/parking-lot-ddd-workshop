package com.thoughtworks.parkinglot.parkingcontext.domain.policy;

import com.thoughtworks.parkinglot.annotation.ValueObject;

/**
 * @author gitqh
 */
@ValueObject
public enum ParkingPolicyEnum {
    FIRST_PRIORITY, MAX_SPACE_PRIORITY;
}
