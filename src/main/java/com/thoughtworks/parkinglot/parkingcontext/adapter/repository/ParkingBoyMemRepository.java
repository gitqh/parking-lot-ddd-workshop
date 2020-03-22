package com.thoughtworks.parkinglot.parkingcontext.adapter.repository;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.thoughtworks.parkinglot.parkingcontext.domain.exception.ParkingBoyNotFoundException;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoy;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyId;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyRepository;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingPolicyName;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLotId;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author gitqh
 */
@Repository
@SuppressWarnings("checkstyle:magicnumber")
public class ParkingBoyMemRepository implements ParkingBoyRepository {

    private List<ParkingBoy> parkingBoys = Lists.newArrayList();

    {
        ParkingBoy allen = ParkingBoy.of(
                new ParkingBoyId("BOY001"),
                "Allen",
                ImmutableList.of(new ParkingLotId("LOT001"), new ParkingLotId("LOT002")
                ),
                ParkingPolicyName.of("NaturalParkingStrategy")
        );

        ParkingBoy booker = ParkingBoy.of(
                new ParkingBoyId("BOY002"),
                "Booker",
                ImmutableList.of(new ParkingLotId("LOT003"), new ParkingLotId("LOT004")
                ),
                ParkingPolicyName.of("MaxSpaceFirstParkingStrategy")
        );

        ParkingBoy charles = ParkingBoy.of(
                new ParkingBoyId("BOY003"),
                "harles",
                ImmutableList.of(new ParkingLotId("LOT005"), new ParkingLotId("LOT006")
                ),
                ParkingPolicyName.of("NaturalParkingStrategy")
        );

        ParkingBoy devin = ParkingBoy.of(
                new ParkingBoyId("BOY004"),
                "Devin",
                ImmutableList.of(new ParkingLotId("LOT007"), new ParkingLotId("LOT008")
                ),
                ParkingPolicyName.of("MaxSpaceFirstParkingStrategy")
        );

        parkingBoys.addAll(ImmutableList.of(allen, booker, charles, devin));
    }

    @Override
    public ParkingBoy findByName(final String name) {
        return parkingBoys.stream()
                .filter(boy -> name.equals(boy.getName()))
                .findFirst()
                .orElseThrow(ParkingBoyNotFoundException::new);
    }

    @Override
    public ParkingBoy findById(final String id) {
        return parkingBoys.stream()
                .filter(boy -> id.equals(boy.getId()))
                .findFirst()
                .orElseThrow(ParkingBoyNotFoundException::new);
    }
}
