package com.thoughtworks.parkinglot.adapter.api.facade.mapper;

import com.thoughtworks.parkinglot.adapter.api.facade.response.TicketResponse;
import com.thoughtworks.parkinglot.domain.model.parkinglot.Ticket;
import org.springframework.stereotype.Component;

/**
 * @author gitqh
 */
@Component
public class TicketMapper {

    public TicketResponse to(Ticket ticket) {
        return TicketResponse.builder()
                .carLicensePlate(ticket.getLicensePlate())
                .parkingLotId(ticket.getParkingLotId().getValue())
                .ticketId(ticket.getId().getValue())
                .build();
    }

}