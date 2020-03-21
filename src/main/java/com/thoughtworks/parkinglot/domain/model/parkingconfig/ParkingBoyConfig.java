package com.thoughtworks.parkinglot.domain.model.parkingconfig;

import com.thoughtworks.parkinglot.domain.model.finder.ParkingLotId;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gitqh
 */
@AllArgsConstructor(staticName = "of")
@Getter
public class ParkingBoyConfig {
    private ParkingBoyId id;
    private String name;
    private List<ParkingLotId> parkingLotIds;
    private ParkingStrategyName parkingStrategyName;
}
