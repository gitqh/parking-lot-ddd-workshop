package com.thoughtworks.parkinglot.domain.model.parkingboy;

import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingBoyId;
import java.util.List;

/**
 * @author gitqh
 */
public interface ParkingBoyRepository {

    ParkingBoy find(ParkingBoyId parkingBoyId);

    void save(ParkingBoy parkingBoy);

    List<ParkingBoy> findAll();

}
