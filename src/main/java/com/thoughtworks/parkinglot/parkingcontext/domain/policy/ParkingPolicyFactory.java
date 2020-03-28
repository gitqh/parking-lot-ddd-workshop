package com.thoughtworks.parkinglot.parkingcontext.domain.policy;

import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingPolicy;
import org.springframework.stereotype.Component;

/**
 * @author gitqh
 */
@Component
public class ParkingPolicyFactory {
    public ParkingPolicy createParkingPolicy(ParkingPolicyEnum parkingPolicyEnum) {
        switch (parkingPolicyEnum) {
            case FIRST:
                return JuniorParkingPolicy.of();
            case MAX_SPACE:
                return SeniorParkingParkingPolicy.of();
            default:
                throw new IllegalStateException("Unexpected value: " + parkingPolicyEnum);
        }
    }
}
