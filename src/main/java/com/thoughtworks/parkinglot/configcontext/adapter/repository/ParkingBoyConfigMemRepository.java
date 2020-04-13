package com.thoughtworks.parkinglot.configcontext.adapter.repository;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyConfig;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyConfigId;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyConfigName;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyRepository;
import com.thoughtworks.parkinglot.configcontext.domain.exception.ParkingBoyNotFoundException;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLotId;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author gitqh
 */
@Repository
@SuppressWarnings("checkstyle:magicnumber")
public class ParkingBoyConfigMemRepository implements ParkingBoyRepository {

    private List<ParkingBoyConfig> parkingBoys = Lists.newArrayList();

    {
        ParkingBoyConfig allen = ParkingBoyConfig.of(
                new ParkingBoyConfigId("BOY001"),
                ParkingBoyConfigName.of("Allen"),
                ImmutableList.of(new ParkingLotId("LOT001"), new ParkingLotId("LOT002")
                ),
                "FIRST_PRIORITY"
        );

        ParkingBoyConfig booker = ParkingBoyConfig.of(
                new ParkingBoyConfigId("BOY002"),
                ParkingBoyConfigName.of("Booker"),
                ImmutableList.of(new ParkingLotId("LOT003"), new ParkingLotId("LOT004")
                ),
                "MAX_SPACE_PRIORITY"
        );

        ParkingBoyConfig charles = ParkingBoyConfig.of(
                new ParkingBoyConfigId("BOY003"),
                ParkingBoyConfigName.of("harles"),
                ImmutableList.of(new ParkingLotId("LOT005"), new ParkingLotId("LOT006")
                ),
                "FIRST_PRIORITY"
        );

        ParkingBoyConfig devin = ParkingBoyConfig.of(
                new ParkingBoyConfigId("BOY004"),
                ParkingBoyConfigName.of("Devin"),
                ImmutableList.of(new ParkingLotId("LOT007"), new ParkingLotId("LOT008")
                ),
                "MAX_SPACE_PRIORITY"
        );

        parkingBoys.addAll(ImmutableList.of(allen, booker, charles, devin));
    }

    @Override
    public ParkingBoyConfig findById(final String id) {
        return parkingBoys.stream()
                .filter(boy -> id.equals(boy.getId()))
                .findFirst()
                .orElseThrow(ParkingBoyNotFoundException::new);
    }
}
