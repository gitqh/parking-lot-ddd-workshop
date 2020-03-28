package com.thoughtworks.parkinglot.parkingcontext.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.thoughtworks.parkinglot.parkingcontext.domain.exception.IllegalTicketException;
import com.thoughtworks.parkinglot.parkingcontext.domain.exception.NoEnoughCapacityException;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLot;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLotId;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingLotRepository;
import com.thoughtworks.parkinglot.parkingcontext.domain.finder.ParkingManager;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.Car;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.FinderParkingLotService;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.ParkingLotFinderFactory;
import com.thoughtworks.parkinglot.parkingcontext.domain.parking.Ticket;
import java.util.List;
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
    private ParkingLotFinderFactory parkingLotFinderFactory;
    @Mock
    private ParkingLot parkingLot;
    @Mock
    private ParkingManager parkingManager;
    @Mock
    private List<ParkingLotId> parkingLotIds;
    @Mock
    private FinderParkingLotService finderParkingLotService;

    private ParkingLotId parkingLotId;

    private ParkingLotApplicationService parkingLotApplicationService;

    @Before
    public void setUp() {
        parkingLotId = new ParkingLotId("LOT001");
        parkingLotApplicationService = new ParkingLotApplicationService(parkingLotFinderFactory,
                parkingLotRepository,
                finderParkingLotService
        );
    }

    @Test
    public void should_return_ticket_by_parking_boy() {
        final String licensePlate = "川A23456";
        final String parkingBoyId = "BOY001";
        final Ticket expectedTicket = Ticket.of(licensePlate, parkingLotId);
        given(finderParkingLotService.findParkingLot(any(), any())).willReturn(Optional.of(parkingLot));
        given(parkingLot.park(Car.of(licensePlate))).willReturn(expectedTicket);

        Ticket actualTicket = parkingLotApplicationService.parkByParkingBoy(parkingBoyId, licensePlate);

        assertThat(actualTicket).isEqualTo(expectedTicket);
    }

    @Test(expected = NoEnoughCapacityException.class)
    public void should_fail_when_all_parking_lot_belong_to_boy_is_full() {
        final String licensePlate = "川A23456";
        final String parkingBoyId = "BOY001";
        given(finderParkingLotService.findParkingLot(any(), any())).willReturn(Optional.empty());

        parkingLotApplicationService.parkByParkingBoy(parkingBoyId, licensePlate);
    }

    @Test
    public void should_return_ticket_by_parking_manager() {
        final String licensePlate = "川A23456";
        final Ticket expectedTicket = Ticket.of(licensePlate, parkingLotId);
        given(finderParkingLotService.findParkingLot(any(), any())).willReturn(Optional.of(parkingLot));
        given(parkingLot.park(Car.of(licensePlate))).willReturn(expectedTicket);

        Ticket actualTicket = parkingLotApplicationService.parkByParkingManager(licensePlate);

        assertThat(actualTicket).isEqualTo(expectedTicket);
    }

    @Test(expected = NoEnoughCapacityException.class)
    public void should_fail_when_all_parking_lot_belong_to_manager_is_full() {
        final String licensePlate = "川A23456";
        given(finderParkingLotService.findParkingLot(any(), any())).willReturn(Optional.empty());

        parkingLotApplicationService.parkByParkingManager(licensePlate);
    }

    @Test
    public void should_return_the_parked_car() {
        final String carLicensePlate = "川A45678";
        final Car expectedCar = Car.of(carLicensePlate);
        given(parkingLot.pick(carLicensePlate)).willReturn(expectedCar);
        given(parkingLotRepository.findById(parkingLotId)).willReturn(Optional.of(parkingLot));

        final Car car = parkingLotApplicationService.pick(carLicensePlate, parkingLotId);

        assertThat(car).isEqualTo(expectedCar);
    }

    @Test
    public void should_return_parkingLotIds() {
        given(parkingLotFinderFactory.newParkingManager()).willReturn(parkingManager);
        given(parkingManager.listParkingLotIds()).willReturn(parkingLotIds);

        List<ParkingLotId> actualParkingLotIds = parkingLotApplicationService.listsParkingLotWithSpace();

        assertThat(actualParkingLotIds).isEqualTo(parkingLotIds);

    }

    @Test(expected = IllegalTicketException.class)
    public void should_fail_when_ticket_is_invalid() {
        parkingLotApplicationService.pick("invalid-ticket-id", parkingLotId);
    }
}