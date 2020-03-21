package com.thoughtworks.parkinglot.domain.model.parkingconfig;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gitqh
 */
@AllArgsConstructor(staticName = "of")
@Getter
public class ParkingManagerConfig {
    private ParkingManagerConfigId id;
    private String name;
    private List<ParkingBoyId> parkingBoyIds;
}
