package com.thoughtworks.parkinglot.domain.ticket.model;

import com.thoughtworks.parkinglot.domain.parkingBoy.model.LicensePlate;

/**
 * @author gitqh
 */
public class Ticket {
    private final TicketId id;

    private LicensePlate licensePlate;

    public TicketId getId() {
        return id;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public Ticket(TicketId id, LicensePlate licensePlate) {
        this.id = id;
        this.licensePlate = licensePlate;
    }

}
