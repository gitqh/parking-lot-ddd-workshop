package com.thoughtworks.parkinglot.parkingcontext.domain.finder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ParkingBoyTest {

    @Mock
    private ParkingPolicy parkingPolicy;

    @Test
    public void should_find_parking_lot_use_parking_strategy() {
        final ParkingBoy parkingBoy = ParkingBoy.of("Allen", Lists.newArrayList(), parkingPolicy);
        parkingBoy.findParkingLot();

        verify(parkingPolicy).findParkingLotToPark(any());
    }
}