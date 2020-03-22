package com.thoughtworks.parkinglot.configcontext.application;

import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoy;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyId;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyRepository;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingManager;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author gitqh
 */
@Service
@AllArgsConstructor
public class ParkingConfigApplicationService {
    private ParkingManagerRepository parkingManagerRepository;
    private ParkingBoyRepository parkingBoyRepository;

    public ParkingManager findParkingManager() {
        return parkingManagerRepository.findDefault();
    }

    public ParkingBoy findParkingBoy(final ParkingBoyId parkingBoyId) {
        return parkingBoyRepository.findById(parkingBoyId.getValue());
    }
}
