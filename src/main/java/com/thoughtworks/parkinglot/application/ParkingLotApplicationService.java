package com.thoughtworks.parkinglot.application;

import com.thoughtworks.parkinglot.domain.exception.IllegalTicketException;
import com.thoughtworks.parkinglot.domain.exception.NoEnoughCapacityException;
import com.thoughtworks.parkinglot.domain.model.parkinglot.Car;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLot;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotId;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotRepository;
import com.thoughtworks.parkinglot.domain.model.parkinglot.Ticket;
import com.thoughtworks.parkinglot.domain.service.ParkingManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author gitqh
 */
@Service
@AllArgsConstructor
public class ParkingLotApplicationService {
    private final ParkingManager parkingManager;
    private final ParkingLotRepository parkingLotRepository;

    public Ticket park(final String licensePlate) {
        final Car car = Car.of(licensePlate);
        final ParkingLot parkingLot = parkingManager.find().orElseThrow(NoEnoughCapacityException::new);
        final Ticket ticket = parkingLot.park(car);
        return ticket;
    }

    public Car pick(final String licensePlate, final ParkingLotId parkingLotId) {
        final ParkingLot parkingLot = parkingLotRepository.findById(parkingLotId)
                .orElseThrow(IllegalTicketException::new);
        final Car car = parkingLot.pick(licensePlate);
        return car;
    }
}
