package com.thoughtworks.parkinglot.domain.service;

import com.thoughtworks.parkinglot.domain.model.parkingboy.ParkingBoyRepository;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLot;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author gitqh
 */
@AllArgsConstructor
@Service
public class ParkingService {
    private final ParkingLotRepository parkingLotRepository;
    private final ParkingBoyRepository parkingBoyRepository;

    public Optional<ParkingLot> find() {
        return parkingBoyRepository.findAll().stream()
                .map(boy -> {
                    final List<ParkingLot> parkingLots = boy.getParkingLotIds().stream()
                            .map(id -> parkingLotRepository.findById(id).orElseThrow(RuntimeException::new))
                            .collect(Collectors.toList());
                    return boy.find(parkingLots);
                })
                .findFirst();
    }


}
