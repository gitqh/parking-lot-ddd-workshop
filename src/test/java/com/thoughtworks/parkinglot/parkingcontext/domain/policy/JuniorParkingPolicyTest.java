package com.thoughtworks.parkinglot.parkingcontext.domain.policy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLot;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingPolicy;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;

public class JuniorParkingPolicyTest {
    private ParkingPolicy parkingPolicy;
    private ParkingLot parkingLot1;
    private ParkingLot parkingLot2;

    @Before
    public void setUp() {
        parkingLot1 = mock(ParkingLot.class);
        parkingLot2 = mock(ParkingLot.class);
        parkingPolicy = JuniorParkingPolicy.of();
    }

    @Test
    public void should_return_1st_parking_lot_when_1st_is_available() {
        given(parkingLot1.isAvailable()).willReturn(true);

        final Optional<ParkingLot> expectedParkingLot = parkingPolicy.findParkingLotToPark(
                ImmutableList.of(parkingLot1, parkingLot2));

        assertThat(expectedParkingLot).containsSame(parkingLot1);
    }

    @Test
    public void should_return_2nd_parking_lot_when_1st_is_not_available() {
        given(parkingLot1.isAvailable()).willReturn(false);
        given(parkingLot2.isAvailable()).willReturn(true);

        final Optional<ParkingLot> expectedParkingLot = parkingPolicy.findParkingLotToPark(
                ImmutableList.of(parkingLot1, parkingLot2));

        assertThat(expectedParkingLot).containsSame(parkingLot2);
    }

    @Test
    public void should_return_empty_when_no_parking_lots_available() {
        given(parkingLot1.isAvailable()).willReturn(false);
        given(parkingLot2.isAvailable()).willReturn(false);

        final Optional<ParkingLot> parkingLot = parkingPolicy.findParkingLotToPark(
                ImmutableList.of(parkingLot1, parkingLot2));

        assertThat(parkingLot).isEmpty();
    }
}