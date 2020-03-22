package com.thoughtworks.parkinglot.parkingcontext.application;

import com.thoughtworks.parkinglot.parkingcontext.domain.exception.IllegalTicketException;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingBoySpecification;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLot;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLotId;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLotRepository;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingManager;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingManagerSpecification;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.Car;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.FinderParkingLotService;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.ParkingLotFinderFactory;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.ParkingLotFinderSpecification;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.Ticket;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author gitqh
 */
@Service
@AllArgsConstructor
public class ParkingLotApplicationService {
    private final ParkingLotFinderFactory parkingLotFinderFactory;
    private final ParkingLotRepository parkingLotRepository;
    private final FinderParkingLotService finderParkingLotService;

    public Ticket parkByParkingBoy(final String parkingBoyId, final String licensePlate) {
        ParkingLotFinderSpecification parkingLotFinderSpecification =
                new ParkingBoySpecification(parkingBoyId, parkingLotFinderFactory);
        ParkingLot parkingLot = finderParkingLotService.findParkingLot(parkingLotFinderSpecification);
        return parkingLot.park(Car.of(licensePlate));
    }

    public Ticket parkByParkingManager(final String licensePlate) {
        ParkingLotFinderSpecification parkingLotFinderSpecification =
                new ParkingManagerSpecification(parkingLotFinderFactory);
        ParkingLot parkingLot = finderParkingLotService.findParkingLot(parkingLotFinderSpecification);
        return parkingLot.park(Car.of(licensePlate));
    }

    public List<ParkingLotId> listsParkingLotWithSpace() {
        ParkingManager parkingManager = (ParkingManager) parkingLotFinderFactory.newParkingManager();
        return parkingManager.listParkingLotIds();
    }

    public Car pick(final String licensePlate, final ParkingLotId parkingLotId) {
        final ParkingLot parkingLot = parkingLotRepository.findById(parkingLotId)
                .orElseThrow(IllegalTicketException::new);
        return parkingLot.pick(licensePlate);
    }
}
