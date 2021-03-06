package com.thoughtworks.parkinglot.parkingcontext.domain.finder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.parkinglot.parkingcontext.domain.policy.JuniorParkingPolicy;
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
public class ParkingManagerConfigTest {
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
        final List<ParkingBoy> parkingBoys = ImmutableList.of(
                ParkingBoy.of("Allen",
                        ImmutableList.of(ParkingLot.of(new ParkingLotId("LOT001"), 1, Collections.emptyMap())),
                    JuniorParkingPolicy.of()),
        ParkingBoy.of("Booker",
                ImmutableList.of(ParkingLot.of(new ParkingLotId("LOT002"), 1, Collections.emptyMap())),
                JuniorParkingPolicy.of())
        );
        final List<ParkingLotId> expectedIds = Arrays.asList(new ParkingLotId("LOT001"), new ParkingLotId("LOT002"));
        final ParkingManager parkingManager = ParkingManager.of("", parkingBoys);

        final List<ParkingLotId> actualIds = parkingManager.listParkingLotIds();

        assertThat(actualIds.size()).isEqualTo(expectedIds.size());
    }

    @Test
    public void should_return_parking_lot_from_1st_boy_when_returned_1st_boy() {
        given(boy1.findParkingLot()).willReturn(Optional.of(parkingLot));

        final Optional<ParkingLot> expectedParkingLot = parkingManager.findParkingLot();

        assertThat(expectedParkingLot).containsSame(parkingLot);
    }

    @Test
    public void should_return_parking_lot_from_2nd_boy_when_not_returned_1st_boy() {
        given(boy1.findParkingLot()).willReturn(Optional.empty());
        given(boy2.findParkingLot()).willReturn(Optional.of(parkingLot));

        final Optional<ParkingLot> expectedParkingLot = parkingManager.findParkingLot();

        assertThat(expectedParkingLot).containsSame(parkingLot);
    }
}