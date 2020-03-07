package com.thoughtworks.parkinglot.domain.model.parkinglot;

import com.google.common.collect.Maps;
import com.thoughtworks.parkinglot.domain.exception.IllegalTicketException;
import com.thoughtworks.parkinglot.domain.exception.NoEnoughCapacityException;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author gitqh
 */
@Data
@AllArgsConstructor(staticName = "of")
public class ParkingLot {
    private ParkingLotId id;

    private int capacity;

    private Map<TicketId, Car> ticketToCar = Maps.newHashMap();

    public ParkingLot(final ParkingLotId id, final int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public Ticket park(final Car car) {
        if (!isAvailable()) {
            throw new NoEnoughCapacityException();
        }
        final Ticket ticket = new Ticket(TicketId.newTicketId(), car.getLicensePlate(), id);
        ticketToCar.put(ticket.getId(), car);
        return ticket;
    }

    public Car pick(final TicketId ticketId) {
        final Car car = ticketToCar.get(ticketId);
        if (car == null) {
            throw new IllegalTicketException();
        }
        ticketToCar.remove(ticketId);
        return car;
    }

    public boolean isAvailable() {
        return capacity > ticketToCar.size();
    }

    public int getSpace() {
        return capacity - ticketToCar.size();
    }
}
