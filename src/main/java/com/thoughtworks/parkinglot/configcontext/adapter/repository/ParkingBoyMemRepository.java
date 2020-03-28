package com.thoughtworks.parkinglot.configcontext.adapter.repository;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoy;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyId;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyName;
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
public class ParkingBoyMemRepository implements ParkingBoyRepository {

    private List<ParkingBoy> parkingBoys = Lists.newArrayList();

    {
        ParkingBoy allen = ParkingBoy.of(
                new ParkingBoyId("BOY001"),
                ParkingBoyName.of("Allen"),
                ImmutableList.of(new ParkingLotId("LOT001"), new ParkingLotId("LOT002")
                ),
                "FirstPriority"
        );

        ParkingBoy booker = ParkingBoy.of(
                new ParkingBoyId("BOY002"),
                ParkingBoyName.of("Booker"),
                ImmutableList.of(new ParkingLotId("LOT003"), new ParkingLotId("LOT004")
                ),
                "MaxSpacePriority"
        );

        ParkingBoy charles = ParkingBoy.of(
                new ParkingBoyId("BOY003"),
                ParkingBoyName.of("harles"),
                ImmutableList.of(new ParkingLotId("LOT005"), new ParkingLotId("LOT006")
                ),
                "FirstPriority"
        );

        ParkingBoy devin = ParkingBoy.of(
                new ParkingBoyId("BOY004"),
                ParkingBoyName.of("Devin"),
                ImmutableList.of(new ParkingLotId("LOT007"), new ParkingLotId("LOT008")
                ),
                "MaxSpacePriority"
        );

        parkingBoys.addAll(ImmutableList.of(allen, booker, charles, devin));
    }

    @Override
    public ParkingBoy findById(final String id) {
        return parkingBoys.stream()
                .filter(boy -> id.equals(boy.getId()))
                .findFirst()
                .orElseThrow(ParkingBoyNotFoundException::new);
    }
}
