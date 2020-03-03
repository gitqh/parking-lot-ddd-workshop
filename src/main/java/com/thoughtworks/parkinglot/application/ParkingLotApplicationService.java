package com.thoughtworks.parkinglot.application;

import com.thoughtworks.parkinglot.domain.exception.IllegalTicketException;
import com.thoughtworks.parkinglot.domain.exception.NoEnoughCapacityException;
import com.thoughtworks.parkinglot.domain.model.parkinglot.Car;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLot;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotId;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotRepository;
import com.thoughtworks.parkinglot.domain.model.parkinglot.Ticket;
import com.thoughtworks.parkinglot.domain.model.parkinglot.TicketId;
import com.thoughtworks.parkinglot.domain.service.ParkingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author gitqh
 */
@Service
@AllArgsConstructor
public class ParkingLotApplicationService {
    private final ParkingService parkingService;
    private final ParkingLotRepository parkingLotRepository;

    public Ticket park(String licensePlate) {
        final Car car = new Car(licensePlate);
        final ParkingLot parkingLot = parkingService.find().orElseThrow(NoEnoughCapacityException::new);
        final Ticket ticket = parkingLot.park(car);
        return ticket;
    }

    public Car pick(TicketId ticketId, ParkingLotId parkingLotId) {
        final ParkingLot parkingLot = parkingLotRepository.findById(parkingLotId)
                .orElseThrow(IllegalTicketException::new);
        final Car car = parkingLot.pick(ticketId);
        return car;
    }
}
