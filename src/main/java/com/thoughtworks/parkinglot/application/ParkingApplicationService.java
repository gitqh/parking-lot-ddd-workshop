package com.thoughtworks.parkinglot.application;

import com.thoughtworks.parkinglot.adapter.api.facade.dto.ParkingBoyDTO;
import com.thoughtworks.parkinglot.domain.parkingBoy.model.GraduateParkingBoy;
import com.thoughtworks.parkinglot.domain.parkingBoy.model.LicensePlate;
import com.thoughtworks.parkinglot.domain.parkingBoy.model.ParkingBoyId;
import com.thoughtworks.parkinglot.domain.parkingBoy.repository.ParkingBoyRepository;
import com.thoughtworks.parkinglot.domain.ticket.model.Ticket;
import com.thoughtworks.parkinglot.domain.ticket.model.TicketId;
import com.thoughtworks.parkinglot.domain.ticket.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author gitqh
 */
@Service
@AllArgsConstructor
public class ParkingApplicationService {
    private final ParkingBoyRepository parkingBoyRepository;
    private final TicketRepository ticketRepository;

    public void parking(ParkingBoyId parkingBoyId, LicensePlate licensePlate) {
        GraduateParkingBoy parkingBoy = parkingBoyRepository.find(parkingBoyId);

        parkingBoy.park(licensePlate);
        parkingBoyRepository.save(parkingBoy);

        TicketId ticketId = new TicketId(ticketRepository.newTicketId());
        Ticket ticket = new Ticket(ticketId, licensePlate);

        ticketRepository.save(ticket);
    }

    public GraduateParkingBoy get(ParkingBoyId parkingBoyId) {
        return parkingBoyRepository.find(parkingBoyId);
    }

    public ParkingBoyDTO find(String parkingBoyId) {
        return null;
    }
}
