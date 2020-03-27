package com.thoughtworks.parkinglot.parkingcontext.adapter.repository;

import com.thoughtworks.parkinglot.common.config.SpringContextConfig;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyId;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyRepository;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingManagerRepository;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingBoy;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLot;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLotRepository;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingManager;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingPolicy;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.ParkingLotFinder;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.ParkingLotFinderFactory;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author gitqh
 */
@AllArgsConstructor
@Component
public class ParkingLotFinderFactoryImpl implements ParkingLotFinderFactory {
    private final ParkingBoyRepository parkingBoyRepository;
    private final ParkingManagerRepository parkingManagerRepository;
    private final ParkingLotRepository parkingLotRepository;

    @Override
    public ParkingLotFinder newParkingBoy(final ParkingBoyId id) {
        com.thoughtworks.parkinglot.configcontext.domain.ParkingBoy parkingBoy =
                parkingBoyRepository.findById(id.getValue());
        List<ParkingLot> parkingLots = parkingLotRepository.findByIds((parkingBoy.getParkingLotIds()));
        ParkingPolicy parkingPolicy = (ParkingPolicy) SpringContextConfig.getBean(
                parkingBoy.getParkingPolicyName().getName());
        return ParkingBoy.of(parkingBoy.getName(), parkingLots, parkingPolicy);
    }

    @Override
    public ParkingLotFinder newParkingManager() {
        com.thoughtworks.parkinglot.configcontext.domain.ParkingManager parkingManager =
                parkingManagerRepository.findDefault();
        List<ParkingBoy> parkingBoys = parkingManager.getParkingBoyIds().stream()
                .map(this::newParkingBoy)
                .map(finder -> (ParkingBoy) finder)
                .collect(Collectors.toList());
        return ParkingManager.of(parkingManager.getName(), parkingBoys);
    }
}
