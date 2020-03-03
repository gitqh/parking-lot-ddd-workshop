package com.thoughtworks.parkinglot.domain.model.parkingboy;

import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLot;
import java.util.List;

/**
 * @author gitqh
 */
public interface ParkingStrategy {
    ParkingLot find(List<ParkingLot> parkingLots);
}
