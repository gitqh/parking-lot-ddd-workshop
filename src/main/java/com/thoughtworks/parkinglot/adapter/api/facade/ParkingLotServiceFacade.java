package com.thoughtworks.parkinglot.adapter.api.facade;

import com.thoughtworks.parkinglot.adapter.api.facade.dto.ParkingDTO;
import com.thoughtworks.parkinglot.adapter.api.facade.dto.PickingDTO;
import com.thoughtworks.parkinglot.adapter.api.facade.mapper.CarMapper;
import com.thoughtworks.parkinglot.adapter.api.facade.mapper.TicketMapper;
import com.thoughtworks.parkinglot.adapter.api.facade.response.CarResponse;
import com.thoughtworks.parkinglot.adapter.api.facade.response.TicketResponse;
import com.thoughtworks.parkinglot.application.ParkingLotApplicationService;
import com.thoughtworks.parkinglot.domain.model.parkinglot.ParkingLotId;
import com.thoughtworks.parkinglot.domain.model.parkinglot.TicketId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author gitqh
 */
@Service
@AllArgsConstructor
public class ParkingLotServiceFacade {
    private final ParkingLotApplicationService parkingLotApplicationService;
    private final CarMapper carMapper;
    private final TicketMapper ticketMapper;

    public TicketResponse park(final ParkingDTO parkingDTO) {
        return ticketMapper.to(parkingLotApplicationService.park(parkingDTO.getLicensePlate()));
    }

    public CarResponse pick(final PickingDTO pickingDTO) {
        return carMapper.to(parkingLotApplicationService.pick(new TicketId(pickingDTO.getTicketId()),
                new ParkingLotId(pickingDTO.getParkingLotId())));
    }
}
