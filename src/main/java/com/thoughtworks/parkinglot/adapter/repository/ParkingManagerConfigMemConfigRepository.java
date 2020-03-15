package com.thoughtworks.parkinglot.adapter.repository;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.thoughtworks.parkinglot.domain.exception.ParkingManagerNotFoundException;
import com.thoughtworks.parkinglot.domain.model.parkingconfig.ParkingBoyConfigId;
import com.thoughtworks.parkinglot.domain.model.parkingconfig.ParkingManagerConfig;
import com.thoughtworks.parkinglot.domain.model.parkingconfig.ParkingManagerConfigId;
import com.thoughtworks.parkinglot.domain.model.parkingconfig.ParkingManagerConfigRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author gitqh
 */
@Repository
@SuppressWarnings("checkstyle:magicnumber")
public class ParkingManagerConfigMemConfigRepository implements ParkingManagerConfigRepository {
    private ParkingManagerConfig defaultParkingManager;
    private List<ParkingManagerConfig> parkingManagerConfigs = Lists.newArrayList();

    {
        defaultParkingManager = ParkingManagerConfig.of(new ParkingManagerConfigId("MANAGER001"),
                "Ross",
                ImmutableList.of(
                        new ParkingBoyConfigId("BOY001"),
                        new ParkingBoyConfigId("BOY002")
                )
        );


        ParkingManagerConfig ted = ParkingManagerConfig.of(new ParkingManagerConfigId("MANAGER002"),
                "Ted",
                ImmutableList.of(
                        new ParkingBoyConfigId("BOY003"),
                        new ParkingBoyConfigId("BOY004")
                )
        );

        parkingManagerConfigs.add(defaultParkingManager);
        parkingManagerConfigs.add(ted);
    }

    @Override
    public ParkingManagerConfig findByName(final String parkingManagerName) {
        return parkingManagerConfigs.stream()
                .filter(manager -> parkingManagerName.equals(manager.getName()))
                .findFirst().orElseThrow(ParkingManagerNotFoundException::new);
    }

    @Override
    public ParkingManagerConfig findDefault() {
        return defaultParkingManager;
    }
}
