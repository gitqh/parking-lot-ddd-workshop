package com.thoughtworks.parkinglot.parkingcontext.domain.policy;

import com.thoughtworks.parkinglot.annotation.ValueObject;

/**
 * @author gitqh
 */
@ValueObject
public enum ParkingPolicyEnum {
    FIRST("FirstPriority"), MAX_SPACE("MaxSpacePriority");

    private String policyName;

    ParkingPolicyEnum(String policyName) {
        this.policyName = policyName;
    }
}
