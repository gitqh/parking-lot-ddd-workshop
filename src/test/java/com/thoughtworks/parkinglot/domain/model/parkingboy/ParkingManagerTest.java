package com.thoughtworks.parkinglot.domain.model.parkingboy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.parkinglot.domain.model.parkinglot.NaturalParkingStrategy;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingBoy;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLot;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotId;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ParkingManagerTest {
    @Mock
    private ParkingBoy boy1;
    @Mock
    private ParkingBoy boy2;
    @Mock
    private ParkingLot parkingLot;
    private ParkingManager parkingManager;

    @Before
    public void setUp() {
        parkingManager = ParkingManager.of("", Arrays.asList(boy1, boy2));
    }

    @Test
    public void should_list_all_parking_lot_ids() {
        List<ParkingBoy> parkingBoys = ImmutableList.of(
                ParkingBoy.of("Allen",
                        ImmutableList.of(ParkingLot.of(new ParkingLotId("LOT001"), 1, Collections.emptyMap())),
                    NaturalParkingStrategy.of()),
        ParkingBoy.of("Booker",
                ImmutableList.of(ParkingLot.of(new ParkingLotId("LOT002"), 1, Collections.emptyMap())),
                NaturalParkingStrategy.of())
        );
        List<ParkingLotId> expectedIds = Arrays.asList(new ParkingLotId("LOT001"), new ParkingLotId("LOT002"));
        ParkingManager parkingManager = ParkingManager.of("", parkingBoys);

        List<ParkingLotId> actualIds = parkingManager.listParkingLotIds();

        assertThat(actualIds.size()).isEqualTo(expectedIds.size());
    }

    @Test
    public void should_return_parking_lot_from_1st_boy_when_returned_1st_boy() {
        given(boy1.find()).willReturn(Optional.of(parkingLot));

        final Optional<ParkingLot> expectedParkingLot = parkingManager.findParkingLot();

        assertThat(expectedParkingLot).containsSame(parkingLot);
    }

    @Test
    public void should_return_parking_lot_from_2nd_boy_when_not_returned_1st_boy() {
        given(boy1.find()).willReturn(Optional.empty());
        given(boy2.find()).willReturn(Optional.of(parkingLot));

        final Optional<ParkingLot> expectedParkingLot = parkingManager.findParkingLot();

        assertThat(expectedParkingLot).containsSame(parkingLot);
    }
}