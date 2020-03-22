package com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.response;

import lombok.Value;

/**
 * @author gitqh
 */
@Value(staticConstructor = "of")
public class TicketResponse {
    private final String carLicensePlate;
    private final String parkingLotId;
}
