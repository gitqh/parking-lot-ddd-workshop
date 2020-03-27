package com.thoughtworks.parkinglot.parkingcontext.domain.parking;

import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLot;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class FinderParkingLotService {
    public Optional<ParkingLot> findParkingLot(final ParkingLotFinderSpecification parkingLotFinderSpecification) {
        return parkingLotFinderSpecification.findParkingLotFinder().findParkingLot();
    }
}
