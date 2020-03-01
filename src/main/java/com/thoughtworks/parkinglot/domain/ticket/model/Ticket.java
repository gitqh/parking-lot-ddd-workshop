package com.thoughtworks.parkinglot.domain.ticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author gitqh
 */
@Data
@AllArgsConstructor
public class Ticket {
    private final TicketId id;

    private String number;

}
