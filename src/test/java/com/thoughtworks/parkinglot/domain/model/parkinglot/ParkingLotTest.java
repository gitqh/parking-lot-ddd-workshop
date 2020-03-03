package com.thoughtworks.parkinglot.domain.model.parkinglot;

import static org.assertj.core.api.Assertions.assertThat;

import com.thoughtworks.parkinglot.domain.exception.IllegalTicketException;
import com.thoughtworks.parkinglot.domain.exception.NoEnoughCapacityException;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {
    private ParkingLot parkingLot;
    private ParkingLotId parkingLotId;
    private String carLicensePlate;
    private Car car1;

    @Before
    public void setUp() {
        parkingLotId = new ParkingLotId("LOT001");
        parkingLot = new ParkingLot(parkingLotId, 5);
        carLicensePlate = "川A32678";
        car1 = new Car(carLicensePlate);
    }

    @Test
    public void should_return_ticket_with_correct_info() {
        Ticket ticket = parkingLot.park(new Car(carLicensePlate));

        assertThat(ticket.getId()).isNotNull();
        assertThat(ticket.getParkingLotId()).isEqualTo(parkingLotId);
        assertThat(ticket.getLicensePlate()).isEqualTo(carLicensePlate);
    }

    @Test
    public void should_return_ticket_when_park_car() {
        final Ticket ticket = parkingLot.park(car1);

        final Car car = parkingLot.pick(ticket.getId());

        assertThat(car.getLicensePlate()).isEqualTo(carLicensePlate);
    }

    @Test(expected = NoEnoughCapacityException.class)
    public void should_remind_when_parking_lot_capacity_is_not_enough() {
        final ParkingLot parkingLot = new ParkingLot(parkingLotId, 1);
        parkingLot.park(car1);
        parkingLot.park(new Car("川A30001"));
    }

    @Test(expected = IllegalTicketException.class)
    public void should_fail_when_ticket_is_invalid() {
        parkingLot.pick(TicketId.newTicketId());
    }

    @Test(expected = IllegalTicketException.class)
    public void should_fail_when_use_ticket_twice() {
        final Ticket ticket = parkingLot.park(car1);

        parkingLot.pick(ticket.getId());
        parkingLot.pick(ticket.getId());
    }
}