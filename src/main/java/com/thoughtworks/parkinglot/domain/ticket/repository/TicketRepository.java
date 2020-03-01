package com.thoughtworks.parkinglot.domain.ticket.repository;

import com.thoughtworks.parkinglot.domain.ticket.model.Ticket;

/**
 * @author gitqh
 */
public interface TicketRepository {

    void save(Ticket ticket);

    String newTicketId();
}
