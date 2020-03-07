package com.thoughtworks.parkinglot.domain.service;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.parkinglot.domain.model.parkingboy.ParkingBoy;
import com.thoughtworks.parkinglot.domain.model.parkingboy.ParkingBoyRepository;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLot;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotId;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotRepository;
import java.util.Arrays;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ParkingManagerTest {
    @Mock
    private ParkingLotRepository parkingLotRepository;
    @Mock
    private ParkingBoyRepository parkingBoyRepository;
    @Mock
    private ParkingLot parkingLot;
    @Mock
    private ParkingBoy boy1;
    @Mock
    private ParkingBoy boy2;
    private ParkingLotId parkingLotId;

    @Before
    public void setUp() {
        parkingLotId = new ParkingLotId("LOT001");
    }

    @Test
    public void should_return_1st_boy_when_returned_1st_boy() {
        given(parkingBoyRepository.findAll()).willReturn(singletonList(boy1));
        given(boy1.getParkingLotIds()).willReturn(singletonList(parkingLotId));
        given(parkingLotRepository.findById(parkingLotId)).willReturn(Optional.of(parkingLot));
        given(boy1.find(ImmutableList.of(parkingLot))).willReturn(Optional.of(parkingLot));
        final ParkingManager parkingManager = new ParkingManager(parkingLotRepository, parkingBoyRepository);

        final Optional<ParkingLot> result = parkingManager.find();

        assertThat(result).containsSame(parkingLot);
    }

    @Test
    public void should_return_2nd_boy_when_not_returned_1st_boy() {
        given(parkingBoyRepository.findAll()).willReturn(Arrays.asList(boy1, boy2));
        given(boy1.find(any())).willReturn(Optional.empty());

        given(boy2.getParkingLotIds()).willReturn(singletonList(parkingLotId));
        given(parkingLotRepository.findById(parkingLotId)).willReturn(Optional.of(parkingLot));
        given(boy2.find(ImmutableList.of(parkingLot))).willReturn(Optional.of(parkingLot));

        final ParkingManager parkingManager = new ParkingManager(parkingLotRepository, parkingBoyRepository);

        final Optional<ParkingLot> result = parkingManager.find();

        assertThat(result).containsSame(parkingLot);
    }
}