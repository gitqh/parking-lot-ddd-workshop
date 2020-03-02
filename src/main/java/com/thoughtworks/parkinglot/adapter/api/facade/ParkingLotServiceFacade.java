package com.thoughtworks.parkinglot.adapter.api.facade;

import com.thoughtworks.parkinglot.adapter.api.facade.dto.ParkingDTO;
import com.thoughtworks.parkinglot.adapter.api.facade.dto.PickingDTO;
import com.thoughtworks.parkinglot.application.ParkingApplicationService;
import com.thoughtworks.parkinglot.domain.model.parkinglot.Car;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotId;
import com.thoughtworks.parkinglot.domain.model.parkinglot.Ticket;
import com.thoughtworks.parkinglot.domain.model.parkinglot.TicketId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author gitqh
 */
@Service
@AllArgsConstructor
public class ParkingServiceFacade {
    private final ParkingApplicationService parkingApplicationService;

    public Ticket park(ParkingDTO parkingDTO) {
        return parkingApplicationService.park(parkingDTO.getLicensePlate());
    }

    public Car pick(PickingDTO pickingDTO) {
        return parkingApplicationService.pick(new TicketId(pickingDTO.getTicketId()),
                new ParkingLotId(pickingDTO.getParkingLotId()));
    }
}
