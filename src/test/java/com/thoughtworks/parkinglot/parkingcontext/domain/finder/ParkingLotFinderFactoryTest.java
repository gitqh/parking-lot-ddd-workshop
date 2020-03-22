package com.thoughtworks.parkinglot.parkingcontext.domain.finder;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.parkinglot.config.SpringContextConfig;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyId;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingBoyRepository;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingManagerId;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingManagerRepository;
import com.thoughtworks.parkinglot.configcontext.domain.ParkingPolicyName;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.ParkingLotFinderFactory;
import com.thoughtworks.parkinglot.parkingcontext.domain.policy.JuniorParkingPolicy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SpringContextConfig.class)
public class ParkingLotFinderFactoryTest {
    @Mock
    private ParkingBoyRepository parkingBoyRepository;
    @Mock
    private ParkingManagerRepository parkingManagerRepository;
    @Mock
    private ParkingLotRepository parkingLotRepository;
    private com.thoughtworks.parkinglot.configcontext.domain.ParkingBoy parkingBoy;
    private ParkingLotFinderFactory parkingLotFinderFactory;

    @Before
    public void setUp() {
        parkingBoy = com.thoughtworks.parkinglot.configcontext.domain.ParkingBoy.of(
                new ParkingBoyId("BOY001"),
                "Allen",
                ImmutableList.of(),
                ParkingPolicyName.of("NaturalParkingStrategy"));
        parkingLotFinderFactory = new ParkingLotFinderFactory(
                parkingBoyRepository, parkingManagerRepository, parkingLotRepository);
        PowerMockito.mockStatic(SpringContextConfig.class);
    }

    @Test
    public void should_return_boy_by_name() {
        final ParkingPolicy parkingPolicy = JuniorParkingPolicy.of();
        given(parkingBoyRepository.findById(any())).willReturn(parkingBoy);

        PowerMockito.when(SpringContextConfig.getBean(any())).thenReturn(parkingPolicy);
        final com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingBoy expectedParkingBoy =
                com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingBoy.of(
                "Allen",
                ImmutableList.of(),
                parkingPolicy
        );

        final com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingBoy parkingBoy =
                (ParkingBoy) parkingLotFinderFactory.newParkingBoy(new ParkingBoyId("BOY001"));

        assertThat(parkingBoy).isEqualTo(expectedParkingBoy);
    }

    @Test
    public void should_return_boy_by_id() {
        final ParkingPolicy parkingPolicy = JuniorParkingPolicy.of();
        given(parkingBoyRepository.findById(any())).willReturn(parkingBoy);
        PowerMockito.when(SpringContextConfig.getBean(any())).thenReturn(parkingPolicy);
        final com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingBoy expectedParkingBoy =
                com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingBoy.of(
                "Allen",
                ImmutableList.of(),
                parkingPolicy
        );

        final com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingBoy parkingBoy =
                (ParkingBoy) parkingLotFinderFactory.newParkingBoy(new ParkingBoyId("BOY001"));

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
        given(parkingManagerRepository.findDefault()).willReturn(parkingManager);
        final com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingManager expectedManager = com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingManager.of("Ross", ImmutableList.of());

        final com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingManager actualManager = (ParkingManager) parkingLotFinderFactory.newParkingManager();

        assertThat(actualManager).isEqualTo(expectedManager);
    }

}