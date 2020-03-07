package com.thoughtworks.parkinglot.domain.model.parkinglot;

import com.thoughtworks.parkinglot.common.model.AbstractId;
import java.util.UUID;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gitqh
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TicketId  extends AbstractId {
    public TicketId(final String value) {
        super(value);
    }

    public static TicketId ticketId(final String id) {
        return new TicketId(id);
    }

    public static TicketId newTicketId() {
        return ticketId(UUID.randomUUID().toString().replace("-", ""));
    }
}
