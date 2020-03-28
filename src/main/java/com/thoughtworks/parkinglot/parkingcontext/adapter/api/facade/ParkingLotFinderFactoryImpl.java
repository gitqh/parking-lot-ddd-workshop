package com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade;

import com.thoughtworks.parkinglot.configcontext.application.ParkingConfigApplicationService;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyId;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingBoy;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLotRepository;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingManager;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.ParkingLotFinder;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.ParkingLotFinderFactory;
import com.thoughtworks.parkinglot.parkingcontext.domain.policy.ParkingPolicyEnum;
import com.thoughtworks.parkinglot.parkingcontext.domain.policy.ParkingPolicyFactory;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author gitqh
 */
@AllArgsConstructor(staticName = "of")
@Component
public class ParkingLotFinderFactoryImpl implements ParkingLotFinderFactory {
    private final ParkingConfigApplicationService parkingConfigApplicationService;
    private final ParkingLotRepository parkingLotRepository;
    private final ParkingPolicyFactory parkingPolicyFactory;

    @Override
    public ParkingLotFinder newParkingBoy(final String id) {
        com.thoughtworks.parkinglot.configcontext.domain.ParkingBoy parkingBoy =
                parkingConfigApplicationService.findParkingBoy(new ParkingBoyId(id));
        var parkingLots = parkingLotRepository.findByIds((parkingBoy.getParkingLotIds()));
        var parkingPolicy = parkingPolicyFactory.createParkingPolicy(ParkingPolicyEnum.valueOf(parkingBoy.getParkingPolicy()));
        return ParkingBoy.of(parkingBoy.getName().getValue(), parkingLots, parkingPolicy);
    }

    @Override
    public ParkingLotFinder newParkingManager() {
        com.thoughtworks.parkinglot.configcontext.domain.ParkingManager parkingManager =
                parkingConfigApplicationService.findParkingManager();
        var parkingBoys = parkingManager.getParkingBoyIds().stream()
                .map(id -> this.newParkingBoy(id.getValue()))
                .map(finder -> (ParkingBoy) finder)
                .collect(Collectors.toList());
        return ParkingManager.of(parkingManager.getName(), parkingBoys);
    }
}
