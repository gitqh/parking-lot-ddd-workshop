package com.thoughtworks.parkinglot.configcontext.domain;

import com.thoughtworks.parkinglot.common.ddd.annotation.Entity;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLotId;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gitqh
 */
@AllArgsConstructor(staticName = "of")
@Getter
@Entity
public class ParkingBoyConfig {
    private ParkingBoyConfigId id;
    private ParkingBoyConfigName name;
    private List<ParkingLotId> parkingLotIds;
    private String parkingPolicy;
}
