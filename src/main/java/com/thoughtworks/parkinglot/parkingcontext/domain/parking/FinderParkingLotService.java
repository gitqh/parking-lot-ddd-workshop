package com.thoughtworks.parkinglot.parkingcontext.domain.parking;

import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLot;
import org.springframework.stereotype.Service;

@Service
public class FinderParkingLotService {
    public ParkingLot findParkingLot(final ParkingLotFinderSpecification parkingLotFinderSpecification) {
        return parkingLotFinderSpecification.findParkingLot();
    }
}
