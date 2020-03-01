package com.thoughtworks.parkinglot.domain.parkingBoy.repository;

import com.thoughtworks.parkinglot.domain.parkingBoy.model.GraduateParkingBoy;
import com.thoughtworks.parkinglot.domain.parkingBoy.model.ParkingBoyId;

/**
 * @author gitqh
 */
public interface ParkingBoyRepository {
    GraduateParkingBoy find(ParkingBoyId parkingBoyId);

    void save(GraduateParkingBoy graduateParkingBoy);
}
