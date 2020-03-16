package com.thoughtworks.parkinglot.domain.model.parkingboy;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingBoy;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingStrategy;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ParkingBoyTest {

    @Mock
    private ParkingStrategy parkingStrategy;

    @Test
    public void should_find_parking_lot_use_parking_strategy() {
        ParkingBoy parkingBoy = ParkingBoy.of("Allen", Lists.newArrayList(), parkingStrategy);
        parkingBoy.find();

        verify(parkingStrategy).find(any());
    }
}