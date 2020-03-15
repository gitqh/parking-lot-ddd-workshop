package com.thoughtworks.parkinglot.domain.model.parkingboy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.parkinglot.domain.model.parkinglot.MaxSpaceFirstParkingStrategy;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLot;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingStrategy;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;

public class MaxSpaceFirstParkingStrategyTest {
    private ParkingStrategy parkingStrategy;
    private ParkingLot parkingLot1;
    private ParkingLot parkingLot2;

    @Before
    public void setUp() {
        parkingLot1 = mock(ParkingLot.class);
        parkingLot2 = mock(ParkingLot.class);
        parkingStrategy = MaxSpaceFirstParkingStrategy.of();
    }

    @Test
    public void should_return_2nd_when_2nd_has_most_space() {
        given(parkingLot1.isAvailable()).willReturn(true);
        given(parkingLot1.getSpace()).willReturn(3);
        given(parkingLot2.isAvailable()).willReturn(true);
        given(parkingLot2.getSpace()).willReturn(5);

        Optional<ParkingLot> expectedParkingLot = parkingStrategy.find(ImmutableList.of(
                parkingLot1, parkingLot2));

        assertThat(expectedParkingLot).containsSame(parkingLot2);
    }

    @Test
    public void should_return_1st_parking_lot_when_2nd_is_not_available() {
        given(parkingLot1.isAvailable()).willReturn(true);
        given(parkingLot2.isAvailable()).willReturn(false);

        final Optional<ParkingLot> expectedParkingLot = parkingStrategy.find(
                ImmutableList.of(parkingLot1, parkingLot2));

        assertThat(expectedParkingLot).containsSame(parkingLot1);
    }

    @Test
    public void should_return_empty_when_no_parking_lots_available() {
        given(parkingLot1.isAvailable()).willReturn(false);
        given(parkingLot2.isAvailable()).willReturn(false);

        final Optional<ParkingLot> parkingLot = parkingStrategy.find(
                ImmutableList.of(parkingLot1, parkingLot2));

        assertThat(parkingLot).isEmpty();
    }
}