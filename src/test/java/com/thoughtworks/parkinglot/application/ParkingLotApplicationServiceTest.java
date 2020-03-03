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
import com.thoughtworks.parkinglot.domain.model.parkinglot.TicketId;
import com.thoughtworks.parkinglot.domain.service.ParkingService;
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
    private ParkingService parkingService;

    private ParkingLotId parkingLotId;

    @Before
    public void setUp() {
        parkingLotId = new ParkingLotId("LOT001");
    }

    @Test
    public void should_return_ticket() {
        final Ticket expectedTicket = mock(Ticket.class);
        given(parkingService.find()).willReturn(Optional.of(parkingLot));
        given(parkingLot.park(any())).willReturn(expectedTicket);

        ParkingLotApplicationService parkingLotApplicationService =
                new ParkingLotApplicationService(parkingService, parkingLotRepository);
        final Ticket ticket = parkingLotApplicationService.park("川A45678");

        assertThat(ticket).isEqualTo(expectedTicket);
    }

    @Test
    public void should_return_the_parked_car() {
        String carLicensePlate = "川A45678";
        TicketId ticketId = TicketId.newTicketId();
        final Ticket ticket = new Ticket(ticketId, carLicensePlate, parkingLotId);
        final Car expectedCar = new Car(carLicensePlate);
        final ParkingLot parkingLot = mock(ParkingLot.class);
        given(parkingLot.pick(ticket.getId())).willReturn(expectedCar);
        given(parkingLotRepository.findById(parkingLotId)).willReturn(Optional.of(parkingLot));

        ParkingLotApplicationService parkingLotApplicationService =
                new ParkingLotApplicationService(parkingService, parkingLotRepository);
        final Car car = parkingLotApplicationService.pick(ticketId, parkingLotId);

        assertThat(car).isEqualTo(expectedCar);
    }

    @Test(expected = IllegalTicketException.class)
    public void should_fail_when_ticket_is_invalid() {
        TicketId ticketId = new TicketId("invalid-ticket-id");

        ParkingLotApplicationService parkingLotApplicationService =
                new ParkingLotApplicationService(parkingService, parkingLotRepository);

        parkingLotApplicationService.pick(ticketId, parkingLotId);
    }
}