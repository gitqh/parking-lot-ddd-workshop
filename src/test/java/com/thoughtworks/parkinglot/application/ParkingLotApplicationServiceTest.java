package com.thoughtworks.parkinglot.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.thoughtworks.parkinglot.domain.exception.IllegalTicketException;
import com.thoughtworks.parkinglot.domain.exception.NoEnoughCapacityException;
import com.thoughtworks.parkinglot.domain.model.parkinglot.Car;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingBoy;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLot;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotId;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotRepository;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingManager;
import com.thoughtworks.parkinglot.domain.model.parkinglot.Ticket;
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
    private ParkingBoyFactory parkingBoyFactory;
    @Mock
    private ParkingManagerFactory parkingManagerFactory;
    @Mock
    private ParkingLot parkingLot;
    @Mock
    private ParkingBoy parkingBoy;
    @Mock
    private ParkingManager parkingManager;
    @Mock
    private List<ParkingLotId> parkingLotIds;

    private ParkingLotId parkingLotId;

    private ParkingLotApplicationService parkingLotApplicationService;

    @Before
    public void setUp() {
        parkingLotId = new ParkingLotId("LOT001");
        parkingLotApplicationService = new ParkingLotApplicationService(parkingLotRepository,
                parkingBoyFactory, parkingManagerFactory);
    }

    @Test
    public void should_return_ticket_by_parking_boy() {
        final String licensePlate = "川A23456";
        final String parkingBoyName = "Allen";
        final Ticket expectedTicket = Ticket.of(licensePlate, parkingLotId);
        given(parkingBoyFactory.create(parkingBoyName)).willReturn(parkingBoy);
        given(parkingBoy.find()).willReturn(Optional.of(parkingLot));
        given(parkingLot.park(Car.of(licensePlate))).willReturn(expectedTicket);

        Ticket actualTicket = parkingLotApplicationService.parkByParkingBoy(parkingBoyName, licensePlate);

        assertThat(actualTicket).isEqualTo(expectedTicket);
    }

    @Test(expected = NoEnoughCapacityException.class)
    public void should_fail_when_all_parking_lot_belong_to_boy_is_full() {
        final String licensePlate = "川A23456";
        final String parkingBoyName = "Allen";
        given(parkingBoyFactory.create(parkingBoyName)).willReturn(parkingBoy);
        given(parkingBoy.find()).willReturn(Optional.empty());

        parkingLotApplicationService.parkByParkingBoy(parkingBoyName, licensePlate);
    }

    @Test
    public void should_return_ticket_by_parking_manager() {
        final String parkingManagerName = "Ross";
        final String licensePlate = "川A23456";
        final Ticket expectedTicket = Ticket.of(licensePlate, parkingLotId);
        given(parkingManagerFactory.create(parkingManagerName)).willReturn(parkingManager);
        given(parkingManager.findParkingLot()).willReturn(Optional.of(parkingLot));
        given(parkingLot.park(Car.of(licensePlate))).willReturn(expectedTicket);

        Ticket actualTicket = parkingLotApplicationService.parkByParkingManager(licensePlate, parkingManagerName);

        assertThat(actualTicket).isEqualTo(expectedTicket);
    }

    @Test(expected = NoEnoughCapacityException.class)
    public void should_fail_when_all_parking_lot_belong_to_manager_is_full() {
        final String licensePlate = "川A23456";
        final String parkingManagerName = "Allen";
        given(parkingManagerFactory.create(parkingManagerName)).willReturn(parkingManager);
        given(parkingManager.findParkingLot()).willReturn(Optional.empty());

        parkingLotApplicationService.parkByParkingManager(licensePlate, parkingManagerName);
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
        final String parkingManagerName = "Allen";
        given(parkingManagerFactory.create(parkingManagerName)).willReturn(parkingManager);
        given(parkingManager.listParkingLotIds()).willReturn(parkingLotIds);

        List<ParkingLotId> actualParkingLotIds = parkingLotApplicationService.listsParkingLotWithSpace(parkingManagerName);

        assertThat(actualParkingLotIds).isEqualTo(parkingLotIds);

    }

    @Test(expected = IllegalTicketException.class)
    public void should_fail_when_ticket_is_invalid() {
        final ParkingLotApplicationService parkingLotApplicationService =
                new ParkingLotApplicationService(parkingLotRepository, parkingBoyFactory, parkingManagerFactory);

        parkingLotApplicationService.pick("invalid-ticket-id", parkingLotId);
    }
}