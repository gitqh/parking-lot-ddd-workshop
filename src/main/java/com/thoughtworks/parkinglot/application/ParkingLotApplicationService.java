package com.thoughtworks.parkinglot.application;

import com.thoughtworks.parkinglot.domain.exception.IllegalTicketException;
import com.thoughtworks.parkinglot.domain.exception.NoEnoughCapacityException;
import com.thoughtworks.parkinglot.domain.model.parkingconfig.ParkingManagerConfigRepository;
import com.thoughtworks.parkinglot.domain.model.parkinglot.Car;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingBoy;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLot;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotId;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotRepository;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingManager;
import com.thoughtworks.parkinglot.domain.model.parkinglot.Ticket;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author gitqh
 */
@Service
@AllArgsConstructor
public class ParkingLotApplicationService {
    private final ParkingLotRepository parkingLotRepository;
    private final ParkingManagerConfigRepository parkingManagerMemRepository;
    private final ParkingBoyFactory parkingBoyFactory;
    private final ParkingManagerFactory parkingManagerFactory;

    public Ticket parkByParkingBoy(final String parkingBoyName, final String licensePlate) {
        ParkingBoy parkingBoy = parkingBoyFactory.findParkingBoyByName(parkingBoyName);
        ParkingLot parkingLot = parkingBoy.find().orElseThrow(NoEnoughCapacityException::new);
        return parkingLot.park(Car.of(licensePlate));
    }

    public Ticket parkByParkingManager(final String licensePlate, final String... parkingManagerName) {
        ParkingManager parkingManager = parkingManagerFactory.findParkingManagerByName(parkingManagerName);
        ParkingLot parkingLot = parkingManager.findParkingLot()
                .orElseThrow(NoEnoughCapacityException::new);
        return parkingLot.park(Car.of(licensePlate));
    }

    public List<ParkingLotId> listsParkingLotWithSpace(final String... parkingManagerName) {
        ParkingManager parkingManager = parkingManagerFactory.findParkingManagerByName(parkingManagerName);
        return parkingManager.listParkingLotIds().stream()
                .map(ParkingLot::getId)
                .collect(Collectors.toList());
    }

    public Car pick(final String licensePlate, final ParkingLotId parkingLotId) {
        final ParkingLot parkingLot = parkingLotRepository.findById(parkingLotId)
                .orElseThrow(IllegalTicketException::new);
        return parkingLot.pick(licensePlate);
    }
}
