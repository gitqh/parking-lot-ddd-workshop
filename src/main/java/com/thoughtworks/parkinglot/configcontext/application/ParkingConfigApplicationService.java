package com.thoughtworks.parkinglot.configcontext.application;

import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyConfig;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyConfigId;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyRepository;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingManagerConfig;
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

    public ParkingManagerConfig findParkingManager() {
        return parkingManagerRepository.findDefault();
    }

    public ParkingBoyConfig findParkingBoy(final ParkingBoyConfigId parkingBoyConfigId) {
        return parkingBoyRepository.findById(parkingBoyConfigId.getValue());
    }
}
