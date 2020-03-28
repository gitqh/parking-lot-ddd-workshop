package com.thoughtworks.parkinglot.parkingcontext.domain.policy;

import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingPolicy;
import org.springframework.stereotype.Component;

/**
 * @author gitqh
 */
@Component
public class ParkingPolicyFactory {
    public ParkingPolicy createParkingPolicy(final ParkingPolicyEnum parkingPolicyEnum) {
        switch (parkingPolicyEnum) {
            case FIRST_PRIORITY:
                return JuniorParkingPolicy.of();
            case MAX_SPACE_PRIORITY:
                return SeniorParkingParkingPolicy.of();
            default:
                throw new IllegalStateException("Unexpected value: " + parkingPolicyEnum);
        }
    }
}
