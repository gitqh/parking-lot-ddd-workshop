package com.thoughtworks.parkinglot.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import com.thoughtworks.parkinglot.domain.exception.IllegalTicketException;
import com.thoughtworks.parkinglot.domain.model.parkinglot.Car;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLot;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotId;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotRepository;
import com.thoughtworks.parkinglot.domain.model.parkinglot.Ticket;
import com.thoughtworks.parkinglot.domain.service.ParkingManager;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ParkingLotApplicationServiceTest {
    @Mock
    private ParkingLotRepository parkingLotRepository;
    @Mock
    private ParkingLot parkingLot;
    @Mock
    private ParkingManager parkingManager;

    private ParkingLotId parkingLotId;

    @Before
    public void setUp() {
        parkingLotId = new ParkingLotId("LOT001");
    }

    @Test
    public void should_return_ticket() {
        final Ticket expectedTicket = mock(Ticket.class);
        given(parkingManager.find()).willReturn(Optional.of(parkingLot));
        given(parkingLot.park(any())).willReturn(expectedTicket);

        ParkingLotApplicationService parkingLotApplicationService =
                new ParkingLotApplicationService(parkingManager, parkingLotRepository);
        final Ticket ticket = parkingLotApplicationService.park("川A45678");

        assertThat(ticket).isEqualTo(expectedTicket);
    }

    @Test
    public void should_return_the_parked_car() {
        String carLicensePlate = "川A45678";
        final Car expectedCar = Car.of(carLicensePlate);
        final ParkingLot parkingLot = mock(ParkingLot.class);
        given(parkingLot.pick(carLicensePlate)).willReturn(expectedCar);
        given(parkingLotRepository.findById(parkingLotId)).willReturn(Optional.of(parkingLot));

        ParkingLotApplicationService parkingLotApplicationService =
                new ParkingLotApplicationService(parkingManager, parkingLotRepository);
        final Car car = parkingLotApplicationService.pick(carLicensePlate, parkingLotId);

        assertThat(car).isEqualTo(expectedCar);
    }

    @Test(expected = IllegalTicketException.class)
    public void should_fail_when_ticket_is_invalid() {
        ParkingLotApplicationService parkingLotApplicationService =
                new ParkingLotApplicationService(parkingManager, parkingLotRepository);

        parkingLotApplicationService.pick("invalid-ticket-id", parkingLotId);
    }
}