package com.thoughtworks.parkinglot.adapter.api.facade.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author gitqh
 */
@Getter
@AllArgsConstructor
@Builder
public class TicketResponse {

    private final String ticketId;
    private final String carLicensePlate;
    private final String parkingLotId;

}
