package com.thoughtworks.parkinglot.application;

import com.thoughtworks.parkinglot.domain.model.parkingconfig.ParkingManagerConfig;
import com.thoughtworks.parkinglot.domain.model.parkingconfig.ParkingManagerConfigRepository;
import com.thoughtworks.parkinglot.domain.model.finder.ParkingBoy;
import com.thoughtworks.parkinglot.domain.model.finder.ParkingManager;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author gitqh
 */
@AllArgsConstructor
@Component
public class ParkingManagerFactory {
    private ParkingManagerConfigRepository parkingManagerConfigRepository;
    private ParkingBoyFactory parkingBoyFactory;

    public ParkingManager create(final String... name) {

        ParkingManagerConfig parkingManagerConfig = name == null
                ? parkingManagerConfigRepository.findDefault()
                : parkingManagerConfigRepository.findByName(name[0]);
        List<ParkingBoy> parkingBoys = parkingManagerConfig.getParkingBoyIds().stream()
                .map(id -> parkingBoyFactory.create(id))
                .collect(Collectors.toList());
        return ParkingManager.of(parkingManagerConfig.getName(), parkingBoys);
    }
}
