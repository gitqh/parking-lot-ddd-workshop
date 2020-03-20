package com.thoughtworks.parkinglot.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.parkinglot.domain.model.parkingconfig.ParkingManagerConfig;
import com.thoughtworks.parkinglot.domain.model.parkingconfig.ParkingManagerConfigId;
import com.thoughtworks.parkinglot.domain.model.parkingconfig.ParkingManagerConfigRepository;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ParkingManagerFactoryTest {

    @Mock
    private ParkingManagerConfigRepository parkingManagerConfigRepository;
    @Mock
    private ParkingBoyFactory parkingBoyFactory;
    private ParkingManagerFactory parkingManagerFactory;

    @Before
    public void setUp() {
        parkingManagerFactory = new ParkingManagerFactory(parkingManagerConfigRepository, parkingBoyFactory);
    }

    @Test
    public void should_return_default_manager_when_not_given_name() {
        final ParkingManagerConfig parkingManagerConfig = ParkingManagerConfig.of(
                new ParkingManagerConfigId("MANAGER001"),
                "Ross",
                ImmutableList.of()
        );
        given(parkingManagerConfigRepository.findDefault()).willReturn(parkingManagerConfig);
        final ParkingManager expectedManager = ParkingManager.of("Ross", ImmutableList.of());

        final ParkingManager actualManager = parkingManagerFactory.create((String[]) null);

        assertThat(actualManager).isEqualTo(expectedManager);
    }

    @Test
    public void should_return_expected_manager_when_given_name() {
        final ParkingManagerConfig parkingManagerConfig = ParkingManagerConfig.of(
                new ParkingManagerConfigId("MANAGER001"),
                "Ross",
                ImmutableList.of()
        );
        given(parkingManagerConfigRepository.findByName(any())).willReturn(parkingManagerConfig);
        final ParkingManager expectedManager = ParkingManager.of("Ross", ImmutableList.of());

        final ParkingManager actualManager = parkingManagerFactory.create("Ross");

        assertThat(actualManager).isEqualTo(expectedManager);
    }


}