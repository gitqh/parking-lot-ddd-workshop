package com.thoughtworks.parkinglot.adapter.repository;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.thoughtworks.parkinglot.domain.exception.ParkingBoyNotFoundException;
import com.thoughtworks.parkinglot.domain.model.parkingconfig.ParkingBoyConfig;
import com.thoughtworks.parkinglot.domain.model.parkingconfig.ParkingBoyId;
import com.thoughtworks.parkinglot.domain.model.parkingconfig.ParkingBoyConfigRepository;
import com.thoughtworks.parkinglot.domain.model.parkingconfig.ParkingStrategyName;
import com.thoughtworks.parkinglot.domain.model.finder.ParkingLotId;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author gitqh
 */
@Repository
@SuppressWarnings("checkstyle:magicnumber")
public class ParkingBoyConfigMemRepository implements ParkingBoyConfigRepository {

    private List<ParkingBoyConfig> parkingBoyConfigs = Lists.newArrayList();

    {
        ParkingBoyConfig allen = ParkingBoyConfig.of(
                new ParkingBoyId("BOY001"),
                "Allen",
                ImmutableList.of(new ParkingLotId("LOT001"), new ParkingLotId("LOT002")
                ),
                ParkingStrategyName.of("NaturalParkingStrategy")
        );

        ParkingBoyConfig booker = ParkingBoyConfig.of(
                new ParkingBoyId("BOY002"),
                "Booker",
                ImmutableList.of(new ParkingLotId("LOT003"), new ParkingLotId("LOT004")
                ),
                ParkingStrategyName.of("MaxSpaceFirstParkingStrategy")
        );

        ParkingBoyConfig charles = ParkingBoyConfig.of(
                new ParkingBoyId("BOY003"),
                "harles",
                ImmutableList.of(new ParkingLotId("LOT005"), new ParkingLotId("LOT006")
                ),
                ParkingStrategyName.of("NaturalParkingStrategy")
        );

        ParkingBoyConfig devin = ParkingBoyConfig.of(
                new ParkingBoyId("BOY004"),
                "Devin",
                ImmutableList.of(new ParkingLotId("LOT007"), new ParkingLotId("LOT008")
                ),
                ParkingStrategyName.of("MaxSpaceFirstParkingStrategy")
        );

        parkingBoyConfigs.addAll(ImmutableList.of(allen, booker, charles, devin));
    }

    @Override
    public ParkingBoyConfig findByName(final String name) {
        return parkingBoyConfigs.stream()
                .filter(boy -> name.equals(boy.getName()))
                .findFirst()
                .orElseThrow(ParkingBoyNotFoundException::new);
    }

    @Override
    public ParkingBoyConfig findById(final String id) {
        return parkingBoyConfigs.stream()
                .filter(boy -> id.equals(boy.getId()))
                .findFirst()
                .orElseThrow(ParkingBoyNotFoundException::new);
    }
}
