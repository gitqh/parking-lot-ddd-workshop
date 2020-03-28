package com.thoughtworks.parkinglot.configcontext.adapter.repository;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyConfigId;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingManagerConfig;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingManagerConfigId;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingManagerRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author gitqh
 */
@Repository
@SuppressWarnings("checkstyle:magicnumber")
public class ParkingManagerConfigMemRepository implements ParkingManagerRepository {
    private ParkingManagerConfig defaultParkingManagerConfig;
    private List<ParkingManagerConfig> parkingManagerConfigs = Lists.newArrayList();

    {
        defaultParkingManagerConfig = ParkingManagerConfig.of(new ParkingManagerConfigId("MANAGER001"),
                "Ross",
                ImmutableList.of(
                        new ParkingBoyConfigId("BOY001"),
                        new ParkingBoyConfigId("BOY002")
                )
        );

        parkingManagerConfigs.add(defaultParkingManagerConfig);
    }

    @Override
    public ParkingManagerConfig findDefault() {
        return defaultParkingManagerConfig;
    }
}
