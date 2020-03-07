package com.thoughtworks.parkinglot.domain.model.parkingboy;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingBoyId;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotId;
import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class ParkingBoyTest {
    @Mock
    private ParkingBoyId parkingBoyId;
    @Mock
    private List<ParkingLotId> parkingLotIds;
    @Mock
    private ParkingStrategy parkingStrategy;

    @Test
    public void should_find_parking_lot_use_parkingStrategy() {
        ParkingBoy parkingBoy = ParkingBoy.of(parkingBoyId, parkingLotIds, parkingStrategy);
        parkingBoy.find(Lists.newArrayList());

        verify(parkingStrategy).find(any());

    }
}