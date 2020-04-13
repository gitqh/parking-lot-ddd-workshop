package com.thoughtworks.parkinglot.parkingcontext.domain.parking;

import com.thoughtworks.parkinglot.common.ddd.annotation.ValueObject;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLotId;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gitqh
 */
@AllArgsConstructor(staticName = "of")
@Getter
@ValueObject
public class Ticket {
    private final String licensePlate;
    private final ParkingLotId parkingLotId;
}
