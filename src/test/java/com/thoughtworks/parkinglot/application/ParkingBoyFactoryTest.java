package com.thoughtworks.parkinglot.application;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.parkinglot.config.SpringContextConfig;
import com.thoughtworks.parkinglot.domain.model.parkingconfig.ParkingBoyConfig;
import com.thoughtworks.parkinglot.domain.model.parkingconfig.ParkingBoyId;
import com.thoughtworks.parkinglot.domain.model.parkingconfig.ParkingBoyConfigRepository;
import com.thoughtworks.parkinglot.domain.model.parkingconfig.ParkingStrategyName;
import com.thoughtworks.parkinglot.domain.model.strategy.JuniorParkingStrategy;
import com.thoughtworks.parkinglot.domain.model.finder.ParkingBoy;
import com.thoughtworks.parkinglot.domain.model.finder.ParkingLotRepository;
import com.thoughtworks.parkinglot.domain.model.finder.ParkingStrategy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SpringContextConfig.class)
public class ParkingBoyFactoryTest {
    @Mock
    private ParkingBoyConfigRepository parkingBoyConfigRepository;
    @Mock
    private ParkingLotRepository parkingLotRepository;
    private ParkingBoyConfig parkingBoyConfig;
    private ParkingBoyFactory parkingBoyFactory;

    @Before
    public void setUp() {
        parkingBoyConfig = ParkingBoyConfig.of(
                new ParkingBoyId("BOY001"),
                "Allen",
                ImmutableList.of(),
                ParkingStrategyName.of("NaturalParkingStrategy"));
        parkingBoyFactory = new ParkingBoyFactory(parkingBoyConfigRepository, parkingLotRepository);
        PowerMockito.mockStatic(SpringContextConfig.class);
    }

    @Test
    public void should_return_boy_by_name() {
        final ParkingStrategy parkingStrategy = JuniorParkingStrategy.of();
        given(parkingBoyConfigRepository.findByName(any())).willReturn(parkingBoyConfig);

        PowerMockito.when(SpringContextConfig.getBean(any())).thenReturn(parkingStrategy);
        final ParkingBoy expectedParkingBoy = ParkingBoy.of(
                "Allen",
                ImmutableList.of(),
                parkingStrategy
        );

        final ParkingBoy parkingBoy = parkingBoyFactory.create("Allen");

        assertThat(parkingBoy).isEqualTo(expectedParkingBoy);
    }

    @Test
    public void should_return_boy_by_id() {
        final ParkingStrategy parkingStrategy = JuniorParkingStrategy.of();
        given(parkingBoyConfigRepository.findById(any())).willReturn(parkingBoyConfig);
        PowerMockito.when(SpringContextConfig.getBean(any())).thenReturn(parkingStrategy);
        final ParkingBoy expectedParkingBoy = ParkingBoy.of(
                "Allen",
                ImmutableList.of(),
                parkingStrategy
        );

        final ParkingBoy parkingBoy = parkingBoyFactory.create(new ParkingBoyId("BOY001"));

        assertThat(parkingBoy).isEqualTo(expectedParkingBoy);
    }

}