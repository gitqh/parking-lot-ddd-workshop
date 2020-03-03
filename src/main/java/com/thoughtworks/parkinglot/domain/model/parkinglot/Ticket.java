package com.thoughtworks.parkinglot.domain.model.parkinglot;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gitqh
 */
@AllArgsConstructor
@Getter
public class Ticket {
    private final TicketId id;
    private final String licensePlate;
    private final ParkingLotId parkingLotId;

}
