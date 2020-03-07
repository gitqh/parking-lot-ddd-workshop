package com.thoughtworks.parkinglot.adapter.api.facade.response;

import lombok.Value;

/**
 * @author gitqh
 */
@Value(staticConstructor = "of")
public class TicketResponse {

    private final String ticketId;
    private final String carLicensePlate;
    private final String parkingLotId;

}
