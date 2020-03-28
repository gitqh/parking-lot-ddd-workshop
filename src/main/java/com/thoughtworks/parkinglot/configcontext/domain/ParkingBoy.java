package com.thoughtworks.parkinglot.configcontext.domain;

import com.thoughtworks.parkinglot.annotation.Entity;
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
public class ParkingBoy {
    private ParkingBoyId id;
    private ParkingBoyName name;
    private List<ParkingLotId> parkingLotIds;
    private String parkingPolicy;
}
