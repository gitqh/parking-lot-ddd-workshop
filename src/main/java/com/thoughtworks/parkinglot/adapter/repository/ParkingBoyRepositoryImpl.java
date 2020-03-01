package com.thoughtworks.parkinglot.adapter.repository;

import com.thoughtworks.parkinglot.adapter.repository.jpaRepository.ParkingBoyJpaRepository;
import com.thoughtworks.parkinglot.domain.parkingBoy.model.GraduateParkingBoy;
import com.thoughtworks.parkinglot.domain.parkingBoy.model.ParkingBoyId;
import com.thoughtworks.parkinglot.domain.parkingBoy.repository.ParkingBoyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author gitqh
 */
@Component
@AllArgsConstructor
public class ParkingBoyRepositoryImpl implements ParkingBoyRepository {

    private final ParkingBoyJpaRepository parkingBoyJpaRepository;

    @Override
    public GraduateParkingBoy find(ParkingBoyId parkingBoyId) {
        return parkingBoyJpaRepository.findById(parkingBoyId).orElse(null);
    }

    @Override
    public void save(GraduateParkingBoy graduateParkingBoy) {
        parkingBoyJpaRepository.save(graduateParkingBoy);
    }
}
