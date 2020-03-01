package com.thoughtworks.parkinglot.domain.ticket.model;

import com.thoughtworks.parkinglot.common.model.AbstractId;
import java.util.UUID;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gitqh
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TicketId  extends AbstractId {
    private TicketId() {}

    public TicketId(String id) { super(id); }

    public static TicketId ticketId(String id) { return new TicketId(id); }

    public static TicketId newTicketId() {
        return ticketId(UUID.randomUUID().toString().replace("-", ""));
    }
}
