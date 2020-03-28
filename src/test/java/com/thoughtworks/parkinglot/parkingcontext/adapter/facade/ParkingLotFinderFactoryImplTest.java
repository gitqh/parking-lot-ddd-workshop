package com.thoughtworks.parkinglot.parkingcontext.adapter.facade;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.parkinglot.configcontext.application.ParkingConfigApplicationService;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyConfig;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyConfigId;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyConfigName;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingManagerConfig;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingManagerConfigId;
import com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.ParkingLotFinderFactoryImpl;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingBoy;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLotRepository;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingManager;
import com.thoughtworks.parkinglot.parkingcontext.domain.policy.ParkingPolicyFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ParkingLotFinderFactoryImplTest {
    @Mock
    private ParkingLotRepository parkingLotRepository;
    @Mock
    private ParkingConfigApplicationService parkingConfigApplicationService;
    @Mock
    private ParkingPolicyFactory parkingPolicyFactory;
    private ParkingLotFinderFactoryImpl parkingLotFinderFactoryImpl;

    @Before
    public void setUp() {

        parkingLotFinderFactoryImpl = ParkingLotFinderFactoryImpl.of(parkingConfigApplicationService,
                parkingLotRepository, parkingPolicyFactory);
    }

    @Test
    public void should_return_boy() {
        var parkingBoyConfig = ParkingBoyConfig.of(
                new ParkingBoyConfigId("BOY001"),
                ParkingBoyConfigName.of("Allen"),
                ImmutableList.of(),
                "FIRST_PRIORITY");
        given(parkingConfigApplicationService.findParkingBoy(any())).willReturn(parkingBoyConfig);

        final ParkingBoy actualBoy =
                (ParkingBoy) parkingLotFinderFactoryImpl.newParkingBoy("BOY001");

        assertThat(actualBoy).isNotNull();
    }

    @Test
    public void should_return_manager() {
        final ParkingManagerConfig parkingManagerConfig =
                ParkingManagerConfig.of(
                new ParkingManagerConfigId("MANAGER001"),
                "Ross",
                ImmutableList.of()
        );
        given(parkingConfigApplicationService.findParkingManager()).willReturn(parkingManagerConfig);
        final ParkingManager actualManager = (ParkingManager) parkingLotFinderFactoryImpl.newParkingManager();

        assertThat(actualManager).isNotNull();
    }

}