package com.thoughtworks.parkinglot.domain.model.finder;

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

    private Map<String, Car> ticketToCar = Maps.newHashMap();

    public ParkingLot(final ParkingLotId id, final int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public Ticket park(final Car car) {
        if (!isAvailable()) {
            throw new NoEnoughCapacityException();
        }
        final Ticket ticket = Ticket.of(car.getLicensePlate(), id);
        ticketToCar.put(car.getLicensePlate(), car);
        return ticket;
    }

    public Car pick(final String licensePlate) {
        final Car car = ticketToCar.get(licensePlate);
        if (car == null) {
            throw new IllegalTicketException();
        }
        ticketToCar.remove(licensePlate);
        return car;
    }

    public boolean isAvailable() {
        return capacity > ticketToCar.size();
    }

    public int getSpace() {
        return capacity - ticketToCar.size();
    }
}
