package com.thoughtworks.parkinglot.application;

import com.thoughtworks.parkinglot.domain.exception.IllegalTicketException;
import com.thoughtworks.parkinglot.domain.exception.NoEnoughCapacityException;
import com.thoughtworks.parkinglot.domain.model.finder.Car;
import com.thoughtworks.parkinglot.domain.model.finder.ParkingBoy;
import com.thoughtworks.parkinglot.domain.model.finder.ParkingLot;
import com.thoughtworks.parkinglot.domain.model.finder.ParkingLotId;
import com.thoughtworks.parkinglot.domain.model.finder.ParkingLotRepository;
import com.thoughtworks.parkinglot.domain.model.finder.ParkingManager;
import com.thoughtworks.parkinglot.domain.model.finder.Ticket;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author gitqh
 */
@Service
@AllArgsConstructor
public class ParkingLotApplicationService {
    private final ParkingLotRepository parkingLotRepository;
    private final ParkingBoyFactory parkingBoyFactory;
    private final ParkingManagerFactory parkingManagerFactory;

    public Ticket parkByParkingBoy(final String parkingBoyName, final String licensePlate) {
        ParkingBoy parkingBoy = parkingBoyFactory.create(parkingBoyName);
        ParkingLot parkingLot = parkingBoy.findParkingLot().orElseThrow(NoEnoughCapacityException::new);
        return parkingLot.park(Car.of(licensePlate));
    }

    public Ticket parkByParkingManager(final String licensePlate, final String... parkingManagerName) {
        ParkingManager parkingManager = parkingManagerFactory.create(parkingManagerName);
        ParkingLot parkingLot = parkingManager.findParkingLot().orElseThrow(NoEnoughCapacityException::new);
        return parkingLot.park(Car.of(licensePlate));
    }

    public List<ParkingLotId> listsParkingLotWithSpace(final String... parkingManagerName) {
        ParkingManager parkingManager = parkingManagerFactory.create(parkingManagerName);
        return parkingManager.listParkingLotIds();
    }

    public Car pick(final String licensePlate, final ParkingLotId parkingLotId) {
        final ParkingLot parkingLot = parkingLotRepository.findById(parkingLotId)
                .orElseThrow(IllegalTicketException::new);
        return parkingLot.pick(licensePlate);
    }
}
