package com.thoughtworks.parkinglot.application;

import com.thoughtworks.parkinglot.domain.exception.IllegalTicketException;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingBoy;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLot;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotId;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotRepository;
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
    private ParkingBoyFactory parkingBoyFactory;
    @Mock
    private ParkingManagerFactory parkingManagerFactory;
    @Mock
    private ParkingLot parkingLot;
    @Mock
    private ParkingBoy parkingBoy;

    private ParkingLotId parkingLotId;

    @Before
    public void setUp() {
        parkingLotId = new ParkingLotId("LOT001");
    }

    @Test
    public void should_return_ticket_by_parking_boy() {
//        final Ticket expectedTicket = mock(Ticket.class);
//        given(parkingBoyFactory.findParkingBoyByName(any())).willReturn(parkingBoy);
//        given(parkingLot.park(any())).willReturn(expectedTicket);
//
//        ParkingLotApplicationService parkingLotApplicationService =
//                new ParkingLotApplicationService(parkingLotRepository, parkingBoyFactory, parkingManagerFactory);
//        final Ticket ticket = parkingLotApplicationService.parkByParkingBoy("Allen", "川A45678");
//
//        assertThat(ticket).isEqualTo(expectedTicket);
    }

    @Test
    public void should_return_the_parked_car() {
//        String carLicensePlate = "川A45678";
//        final Car expectedCar = Car.of(carLicensePlate);
//        final ParkingLot parkingLot = mock(ParkingLot.class);
//        given(parkingLot.pick(carLicensePlate)).willReturn(expectedCar);
//        given(parkingLotRepository.findById(parkingLotId)).willReturn(Optional.of(parkingLot));
//
//        ParkingLotApplicationService parkingLotApplicationService =
//                new ParkingLotApplicationService(parkingLotRepository, parkingBoyFactory, parkingManagerFactory);
//        final Car car = parkingLotApplicationService.pick(carLicensePlate, parkingLotId);
//
//        assertThat(car).isEqualTo(expectedCar);
    }

    @Test(expected = IllegalTicketException.class)
    public void should_fail_when_ticket_is_invalid() {
        ParkingLotApplicationService parkingLotApplicationService =
                new ParkingLotApplicationService(parkingLotRepository, parkingBoyFactory, parkingManagerFactory);

        parkingLotApplicationService.pick("invalid-ticket-id", parkingLotId);
    }
}