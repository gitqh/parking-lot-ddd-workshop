package com.thoughtworks.parkinglot.adapter.repository;

import com.thoughtworks.parkinglot.adapter.repository.jpaRepository.LicensePlateJpaRepository;
import com.thoughtworks.parkinglot.adapter.repository.jpaRepository.ParkingBoyJpaRepository;
import com.thoughtworks.parkinglot.domain.parkingBoy.model.GraduateParkingBoy;
import com.thoughtworks.parkinglot.domain.parkingBoy.model.LicensePlate;
import com.thoughtworks.parkinglot.domain.parkingBoy.model.ParkingBoyId;
import com.thoughtworks.parkinglot.domain.parkingBoy.repository.ParkingBoyRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author gitqh
 */
@Component
@AllArgsConstructor
public class ParkingBoyRepositoryImpl implements ParkingBoyRepository {

    private final ParkingBoyJpaRepository parkingBoyJpaRepository;
    private final LicensePlateJpaRepository licensePlateJpaRepository;

    @Override
    public GraduateParkingBoy find(ParkingBoyId parkingBoyId) {
        return parkingBoyJpaRepository.findById(parkingBoyId).orElse(null);
    }

    @Override
    @Transactional
    public void save(GraduateParkingBoy graduateParkingBoy) {
        List<LicensePlate> licensePlates = graduateParkingBoy.getParkingLots().stream()
                .flatMap(lot -> lot.getLicensePlates().stream())
                .collect(Collectors.toList());
        parkingBoyJpaRepository.save(graduateParkingBoy);
        licensePlateJpaRepository.saveAll(licensePlates);
    }
}
