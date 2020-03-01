package com.thoughtworks.parkinglot.application;

import com.thoughtworks.parkinglot.adapter.api.facade.dto.ParkingBoyDTO;
import com.thoughtworks.parkinglot.domain.parkingBoy.model.GraduateParkingBoy;
import com.thoughtworks.parkinglot.domain.parkingBoy.model.LicensePlate;
import com.thoughtworks.parkinglot.domain.parkingBoy.model.ParkingBoyId;
import com.thoughtworks.parkinglot.domain.parkingBoy.repository.ParkingBoyRepository;
import com.thoughtworks.parkinglot.domain.ticket.model.Ticket;
import com.thoughtworks.parkinglot.domain.ticket.model.TicketId;
import com.thoughtworks.parkinglot.domain.ticket.repository.TicketRepository;
import javax.transaction.Transactional;
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

    @Transactional
    public Ticket park(ParkingBoyId parkingBoyId, String number) {
        GraduateParkingBoy parkingBoy = parkingBoyRepository.find(parkingBoyId);

        parkingBoy.park(number);
        parkingBoyRepository.save(parkingBoy);

        TicketId ticketId = new TicketId(ticketRepository.newTicketId());
        Ticket ticket = new Ticket(ticketId, number);

        ticketRepository.save(ticket);
        return ticket;
    }

    public GraduateParkingBoy get(ParkingBoyId parkingBoyId) {
        return parkingBoyRepository.find(parkingBoyId);
    }
}
