package com.thoughtworks.parkinglot.configcontext.domain;

import com.thoughtworks.parkinglot.annotation.Entity;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gitqh
 */
@AllArgsConstructor(staticName = "of")
@Getter
@Entity
public class ParkingManagerConfig {
    private ParkingManagerConfigId id;
    private String name;
    private List<ParkingBoyConfigId> parkingBoyConfigIds;
}
