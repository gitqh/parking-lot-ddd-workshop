package com.thoughtworks.parkinglot.parkingcontext.domain.finder;

import com.google.common.collect.Maps;
import com.thoughtworks.parkinglot.annotation.Entity;
import com.thoughtworks.parkinglot.parkingcontext.domain.exception.IllegalTicketException;
import com.thoughtworks.parkinglot.parkingcontext.domain.exception.NoEnoughCapacityException;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.Car;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.Ticket;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author gitqh
 */
@Data
@AllArgsConstructor(staticName = "of")
@Entity
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
        var ticket = Ticket.of(car.getLicensePlate(), id);
        ticketToCar.put(car.getLicensePlate(), car);
        return ticket;
    }

    public Car pick(final String licensePlate) {
        var car = ticketToCar.get(licensePlate);
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
