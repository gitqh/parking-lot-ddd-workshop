package com.thoughtworks.parkinglot.domain.model.parkinglot;

import com.google.common.collect.Maps;
import com.thoughtworks.parkinglot.domain.exception.IllegalTicketException;
import com.thoughtworks.parkinglot.domain.exception.NoEnoughCapacityException;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author gitqh
 */
@NoArgsConstructor
@Getter
public class ParkingLot {
    private ParkingLotId id;

    private int capacity;

    private List<LicensePlate> licensePlates;

    private Map<TicketId, Car> tickets = Maps.newHashMap();

    public ParkingLot(ParkingLotId id, int capacity,
            List<LicensePlate> licensePlates) {
        this.id = id;
        this.capacity = capacity;
        this.licensePlates = licensePlates;
    }

    public Ticket park(Car car) {
        if (isAvailable()) {
            throw new NoEnoughCapacityException();
        }
        final Ticket ticket = new Ticket(TicketId.newTicketId(), car.getLicensePlate(), id);
        tickets.put(ticket.getId(), car);
        return ticket;
    }

    public Car pick(TicketId ticketId) {
        final Car car = tickets.get(ticketId);
        if (car == null) {
            throw new IllegalTicketException();
        }
        tickets.remove(ticketId);
        return car;
    }

    public boolean isAvailable() {
        return capacity > licensePlates.size();
    }
}
