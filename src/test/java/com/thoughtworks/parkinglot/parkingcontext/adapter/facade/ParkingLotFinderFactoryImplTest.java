package com.thoughtworks.parkinglot.parkingcontext.adapter.facade;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.parkinglot.common.config.SpringContextConfig;
import com.thoughtworks.parkinglot.configcontext.application.ParkingConfigApplicationService;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyId;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyName;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingManagerId;
import com.thoughtworks.parkinglot.parkingcontext.adapter.api.facade.ParkingLotFinderFactoryImpl;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingBoy;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLotRepository;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingManager;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingPolicy;
import com.thoughtworks.parkinglot.parkingcontext.domain.policy.JuniorParkingPolicy;
import com.thoughtworks.parkinglot.parkingcontext.domain.policy.ParkingPolicyFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SpringContextConfig.class)
public class ParkingLotFinderFactoryImplTest {
    @Mock
    private ParkingLotRepository parkingLotRepository;
    @Mock
    private ParkingConfigApplicationService parkingConfigApplicationService;
    @Mock
    private ParkingPolicyFactory parkingPolicyFactory;
    private com.thoughtworks.parkinglot.configcontext.domain.ParkingBoy parkingBoy;
    private ParkingLotFinderFactoryImpl parkingLotFinderFactoryImpl;

    @Before
    public void setUp() {
        parkingBoy = com.thoughtworks.parkinglot.configcontext.domain.ParkingBoy.of(
                new ParkingBoyId("BOY001"),
                ParkingBoyName.of("Allen"),
                ImmutableList.of(),
                "FirstPriority");
        parkingLotFinderFactoryImpl = ParkingLotFinderFactoryImpl.of(parkingConfigApplicationService,
                parkingLotRepository, parkingPolicyFactory);
        PowerMockito.mockStatic(SpringContextConfig.class);
    }

    @Test
    public void should_return_boy_by_name() {
        final ParkingPolicy parkingPolicy = JuniorParkingPolicy.of();
        given(parkingConfigApplicationService.findParkingBoy(any())).willReturn(parkingBoy);

        PowerMockito.when(SpringContextConfig.getBean(any())).thenReturn(parkingPolicy);
        final com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingBoy expectedParkingBoy =
                com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingBoy.of(
                "Allen",
                ImmutableList.of(),
                parkingPolicy
        );

        final com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingBoy parkingBoy =
                (ParkingBoy) parkingLotFinderFactoryImpl.newParkingBoy("BOY001");

        assertThat(parkingBoy).isEqualTo(expectedParkingBoy);
    }

    @Test
    public void should_return_boy_by_id() {
        final ParkingPolicy parkingPolicy = JuniorParkingPolicy.of();
        given(parkingConfigApplicationService.findParkingBoy(any())).willReturn(parkingBoy);
        PowerMockito.when(SpringContextConfig.getBean(any())).thenReturn(parkingPolicy);
        final com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingBoy expectedParkingBoy =
                com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingBoy.of(
                "Allen",
                ImmutableList.of(),
                parkingPolicy
        );

        final com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingBoy parkingBoy =
                (ParkingBoy) parkingLotFinderFactoryImpl.newParkingBoy("BOY001");

        assertThat(parkingBoy).isEqualTo(expectedParkingBoy);
    }

    @Test
    public void should_return_default_manager_when_not_given_name() {
        final com.thoughtworks.parkinglot.configcontext.domain.ParkingManager parkingManager =
                com.thoughtworks.parkinglot.configcontext.domain.ParkingManager.of(
                new ParkingManagerId("MANAGER001"),
                "Ross",
                ImmutableList.of()
        );
        given(parkingConfigApplicationService.findParkingManager()).willReturn(parkingManager);
        final com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingManager expectedManager = com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingManager.of("Ross", ImmutableList.of());

        final com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingManager actualManager = (ParkingManager) parkingLotFinderFactoryImpl.newParkingManager();

        assertThat(actualManager).isEqualTo(expectedManager);
    }

}