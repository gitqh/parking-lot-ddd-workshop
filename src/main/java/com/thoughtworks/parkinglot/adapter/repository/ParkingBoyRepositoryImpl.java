package com.thoughtworks.parkinglot.adapter.repository;

import com.thoughtworks.parkinglot.adapter.repository.memRepository.ParkingBoyMemRepository;
import com.thoughtworks.parkinglot.domain.model.parkingboy.ParkingBoy;
import com.thoughtworks.parkinglot.domain.model.parkingboy.ParkingBoyRepository;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingBoyId;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author gitqh
 */
@Service
@AllArgsConstructor
public class ParkingBoyRepositoryImpl implements ParkingBoyRepository {

    private ParkingBoyMemRepository parkingBoyRepository;

    @Override
    public ParkingBoy find(ParkingBoyId parkingBoyId) {
        return parkingBoyRepository.find(parkingBoyId);
    }

    @Override
    public void save(ParkingBoy parkingBoy) {
        parkingBoyRepository.save(parkingBoy);
    }

    @Override
    public List<ParkingBoy> findAll() {
        return parkingBoyRepository.findAll();
    }
}
