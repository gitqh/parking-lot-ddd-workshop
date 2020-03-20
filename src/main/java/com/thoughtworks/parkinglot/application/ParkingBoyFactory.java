package com.thoughtworks.parkinglot.application;

import com.thoughtworks.parkinglot.config.SpringContextConfig;
import com.thoughtworks.parkinglot.domain.model.parkingconfig.ParkingBoyConfig;
import com.thoughtworks.parkinglot.domain.model.parkingconfig.ParkingBoyConfigId;
import com.thoughtworks.parkinglot.domain.model.parkingconfig.ParkingBoyConfigRepository;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingBoy;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLot;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotId;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotRepository;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingStrategy;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author gitqh
 */
@AllArgsConstructor
@Component
public class ParkingBoyFactory {

    private ParkingBoyConfigRepository parkingBoyConfigRepository;

    private ParkingLotRepository parkingLotRepository;

    public ParkingBoy create(final String name) {
        ParkingBoyConfig parkingBoyConfig = parkingBoyConfigRepository.findByName(name);
        List<ParkingLot> parkingLots = findParkingLot(parkingBoyConfig.getParkingLotIds());
        ParkingStrategy parkingStrategy = (ParkingStrategy) SpringContextConfig.getBean(
                parkingBoyConfig.getParkingStrategyName().getName());
        return ParkingBoy.of(parkingBoyConfig.getName(), parkingLots, parkingStrategy);
    }

    public ParkingBoy create(final ParkingBoyConfigId id) {
        ParkingBoyConfig parkingBoyConfig = parkingBoyConfigRepository.findById(id.getValue());
        List<ParkingLot> parkingLots = findParkingLot(parkingBoyConfig.getParkingLotIds());
        ParkingStrategy parkingStrategy = (ParkingStrategy) SpringContextConfig.getBean(
                parkingBoyConfig.getParkingStrategyName().getName());
        return ParkingBoy.of(parkingBoyConfig.getName(), parkingLots, parkingStrategy);
    }

    private List<ParkingLot> findParkingLot(final List<ParkingLotId> ids) {
        return parkingLotRepository.findByIds(ids);
    }
}
