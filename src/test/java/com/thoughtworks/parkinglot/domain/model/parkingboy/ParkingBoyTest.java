package com.thoughtworks.parkinglot.domain.model.parkingboy;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingBoyId;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLot;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotId;
import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ParkingBoyTest {
    @Mock
    private GeneralParkingStrategy parkingStrategy;
    @Mock
    private ParkingBoyId parkingBoyId;

    private List<ParkingLotId> parkingLotIds = Lists.newArrayList();

    @Test
    public void should_find_parking_lot_use_parkingStrategy() {
        List<ParkingLot> parkingLots = Lists.newArrayList();
        ParkingBoy parkingBoy = new ParkingBoy(parkingBoyId, parkingStrategy, parkingLotIds);

        parkingBoy.find(Lists.newArrayList());

        verify(parkingStrategy).find(parkingLots);
    }

}