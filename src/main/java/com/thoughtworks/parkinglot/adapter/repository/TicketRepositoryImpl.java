package com.thoughtworks.parkinglot.adapter.repository;

import com.thoughtworks.parkinglot.domain.ticket.model.Ticket;
import com.thoughtworks.parkinglot.domain.ticket.repository.TicketRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author gitqh
 */
@Component
@AllArgsConstructor
public class TicketRepositoryImpl implements TicketRepository {


    @Override
    public void save(Ticket ticket) {
    }

    @Override
    public String newTicketId() {
        return UUID.randomUUID().toString();
    }
}
