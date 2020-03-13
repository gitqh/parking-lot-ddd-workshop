package com.thoughtworks.parkinglot.domain.model.parkingboy;


import static org.assertj.core.api.Assertions.assertThat;

import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotId;
import java.util.List;
import org.junit.Test;
import org.mockito.Mock;

public class ParkingBoyFactoryTest {

	@Mock
	private List<ParkingLotId> parkingLotIds;

	@Test
	public void should_return_boy_with_general_parking_strategy() {
		final ParkingBoy parkingBoy = ParkingBoyFactory.createParkingBoy(parkingLotIds,
				ParkingStrategyEnum.GENERAL);
		final ParkingStrategy expectedStrategy = NaturalParkingStrategy.of();

		assertThat(expectedStrategy).isEqualTo(parkingBoy.getParkingStrategy());
	}

	@Test
	public void should_return_boy_with_max_space_parking_strategy() {
		final ParkingBoy parkingBoy = ParkingBoyFactory.createParkingBoy(parkingLotIds,
				ParkingStrategyEnum.MAX_SPACE);
		final ParkingStrategy expectedStrategy = MaxSpaceFirstParkingStrategy.of();

		assertThat(expectedStrategy).isEqualTo(parkingBoy.getParkingStrategy());
	}

}