package com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.mapper;

import com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.response.TicketResponse;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.Ticket;
import org.springframework.stereotype.Component;

/**
 * @author gitqh
 */
@Component
public class TicketMapper {

    public TicketResponse to(final Ticket ticket) {
        return TicketResponse.of(ticket.getLicensePlate(),
            ticket.getParkingLotId().getValue());
    }

}
