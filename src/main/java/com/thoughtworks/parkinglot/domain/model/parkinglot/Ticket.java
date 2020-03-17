package com.thoughtworks.parkinglot.domain.model.parkinglot;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gitqh
 */
@AllArgsConstructor(staticName = "of")
@Getter
public class Ticket {
    private final String licensePlate;
    private final ParkingLotId parkingLotId;
}
