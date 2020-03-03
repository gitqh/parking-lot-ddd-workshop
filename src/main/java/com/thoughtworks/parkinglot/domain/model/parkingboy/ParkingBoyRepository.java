package com.thoughtworks.parkinglot.domain.model.parkingboy;

import java.util.List;

/**
 * @author gitqh
 */
public interface ParkingBoyRepository {

    List<ParkingBoy> findAll();

}
