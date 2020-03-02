package com.thoughtworks.parkinglot.adapter.repository;

import com.thoughtworks.parkinglot.adapter.repository.memRepository.ParkingLotMemRepository;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLot;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotId;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author gitqh
 */
@Service
@AllArgsConstructor
public class ParkingLotRepositoryImpl implements ParkingLotRepository {

    private ParkingLotMemRepository parkingLotMemRepository;

    @Override
    public void save(ParkingLot parkingLot) {
        parkingLotMemRepository.save(parkingLot);
    }

    @Override
    public Optional<ParkingLot> findById(ParkingLotId parkingLotId) {
        return parkingLotMemRepository.findById(parkingLotId);
    }
}
