package com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.response;

import com.thoughtworks.parkinglot.parkingcontext.domain.parking.Ticket;
import lombok.Value;

/**
 * @author gitqh
 */
@Value(staticConstructor = "of")
public class TicketResponse {
    private final String carLicensePlate;
    private final String parkingLotId;

    public static TicketResponse to(final Ticket ticket) {
        return TicketResponse.of(ticket.getLicensePlate(),
                ticket.getParkingLotId().getValue());
    }
}
