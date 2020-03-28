package com.thoughtworks.parkinglot.configcontext.adapter.repository;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyId;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingManager;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingManagerId;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingManagerRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author gitqh
 */
@Repository
@SuppressWarnings("checkstyle:magicnumber")
public class ParkingManagerConfigMemRepository implements ParkingManagerRepository {
    private ParkingManager defaultParkingManager;
    private List<ParkingManager> parkingManagers = Lists.newArrayList();

    {
        defaultParkingManager = ParkingManager.of(new ParkingManagerId("MANAGER001"),
                "Ross",
                ImmutableList.of(
                        new ParkingBoyId("BOY001"),
                        new ParkingBoyId("BOY002")
                )
        );

        parkingManagers.add(defaultParkingManager);
    }

    @Override
    public ParkingManager findDefault() {
        return defaultParkingManager;
    }
}
