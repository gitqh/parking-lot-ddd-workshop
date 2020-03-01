package com.thoughtworks.parkinglot.adapter.api.facade;

import com.thoughtworks.parkinglot.adapter.api.facade.dto.ParkingBoyDTO;
import com.thoughtworks.parkinglot.adapter.api.facade.mapper.ParkingBoyDTOMapper;
import com.thoughtworks.parkinglot.application.ParkingApplicationService;
import com.thoughtworks.parkinglot.domain.parkingBoy.model.GraduateParkingBoy;
import com.thoughtworks.parkinglot.domain.parkingBoy.model.LicensePlate;
import com.thoughtworks.parkinglot.domain.parkingBoy.model.ParkingBoyId;
import com.thoughtworks.parkinglot.domain.ticket.model.Ticket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author gitqh
 */
@Service
@AllArgsConstructor
public class ParkingServiceFacade {
    private final ParkingApplicationService parkingApplicationService;
    private final ParkingBoyDTOMapper parkingBoyDTOMapper;

    public ParkingBoyDTO find(String parkingBoyId) {
        GraduateParkingBoy boy = parkingApplicationService.get(new ParkingBoyId(parkingBoyId));
        return parkingBoyDTOMapper.from(boy);
    }

    public Ticket park(String parkingBoyId, String licensePlate) {
        return parkingApplicationService.park(new ParkingBoyId(parkingBoyId), licensePlate);
    }
}
