package com.thoughtworks.parkinglot.application;

import com.thoughtworks.parkinglot.config.SpringContextConfig;
import com.thoughtworks.parkinglot.domain.model.parkingconfig.ParkingBoyConfig;
import com.thoughtworks.parkinglot.domain.model.parkingconfig.ParkingBoyId;
import com.thoughtworks.parkinglot.domain.model.parkingconfig.ParkingBoyConfigRepository;
import com.thoughtworks.parkinglot.domain.model.finder.ParkingBoy;
import com.thoughtworks.parkinglot.domain.model.finder.ParkingLot;
import com.thoughtworks.parkinglot.domain.model.finder.ParkingLotId;
import com.thoughtworks.parkinglot.domain.model.finder.ParkingLotRepository;
import com.thoughtworks.parkinglot.domain.model.finder.ParkingStrategy;
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

    public ParkingBoy create(final ParkingBoyId id) {
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
